package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class AddBookScreen extends JFrame {
    private Store store;

    public AddBookScreen( Store store){
        super();
        this.store = store;
        JFXPanel jfxPanel = new JFXPanel();
        this.setPreferredSize( new Dimension( 1024, 768));
        this.setTitle("Store");
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    AddingBookController controller = new AddingBookController( store);
                    FXMLLoader loader = new FXMLLoader( getClass().getResource("/hust/soict/dsai/aims/screen/addBook.fxml"));
                    loader.setController(controller);
                    Parent root = loader.load();
                    jfxPanel.setScene( new Scene(root));
                } catch ( IOException e ){
                    e.printStackTrace();
                }
            }
        });

        this.setVisible( false);
        this.add( jfxPanel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
    }
}
