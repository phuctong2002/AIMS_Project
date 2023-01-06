package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.Aims;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.util.zip.DataFormatException;

public class AddDVDController {
    private Store store;
    @FXML
    private TextField cost;

    @FXML
    private TextField director;

    @FXML
    private TextField title;

    @FXML
    private TextField category;

    @FXML
    void addDVD(ActionEvent event) {

        String tt = title.getText();
        String ct = cost.getText();
        String ctg = category.getText();
        String dt = director.getText();
        try{
            if(tt.length() == 0 || ct.length() == 0 || ctg.length() == 0 || dt.length() == 0)
                throw new DataFormatException("Please fill add field");
            float tmpCost = Float.parseFloat( ct);
            DigitalVideoDisc newDVD = new DigitalVideoDisc(  dt, ctg,tt, tmpCost);
            if( store.getItemsInStore().contains( newDVD))
                throw new Exception("Item exist in store");
            store.addMedia( newDVD);
            title.setText("");
            director.setText("");
            category.setText("");
            cost.setText("");
            JOptionPane.showMessageDialog( Aims.getAddDVDScreen(), "Added " + tt, "Alert", JOptionPane.INFORMATION_MESSAGE);
        }catch ( Exception e){
            System.out.println( e.getMessage());
            JOptionPane.showMessageDialog( Aims.getAddDVDScreen(), e.getMessage(), "Alert", JOptionPane.ERROR_MESSAGE);

        }
    }

    public AddDVDController( Store store){
        this.store = store;
    }

    @FXML
    void addBook(ActionEvent event) {
        Aims.getAddBookScreen().setVisible(true);
        Aims.getAddDVDScreen().setVisible(false);
    }

    @FXML
    void addCD(ActionEvent event) {
        Aims.getAddDVDScreen().setVisible(false);
        Aims.getAddCDScreen().setVisible(true);
    }

    @FXML
    void viewStore(ActionEvent event) {
        Aims.getStoreScreen().setVisible(true);
        Aims.getAddDVDScreen().setVisible(false);
    }

    @FXML
    void viewCart(ActionEvent event) {
        Aims.getCartScreen().setVisible(true);
        Aims.getAddDVDScreen().setVisible(false);
    }
}
