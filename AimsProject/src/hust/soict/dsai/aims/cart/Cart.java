package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;

    private List<Media> itemsOrdered = new ArrayList<Media>();

    public void addMedia( Media media){
        if( itemsOrdered.size() == MAX_NUMBERS_ORDERED){
            System.out.println("Cart full");
        }else{
//            for( int i = 0; i < itemsOrdered.size(); ++i){
//                if( itemsOrdered.get(i).equals( media)){
//                    System.out.println("DVD exist");
//                    return;
//                }
//            }
            if( itemsOrdered.contains(media)){
                System.out.println("Media exist");
                return;
            }
            itemsOrdered.add(media);
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


    public void searchById( int id){
        for( Media media : itemsOrdered){
            if( media.getId() == id){
                System.out.println( media.toString());
                return;
            }
        }
        System.out.println("Not found");
    }

    public void searchByTitle( String title){
        int flag = 0;
        for( Media media : itemsOrdered){
            if( media.getTitle().equals( title)){
                System.out.println( media.toString());
                flag = 1;
            }
        }
        if( flag == 0){
            System.out.println("Not found");
        }
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
}
