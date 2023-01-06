package hust.soict.dsai.test.cart;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.screen.CartScreen;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Scanner;

public class CartTest {
    public static void main(String[] args) {
        Cart anOrder = new Cart();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc( "The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addMedia( dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addMedia( dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Animation", "Aladin", 18.99f);
        anOrder.addMedia(dvd3);
        Book book1 = new Book(  "vat li dai cuong", "Physic", 12);
        Book book2 = new Book( "toan hoc", "Math", 34);
        Book book3 = new Book(  "toan koc", "Math", 2);
        anOrder.addMedia(book3);
        anOrder.addMedia(book2);
        anOrder.addMedia(book1);
        anOrder.sortByTitleCost();
        anOrder.printList();
        CartScreen cartScreen = new CartScreen( anOrder);
    }


}
