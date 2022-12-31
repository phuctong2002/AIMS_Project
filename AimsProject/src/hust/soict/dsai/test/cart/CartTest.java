package hust.soict.dsai.test.cart;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Book;

import java.util.Scanner;

public class CartTest {
    public static void main(String[] args){
        Cart anOrder = new Cart();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc( "The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addMedia( dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addMedia( dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Animation", "Aladin", 18.99f);
        anOrder.addMedia(dvd3);
        Book book1 = new Book( 1, "vat li dai cuong", "Physic");
        Book book2 = new Book( 2, "toan hoc", "Math");
        Book book3 = new Book( 3, "toan koc", "Math");
        anOrder.addMedia(book3);
        anOrder.addMedia(book2);
        anOrder.addMedia(book1);
        anOrder.sortByTitleCost();
        anOrder.printList();
//        Scanner in = new Scanner( System.in);
//        String a = in.nextLine();
//        int c = in.nextInt();
//        String b = in.nextLine();
//        System.out.println( a.length() + "*****" + b + "******");

    }
}
