package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.naming.LimitExceededException;
import java.util.Collections;


public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;

    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
    public void addMedia( Media media){
        try{
            if( itemsOrdered.size() == MAX_NUMBERS_ORDERED)
                throw new LimitExceededException("Cart full");
            if( itemsOrdered.contains(media)){
//                System.out.println("Media exist");
                throw new Exception("Media exist");
            }
            itemsOrdered.add(media);
        }catch ( Exception e){
            System.out.println( e.getMessage());
        }
    }
    public void removeMedia( Media media){
        if( itemsOrdered.contains( media)){
            itemsOrdered.remove( itemsOrdered.indexOf( media));
            System.out.println("Remove successfully");
        }else{
            System.out.println("DVD don't exist");
        }
    }

    public float totalCost(){
        float total = 0;
        for(Media media : itemsOrdered){
            total += media.getCost();
        }
        return total;
    }


    public void printList(){
        float total = 0;
        for( Media media: itemsOrdered){
            System.out.println( media.toString());
            total += media.getCost();
        }
        System.out.println( "Total cost : " + total);
    }


    public ObservableList<Media> searchById( int id){
        ObservableList<Media> itemSearchById = FXCollections.observableArrayList();
        int flags = 0;
        for( Media media : itemsOrdered){
            if( media.getId() == id){
                System.out.println( media.toString());
                itemSearchById.add( media );
                flags = 1;
            }
        }
        if( flags == 0)
            System.out.println("Not found");
        return itemSearchById;
    }

    public ObservableList<Media> searchByTitle( String title){
        int flag = 0;
        ObservableList<Media> itemSearchByTitle = FXCollections.observableArrayList();
        for( Media media : itemsOrdered){
            if( media.getTitle().equals( title)){
                System.out.println( media.toString());
                itemSearchByTitle.add(media);
                flag = 1;
            }
        }
        if( flag == 0){
            System.out.println("Not found");
        }
        return itemSearchByTitle;
    }

    public void sortByTitleCost(){
        Collections.sort( itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }
    public void sortByCostTitle(){
        Collections.sort( itemsOrdered, Media.COMPARE_BY_COST_TITLE );
    }

    public void emptyCart(){
        itemsOrdered.clear();
    }

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

}
