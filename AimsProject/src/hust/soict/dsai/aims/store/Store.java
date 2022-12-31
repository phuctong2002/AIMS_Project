package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Media> itemsInStore = new ArrayList<Media>();


    public void addMedia(Media media) {
        if( itemsInStore.contains(media)){
            System.out.println("Item exist in store");
            return;
        }
        itemsInStore.add( media);
        System.out.println( "Add successfully");
    }

    public void removeMedia( Media media){
        if( itemsInStore.contains( media)){
            itemsInStore.remove( itemsInStore.indexOf(media));
            System.out.println("Remove successfully");
        }else{
            System.out.println("Item not found in store");
        }
    }
    public void printList(){

        for( Media media: itemsInStore){
            System.out.println( media.toString());
        }
    }

    public Media searchByTitle( String title){
        for( int i = 0; i < itemsInStore.size(); ++i){
            if( itemsInStore.get(i).getTitle().equals(title)){
                return itemsInStore.get(i);
            }
        }
        System.out.println("Media don't exist");
        return null;
    }

}
