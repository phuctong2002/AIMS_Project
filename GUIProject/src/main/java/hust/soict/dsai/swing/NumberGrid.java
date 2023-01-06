package hust.soict.dsai.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberGrid extends JFrame {
    private JButton[] btnNumbers = new JButton[10];
    private JButton btnDelete, btnReset;
    private JTextField tfDisplay;
    public NumberGrid(){
        tfDisplay = new JTextField();
        tfDisplay.setComponentOrientation( ComponentOrientation.RIGHT_TO_LEFT);
        tfDisplay.setSize( 200, 60);
        JPanel panelButtons = new JPanel( new GridLayout( 4, 3));
        addButtons(panelButtons);
        Container cp = getContentPane();
        cp.setLayout( new BorderLayout());
        cp.add( tfDisplay, BorderLayout.NORTH);
        cp.add( panelButtons, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Number grid");
        setSize(300, 300);
        setVisible( true);
    }

    private void addButtons(JPanel panelButtons) {
        ButtonListener btnListener = new ButtonListener();
        for( int i = 1; i <= 9; ++i){
            btnNumbers[i] = new JButton(""+i);
            panelButtons.add( btnNumbers[i]);
            btnNumbers[i].addActionListener(btnListener);
        }
        btnDelete = new JButton("DEL");
        panelButtons.add(btnDelete);
        btnDelete.addActionListener(btnListener);
        btnNumbers[0] = new JButton("0");
        panelButtons.add(btnNumbers[0]);
        btnNumbers[0].addActionListener(btnListener);
        btnReset = new JButton("C");
        panelButtons.add(btnReset);
        btnReset.addActionListener( btnListener);
    }
    public class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String button = e.getActionCommand();
            System.out.println(button);
            if( button.charAt(0) >= '0' && button.charAt(0) <= '9'){
                tfDisplay.setText(tfDisplay.getText() + button);
            }else if( button.equals("DEL")){
                String str = tfDisplay.getText();
                if( str.length() > 0)
                    tfDisplay.setText(str.substring(0, str.length() - 1));
                else tfDisplay.setText("");
            }else{
                tfDisplay.setText("");
            }
        }
    }
    public static void main( String[] args){
        NumberGrid tmp = new NumberGrid();
    }
}
