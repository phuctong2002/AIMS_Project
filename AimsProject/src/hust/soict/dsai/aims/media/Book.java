package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {

    private List<String> authors = new ArrayList<String>();

    public Book(){

    }

    public void addAuthor( String authorName){
        int flag = 0;
        for( String author : authors){
            if( author.equals(authorName)){
                flag = 1;
            }
        }
        if( flag == 1){

            System.out.println("Author exist ");
        }else{
            authors.add( authorName);
            System.out.println("Add successfully");
        }
    }
    public void removeAuthor( String authorName){
        int flag = 0;
        int length = authors.size();
        for( int i = 0; i < length; ++i){
            if( authors.get(i).equals(authorName)){
                authors.remove( authors.get(i));
                flag = 1;
                break;
            }
        }
        if( flag == 1){
            System.out.println("Remove successfully");
        }else System.out.println("Author don't exist");
    }

    public Book(int id, String title, String category) {
        super( id, title, category);
    }
    public void show(){
        for( String author: authors){
            System.out.println(author);
        }
    }


    @Override
    public String toString(){
        return "Book - " + getTitle() + " - " + getCategory() + " - " + getCost();
    }

    public static void main( String[] args){
        Book book1 = new Book( 1, "vat li dai cuong", "Physic");
        book1.addAuthor("Phuc Tong");
        book1.addAuthor("Duc Vuong");
        book1.show();
        book1.addAuthor("Phuc Tong");
        book1.removeAuthor("Tong Phuc");
        book1.removeAuthor("Duc Vuong");
    }
}
