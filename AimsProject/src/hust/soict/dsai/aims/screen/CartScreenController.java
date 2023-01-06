package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.Aims;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

import javax.swing.*;
import java.util.ArrayList;


public class CartScreenController {
    private Cart cart;

    @FXML
    private BorderPane root;

    @FXML
    private TextField tfFilter;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;
    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;
    @FXML
    private TableColumn<Media, String> colMediacategory;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private Label totalCost;



    public CartScreenController(Cart cart){
        this.cart = cart;
    }

    @FXML
    public void initialize(){
        colMediaTitle.setCellValueFactory( new PropertyValueFactory<Media, String>("title"));
        colMediacategory.setCellValueFactory( new PropertyValueFactory<Media, String>("Category"));
        colMediaCost.setCellValueFactory( new PropertyValueFactory<Media, Float>("Cost"));
        tblMedia.setItems( this.cart.getItemsOrdered());
        totalCost.setText( Float.toString( getCost()));
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);
        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Media>(){
                    @Override
                    public void changed(ObservableValue<? extends Media> observableValue, Media media, Media t1) {
                        if( t1 != null){
                            updateButtonBar(t1);
                        }
                    }
                    private void updateButtonBar(Media t1) {
                        btnRemove.setVisible( true);
                        if( t1 instanceof Playable){
                            btnPlay.setVisible( true);
                        }else{
                            btnPlay.setVisible( false);
                        }
                    }
                }
        );
        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                showFilteredMedia( t1);
            }
            private void showFilteredMedia(String t1) {
                System.out.println( t1);
                if( t1.length() == 0){
                    tblMedia.setItems( cart.getItemsOrdered());
                    return;
                }
                if( radioBtnFilterId.isSelected()){
                    try{
                        tblMedia.setItems(cart.searchById(Integer.parseInt(t1)));
                    }catch(Exception e){
                        System.out.println("invalid input");
                        tblMedia.setItems(cart.searchById(-1));
                    }
                }else{
                    tblMedia.setItems(cart.searchByTitle( t1));
                }
            }
        });
    }
    @FXML
    public void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia( media);
        totalCost.setText( Float.toString( getCost()));
    }

    public float getCost(){
        float cost = 0;
        ObservableList<Media> items = cart.getItemsOrdered();
        for( Media item : items ){
            cost += item.getCost();
        }
        return cost;
    }
    @FXML
    void orderAction(ActionEvent event) {
        cart.emptyCart();
        totalCost.setText( Float.toString( getCost()));
    }
    @FXML
    public void viewStore(ActionEvent event) {
        Aims.getStoreScreen().setVisible(true);
        Aims.getCartScreen().setVisible(false);
    }
    public void updateCost(){
        totalCost.setText( Float.toString( getCost()));
    }

    public Label getTotalCost() {
        return totalCost;
    }


    @FXML
    void addBook(ActionEvent event) {
        Aims.getCartScreen().setVisible(false);
        Aims.getAddBookScreen().setVisible(true);
    }

    @FXML
    void addCD(ActionEvent event) {
        Aims.getCartScreen().setVisible(false);
        Aims.getAddCDScreen().setVisible(true);
    }

    @FXML
    void addDVD(ActionEvent event) {
        Aims.getCartScreen().setVisible(false);
        Aims.getAddDVDScreen().setVisible(true);
    }


    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        try{
            ((Playable) media).play();
        }catch ( PlayerException e){
            JOptionPane.showMessageDialog( Aims.getCartScreen(), e.getMessage(), "Alert", JOptionPane.ERROR_MESSAGE);
        }
    }
}
