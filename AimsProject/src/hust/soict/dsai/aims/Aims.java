package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.screen.*;
import hust.soict.dsai.aims.store.Store;

import java.util.Scanner;

public class Aims {
    private static Store store;
    private static Cart cart;
    private static StoreScreen storeScreen;
    private static CartScreen cartScreen;

    private static AddBookScreen addBookScreen;
    private static AddCDScreen addCDScreen;
    private static AddDVDScreen addDVDScreen;

    public static AddDVDScreen getAddDVDScreen() {
        return addDVDScreen;
    }

    public static void main(String[] args) {
        store = new Store();
        store.addMedia( new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 23.2f));
        store.addMedia( new Book(  "vat li 1", "Physic", 12));
        store.addMedia( new CompactDisc( 1, "CD1", "Music USA", 0));
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Get Out", "Animation", "Roger Allers", 87, 1.5f);
        store.addMedia( dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star War", "Science Fiction", "George Lucas", 87, 23.5f);
        store.addMedia(dvd2);
        Book book1 = new Book( "vat li 2", "Physic", 23);
        store.addMedia(book1);
        cart = new Cart();
        cartScreen = new CartScreen( cart);
        storeScreen = new StoreScreen( store, cart);
        addBookScreen = new AddBookScreen( store);
        addCDScreen = new AddCDScreen(store);
        addDVDScreen = new AddDVDScreen( store);
    }

    public static AddBookScreen getAddBookScreen() {
        return addBookScreen;
    }

    public static AddCDScreen getAddCDScreen() {
        return addCDScreen;
    }

    private static void showMenu(){
        while( true){
            int choose = 0;
            System.out.println("AIMS: ");
            System.out.println("--------------------------------");
            System.out.println("1. View store");
            System.out.println("2. Update store");
            System.out.println("3. See current cart");
            System.out.println("0. Exit");
            System.out.println("--------------------------------");
            System.out.print("Please choose a number 0-1-2-3 : ");
            Scanner in = new Scanner(System.in);
            choose = in.nextInt();
            in.nextLine();
            if( choose == 1){
                store.printList();
                storeMenu();
            }else if( choose == 2){
                // update store


            }else if( choose == 3){
                // see current cart
                cart.printList();
                cartMenu();
            }else if( choose == 0) break;

        }

    }
    private static void storeMenu() {
        while( true){
            int choose = 0;
            Scanner in = new Scanner(System.in);
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. See a media’s details");
            System.out.println("2. Add a media to cart");
            System.out.println("3. Play a media");
            System.out.println("4. See current cart");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.print("Please choose a number 0-1-2-3-4 : ");
            choose = in.nextInt();
            in.nextLine();
            if( choose == 1){
                System.out.print("Please enter title of media : ");
                String title = in.nextLine();
                Media media = store.searchByTitle(title);
                System.out.println( media.toString());
                if( media != null){
                    if( media instanceof DigitalVideoDisc || media instanceof CompactDisc){
                        mediaDetailsMenu();
                    }else{
                        mediaDetailsMenu1();
                    }
                }

            }else if( choose == 2){

            }else if( choose == 3){

            }else if( choose == 4){
                cart.printList();
            }else if( choose == 0) break;
        }

    }
    private static void mediaDetailsMenu() {
        while( true){
            int choose = 0;
            store.printList();
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add to cart");
            System.out.println("2. Play");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number 0-1-2 : ");
            Scanner in = new Scanner( System.in);
            choose = in.nextInt();
            in.nextLine();
            if( choose == 1){
                String title = in.nextLine();
                Media media = store.searchByTitle(title);
                if( media != null){
                    // add into the cart
                    cart.addMedia( media);
                }
            }else if( choose == 2){

            }else if(choose == 0) break;
        }

    }
    private static void mediaDetailsMenu1() {
        while( true){
            store.printList();
            int choose = 0;
            Scanner in = new Scanner( System.in);
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add to cart");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number 0-1 :");
            choose = in.nextInt();
            in.nextLine();
            if( choose == 1){
                String title = in.nextLine();
                Media media = store.searchByTitle(title);
                if( media != null){
                    // add into the cart
                    cart.addMedia( media);
                }
            }else if( choose == 0) break;
        }

    }


    private static void cartMenu() {
        while( true){
            int choose = 0;
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Filter medias in cart");
            System.out.println("2. Sort medias in cart");
            System.out.println("3. Remove media from cart");
            System.out.println("4. Play a media");
            System.out.println("5. Place order");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.print("Please choose a number 0-1-2-3-4-5 : ");
            Scanner in = new Scanner(System.in);
            choose = in.nextInt();
            in.nextLine();
            if( choose == 1){
                int chooseFilter;
                System.out.println("1. Filter by id");
                System.out.println("2. Filter by title");
                System.out.print("Please choose 1 or 2 : ");
                chooseFilter = in.nextInt();
                in.nextLine();
                if( chooseFilter == 1){
                    System.out.print("Please enter id : ");
                    cart.searchById( in.nextInt());
                    in.nextLine();
                }else if( chooseFilter == 2){
                    System.out.print("Please enter title : ");
                    cart.searchByTitle( in.nextLine());
                }
            }else if( choose == 2){

            }else if( choose == 3){

            }else if( choose == 4){

            }else if( choose == 5){
                cart.emptyCart();
                System.out.println("Cart is empty");
            }else if( choose == 0) break;
        }

    }



    public static StoreScreen getStoreScreen() {
        return storeScreen;
    }

    public static CartScreen getCartScreen() {
        return cartScreen;
    }
}