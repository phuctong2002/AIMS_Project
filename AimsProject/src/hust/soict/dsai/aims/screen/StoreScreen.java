package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.Aims;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;


public class StoreScreen extends JFrame {
    private Store store;
    private Cart cart;
    private Container cp;
//    private JPanel centerComponent;
    public StoreScreen(Store store, Cart cart){
        this.cart = cart;
        this.store = store;
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                super.componentShown(e);
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        cp.remove( cp.getComponents()[1]);
                        cp.add( createCenter(), BorderLayout.CENTER);
                        cp.repaint();
                        cp.validate();
                    }
                });
            }
        });
        cp = getContentPane();
        cp.setLayout( new BorderLayout());
        JPanel north = createNorth();
        north.add( createMenuBar());
        north.add( createHeader());
        cp.add( north, BorderLayout.NORTH);
        JPanel centerComponent = createCenter();
        cp.add( centerComponent, BorderLayout.CENTER);
        setVisible(true);
        setTitle("Store");
        setSize( 1024, 768);
        this.setLocationRelativeTo( null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
    }
    public JPanel createNorth(){
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout( north, BoxLayout.Y_AXIS ));
        return north;
    }
    public JMenuBar createMenuBar(){
        JMenu menu = new JMenu("Options");
        JMenu smUpdateStore = new JMenu("Update Store");
        JMenuItem addBook = new JMenuItem("Add Book");
        addBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Aims.getAddBookScreen().setVisible( true);
                Aims.getStoreScreen().setVisible(false);
            }
        });
        smUpdateStore.add( addBook);
        JMenuItem addCD = new JMenuItem("Add CD");
        addCD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Aims.getAddCDScreen().setVisible( true);
                Aims.getStoreScreen().setVisible(false);
            }
        });
        smUpdateStore.add( addCD);
        JMenuItem addDVD = new JMenuItem("Add DVD");
        addDVD.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Aims.getAddDVDScreen().setVisible(true);
                Aims.getStoreScreen().setVisible(false);
            }
        });
        smUpdateStore.add(addDVD);
        menu.add(smUpdateStore);
        JMenuItem viewCart = new JMenuItem("View Cart");
        viewCart.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Aims.getStoreScreen().setVisible(false);
                Aims.getCartScreen().setVisible(true);
            }
        });
        menu.add( new JMenuItem("View store"));
        menu.add( viewCart);
        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout( new FlowLayout( FlowLayout.LEFT));
        menuBar.add( menu);
        return menuBar;
    }
    public JPanel createHeader(){
        JPanel header = new JPanel();
        header.setLayout( new BoxLayout( header, BoxLayout.X_AXIS));
        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 40));
        title.setForeground(Color.CYAN);
        JButton cart = new JButton("View Cart");
        cart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Aims.getStoreScreen().setVisible(false);
                Aims.getCartScreen().setVisible(true);
            }
        });
        cart.setPreferredSize( new Dimension(100, 40));
        cart.setMaximumSize(new Dimension(100, 40));
        header.add( Box.createRigidArea( new Dimension( 10, 10)));
        header.add( title);
        header.add( Box.createHorizontalGlue());
        header.add( cart);
        header.add( Box.createRigidArea( new Dimension( 10, 10)));
        return header;
    }
    public JPanel createCenter(){
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        List<Media> mediaInStore = store.getItemsInStore();
        for(int i = 0; i< mediaInStore.size(); i++){
            MediaStore cell = new MediaStore(mediaInStore.get(i));
            center.add(cell);
        }
        return center;
    }
    public class MediaStore extends JPanel{
        private Media media;
        public MediaStore( Media media){
            this.media = media;
            this.setLayout( new BoxLayout(this, BoxLayout.Y_AXIS));
            JLabel title = new JLabel( media.getTitle());
            title.setFont( new Font(title.getFont().getName(), Font.PLAIN, 20));
            title.setAlignmentX( CENTER_ALIGNMENT);
            JLabel cost = new JLabel(""+media.getCost()+"$");
            cost.setAlignmentX(CENTER_ALIGNMENT);
            JPanel container = new JPanel();
            container.setLayout( new FlowLayout( FlowLayout.CENTER));
            JButton add = new JButton("Add to cart");
            add.addActionListener( new HandlerEvent( media, cart));

            container.add( add);
            if( media instanceof Playable){
                JButton play = new JButton("Play");
                play.addActionListener(new HandlerEvent( media, cart));
                container.add( play);
            }
            this.add( Box.createVerticalGlue());
            this.add( title);
            this.add( cost);
            this.add( Box.createVerticalGlue());
            this.add( container);
            this.setBorder( BorderFactory.createLineBorder(Color.BLACK));
        }
    }
    public class HandlerEvent implements ActionListener{
        private Media media;
        private Cart cart;

        public HandlerEvent( Media media, Cart cart){
            this.media = media;
            this.cart = cart;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            String cmd = e.getActionCommand();
            System.out.println(cmd);
            if( cmd.equals("Play")){
                try{
                    if( media instanceof Playable){
                        ((Playable)media).play();
                    }
                }catch ( PlayerException error){
                    JOptionPane.showMessageDialog(Aims.getStoreScreen(), error.getMessage(), "Alert", JOptionPane.ERROR_MESSAGE);
                }
            }else if( cmd.equals("Add to cart")){
                try{
                    if( cart.getItemsOrdered().contains( media))
                        throw new Exception("Item exist in cart");
                    cart.addMedia( media);
                    JOptionPane.showMessageDialog(Aims.getStoreScreen(), "Added " + media.getTitle(), "Alert", JOptionPane.PLAIN_MESSAGE);
                }catch(Exception error){
                    System.out.println(error.getMessage());
                    JOptionPane.showMessageDialog(Aims.getStoreScreen(), "Item " + media.getTitle() + " exist in cart", "Alert", JOptionPane.ERROR_MESSAGE);
                }

            }
        }
    }
    public class UpdateUI extends  ComponentAdapter{

        public void componentShown(ComponentEvent e) {
            /* code run when component shown */
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    cp.remove( cp.getComponents()[1]);
                    cp.add( createCenter(), BorderLayout.CENTER);
                    cp.repaint();
                    cp.validate();
                }
            });

        }
    }
}
