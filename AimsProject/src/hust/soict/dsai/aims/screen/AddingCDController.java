package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.Aims;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.util.zip.DataFormatException;

public class AddingCDController {
    private Store store;
    @FXML
    private TextField cost;

    @FXML
    private TextField artist;

    @FXML
    private TextField title;

    @FXML
    private TextField category;

    @FXML
    void addCD(ActionEvent event) {
        String tt = title.getText();
        String ct = cost.getText();
        String at = artist.getText();
        String ctg = category.getText();

        try{
            if( tt.length() == 0 || ct.length() == 0 || at.length() == 0 || ctg.length() == 0)
                throw new DataFormatException("Please fill all fields");
            float tmpCost = Float.parseFloat( ct);
            CompactDisc newCD = new CompactDisc(tt, ctg, tmpCost, at);
            if( store.getItemsInStore().contains( newCD))
                throw new Exception("Item exist in store");
            store.addMedia( newCD);
            title.setText("");
            artist.setText("");
            category.setText("");
            cost.setText("");
            JOptionPane.showMessageDialog( Aims.getAddCDScreen(), "Added " + tt, "Alert", JOptionPane.INFORMATION_MESSAGE);
//
//            Alert alert = new Alert( Alert.AlertType.INFORMATION, "Added " + tt);
//            alert.setTitle("Alert");
//            alert.showAndWait();
        }catch ( Exception e){
            System.out.println( e.getMessage());
//            Alert alert = new Alert( Alert.AlertType.ERROR, e.getMessage());
//            alert.setTitle("Alert");
//            alert.showAndWait();
            JOptionPane.showMessageDialog( Aims.getAddCDScreen(), e.getMessage(), "Alert", JOptionPane.ERROR_MESSAGE);

        }
    }

    public AddingCDController( Store store){
        this.store = store;
    }
    @FXML
    void addBook(ActionEvent event) {
        Aims.getAddBookScreen().setVisible(true);
        Aims.getAddCDScreen().setVisible(false);
    }

    @FXML
    void addDVD(ActionEvent event) {
        Aims.getAddDVDScreen().setVisible(true);
        Aims.getAddCDScreen().setVisible(false);
    }

    @FXML
    void viewStore(ActionEvent event) {
        Aims.getAddCDScreen().setVisible(false);
        Aims.getStoreScreen().setVisible(true);
    }

    @FXML
    void viewCart(ActionEvent event) {
        Aims.getAddCDScreen().setVisible(false);
        Aims.getCartScreen().setVisible(true);
    }

}
