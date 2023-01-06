package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.Aims;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.util.zip.DataFormatException;

public class AddingBookController {

    private Store store;
    @FXML
    private TextField cost;

    @FXML
    private TextField author;

    @FXML
    private TextField title;

    @FXML
    private TextField category;

    @FXML
    void addBook(ActionEvent event) {

        String titleBook = title.getText();
        String costBook = cost.getText();
        String authorBook = author.getText();
        String categoryBook = category.getText();

        try{
            if( titleBook.length() == 0 || costBook.length() == 0 || authorBook.length() == 0 || categoryBook.length() == 0)
                throw new DataFormatException("Please fill all fields");

            float tmp = Float.parseFloat( costBook);
            Book newBook = new Book(title.getText(), category.getText(), Float.parseFloat( cost.getText()));
            if( store.getItemsInStore().contains( newBook))
                throw new Exception("Item exist in store");
            System.out.println("************************");
            System.out.println("************************");
            newBook.addAuthor( author.getText());
            store.addMedia( newBook);
            title.setText("");
            author.setText("");
            category.setText("");
            cost.setText("");
            JOptionPane.showMessageDialog( Aims.getAddBookScreen(), "Added " + titleBook, "Alert", JOptionPane.INFORMATION_MESSAGE);

//            Alert alert = new Alert( Alert.AlertType.INFORMATION, "Added " + titleBook);
//            alert.setTitle("Alert");
//            alert.showAndWait();
        }catch ( Exception e){
            System.out.println(e.getMessage());
//            Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage());
//            alert.setTitle("Alert");
//            alert.showAndWait();
            JOptionPane.showMessageDialog( Aims.getAddBookScreen(), e.getMessage(), "Alert", JOptionPane.ERROR_MESSAGE);

        }
    }

    public AddingBookController( Store store){
        this.store = store;
    }
    @FXML
    void addCD(ActionEvent event) {
        Aims.getAddCDScreen().setVisible(true);
        Aims.getAddBookScreen().setVisible(false);

    }

    @FXML
    void addDVD(ActionEvent event) {
        Aims.getAddDVDScreen().setVisible(true);
        Aims.getAddBookScreen().setVisible(false);

    }

    @FXML
    void viewStore(ActionEvent event) {
        Aims.getStoreScreen().setVisible(true);
        Aims.getAddBookScreen().setVisible(false);

    }

    @FXML
    void viewCart(ActionEvent event) {
        Aims.getCartScreen().setVisible(true);
        Aims.getAddBookScreen().setVisible(false);
    }
}
