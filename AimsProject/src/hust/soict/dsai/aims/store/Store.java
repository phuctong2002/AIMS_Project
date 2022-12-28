package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.disc.DigitalVideoDisc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();
    public void addMedia( Media media){
        for( int i = 0; i < itemsInStore.size(); ++i){
            if( itemsInStore.get(i).equals( media)){
                System.out.println("Item exist");
                return ;
            }
        }
        itemsInStore.add(media);
    }

    public void removeMedia( Media media){
        for( int i = 0; i < itemsInStore.size(); i++){
            if( itemsInStore.get(i).equals( media)){
                itemsInStore.remove(i);
                return;
            }
        }
        System.out.println("Item not found");

    }
    public void showStore(){
        for( int i = 0;  i < itemsInStore.size(); i++){
            System.out.println("Title : " + itemsInStore.get(i).getTitle());
        }
    }
    public Media searchByTitle( String title){
        for( int i = 0; i < itemsInStore.size(); ++i){
            if( itemsInStore.get(i).getTitle().equals( title) ){
                itemsInStore.get(i).myToString();
                return itemsInStore.get(i);
            }
        }
        System.out.println("Item not found");
        return null;
    }
}
