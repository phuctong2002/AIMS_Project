package hust.soict.dsai.cart;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.disc.DigitalVideoDisc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
    public void addMedia(Media media) {
        if( itemsOrdered.size() == MAX_NUMBERS_ORDERED){
            System.out.println("hust.soict.dsai.cart.Cart full");
        }else{
            for( int i = 0; i < itemsOrdered.size(); i++){
                if( itemsOrdered.get(i).equals(media)){
                    System.out.println("Item exist");
                    return;
                }
            }
            itemsOrdered.add( media);
        }
    }
    public void removeMedia(Media media){
        for( int i = 0; i < itemsOrdered.size(); ++i){
            if( itemsOrdered.get(i).equals(media)){
                itemsOrdered.remove(i);
                return;
            }
        }
        System.out.println("Item not found");
    }
    public float totalCost(){
        float sum = 0;
        for( int i = 0; i < itemsOrdered.size(); ++i){
            sum += itemsOrdered.get(i).getCost();
        }
        return sum;
    }

    public void print(){
        for( int i = 0; i < itemsOrdered.size(); ++i){
            itemsOrdered.get(i).toString();
        }
        System.out.println("Total cost : " + totalCost());
    }

    public void searchById( int id){
        int qty = 0;
        for( int i = 0; i < itemsOrdered.size(); ++i){
            if( id == itemsOrdered.get(i).getId() ){
                ++qty;
                itemsOrdered.get(i).toString();
            }
        }
        if( qty == 0){
            System.out.println("Not found");
        }
    }

    public void searchByTitle( String title){
        int qty = 0;
        for( int i = 0; i < itemsOrdered.size(); ++i ){
            if( title == itemsOrdered.get(i).getTitle() ){
                ++qty;
                itemsOrdered.get(i).toString();
            }
        }
        if( qty == 0 ){
            System.out.println("Not found");
        }
    }
    public void sortByCostTitle(){
        Collections.sort( itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }
    public void sortByTitleCost(){
        Collections.sort( itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }

}
