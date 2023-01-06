package hust.soict.dsai.test.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

import java.util.ArrayList;
import java.util.List;

public class StoreTest {
    public static void main( String[] args){
        Store store = new Store();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        store.addMedia( dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star War", "Science Fiction", "George Lucas", 87, 24.95f);
        store.addMedia(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Animation", "Aladin", 18.99f);
        store.addMedia(dvd3);
        Book book1 = new Book( "vat li", "Physic", 23);
        store.addMedia(book1);
        Book book2 = new Book( "vat li", "Physic", 11);
        store.addMedia(book2);
        List<Media> media = new ArrayList<Media>();
        media.add( new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        media.add( new Book(  "vat li", "Physic", 10));
        media.add( new CompactDisc( 1, "CD1", "Music USA", 1000));
        for( Media a : media){
            System.out.println( a.toString());
        }
    }
}
