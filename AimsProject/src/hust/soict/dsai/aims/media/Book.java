package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{

    private List<String> authors = new ArrayList<String>();
    public Book(){
        super();
    }
    public Book( int id, String title, String category, float cost, String author){
        super( id, title, category, cost);
        authors.add(author);
    }
    public void addAuthor( String author){
        int l = authors.size();
        for( int i = 0; i < l; ++i){
            if( author == authors.get(i)){
                System.out.println("Tac gia da ton tai");
                return;
            }
        }
        authors.add( author);
    }
    public void removeAuthor( String author){
        int l = authors.size();
        int index = authors.indexOf(author);
        if( index == -1){
            System.out.println("Khong ton tai");
        }else{
            authors.remove( author);
        }
    }


    public static void main(String[] args){
        Book book1 = new Book();
        book1.addAuthor("Tong Phuc");
        book1.addAuthor("Tran Tuan");
        book1.addAuthor("Thanh Vinh");
        book1.removeAuthor("Tong Phuc");
    }


    public void myToString(){
        System.out.print( "Id : "  + getId() + " - Title : " + getTitle() + " - Category: " + getCategory() + " - Cost : " + getCost()+ " - Author: ");
        for( int i = 0; i < authors.size(); ++i){
            System.out.print( authors.get(i) + " ");
        }
        System.out.println("");
    }
}
