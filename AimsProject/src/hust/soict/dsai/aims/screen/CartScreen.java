package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.IOException;


public class CartScreen extends JFrame {
    private Cart cart;
    public CartScreen( Cart cart){
        super();
        this.cart = cart;
        JFXPanel fxPanel = new JFXPanel();
        this.setPreferredSize( new Dimension(1024, 768));
        this.setTitle("Cart");
        CartScreenController controller = new CartScreenController( cart);
        this.setVisible( false);
        this.add( fxPanel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        Platform.runLater( new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader( getClass().getResource("/hust/soict/dsai/aims/screen/cart.fxml"));
                    loader.setController(controller);
                    Parent root = loader.load();
                    fxPanel.setScene( new Scene(root));
                } catch ( IOException e ){
                    e.printStackTrace();
                }
            }
        });
        this.addComponentListener( new ComponentAdapter(){
                    public void componentShown(ComponentEvent e) {
                        /* code run when component shown */
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                controller.getTotalCost().setText( Float.toString( cart.totalCost()));
                            }
                        });
                    }
                });
    }
}

