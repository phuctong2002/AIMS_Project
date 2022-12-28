package hust.soict.dsai.aims;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.cart.Cart;
import hust.soict.dsai.disc.CompactDisc;
import hust.soict.dsai.disc.DigitalVideoDisc;

import java.util.Scanner;
public class Aims {
    public static Store store;
    public static Cart cart;
    public static void main(String[] args){
        store = new Store();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        store.addMedia( dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star War", "Science Fiction", "George Lucas", 87, 24.95f);
        store.addMedia(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Animation", "Aladin", 18.99f);
        store.addMedia(dvd3);
        store.addMedia( new CompactDisc( 1, "title1", "category1", 1234, "Phuc Tong"));


        showMenu();
    }

    public static void showMenu( ){
        while( true){
            System.out.println("AIMS: ");
            System.out.println("--------------------------------");
            System.out.println("1. View store");
            System.out.println("2. Update store");
            System.out.println("3. See current cart");
            System.out.println("0. Exit");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3 : ");
            Scanner in = new Scanner( System.in);
            int choose = in.nextInt();
            in.nextLine();
            if( choose == 1){
                store.showStore();
                storeMenu();
            }
            if( choose == 2){

            }
            if( choose == 3){
                cart.print();
                cartMenu();
            }
            if( choose == 0) return;
        }

    }
    public static void storeMenu() {
        while( true){
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. See a media’s details");
            System.out.println("2. Add a media to cart");
            System.out.println("3. Play a media");
            System.out.println("4. See current cart");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3-4");
            Scanner in = new Scanner(System.in);
            int choose = in.nextInt();
            in.nextLine();
            if( choose == 1){
                System.out.print("Enter the title : ");
                String title = in.nextLine();
                store.searchByTitle(title);
                mediaDetailsMenu();
            }
            if( choose == 0) break;

        }

    }
    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
        Scanner in  = new Scanner(System.in);
        int choose = in.nextInt();
        in.nextLine();
        if( choose == 0) return;
        if( choose == 1){

            System.out.println( "Enter the title : ");
            String title = in.nextLine();
            Media media = store.searchByTitle( title);
            if( media == null){
                System.out.println("Title incorrect");
            }else{
                cart.addMedia( media);
            }

        }
        if( choose == 2){
            String title = in.nextLine();
            Media media = store.searchByTitle(title);
            if( media instanceof Book){
                System.out.println("Cannot play");
            }else if( media instanceof DigitalVideoDisc){

            }else {

            }

        }
    }
    public static void cartMenu() {
        while( true){
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Filter medias in cart");
            System.out.println("2. Sort medias in cart");
            System.out.println("3. Remove media from cart");
            System.out.println("4. Play a media");
            System.out.println("5. Place order");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3-4-5");
            Scanner  in = new Scanner(System.in);
            int choose = in.nextInt();
            in.nextLine();
            if( choose == 0) return;
            if( choose == 1){
                System.out.println("1. Filter by id");
                System.out.println("2. Filter by title");
                int chooseSort = in.nextInt();
                if( chooseSort == 1){
                    System.out.print( "Enter id: ");
                    int id = in.nextInt();
                    in.nextLine();
                    cart.searchById( id );

                }else if( chooseSort == 2){
                    String title = in.nextLine();
                    in.nextLine();
                    cart.searchByTitle( title);
                }else {
                    System.out.println("Input invalid");
                }

            }
            if( choose == 2){
                System.out.println("1. Sort by Cost Title");
                System.out.println("2 .Sort by Title Cost ");
                System.out.println("Choose 1 or 2");
                int chooseSort = in.nextInt();
                in.nextLine();
                if( chooseSort == 1){
                    cart.sortByTitleCost();
                    cart.print();
                }else if( chooseSort == 2){
                    cart.sortByCostTitle();
                    cart.print();
                }
            }
        }

    }

}
