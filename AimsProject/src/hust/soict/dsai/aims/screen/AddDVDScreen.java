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

public class AddDVDScreen extends JFrame {
    private Store store;
    public AddDVDScreen( Store store){
        super();
        this.store = store;
        JFXPanel jfxPanel = new JFXPanel();
        this.setPreferredSize( new Dimension(1024, 768));
        this.setTitle("Store");
        Platform.runLater( new Runnable(){
            @Override
            public void run() {
                try{
                    AddDVDController controller = new AddDVDController( store);
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/dsai/aims/screen/addDVD.fxml"));
                    loader.setController( controller);
                    Parent root = loader.load();
                    jfxPanel.setScene( new Scene(root));
                }catch( IOException e){
                    e.printStackTrace();
                }
            }
        });
        this.setVisible(false);
        this.add(jfxPanel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
    }
}
