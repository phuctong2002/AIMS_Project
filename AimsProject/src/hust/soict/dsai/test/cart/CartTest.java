package hust.soict.dsai.test.cart;

import hust.soict.dsai.cart.Cart;
import hust.soict.dsai.disc.DigitalVideoDisc;

public class CartTest {
    public static void main( String[] args ){
        Cart cart = new Cart();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addMedia( dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star War", "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addMedia(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Animation", "Aladin", 18.99f);
        cart.addMedia(dvd3);
        cart.addMedia( new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        cart.print();

    }
}
