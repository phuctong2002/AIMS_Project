package hust.soict.dsai.disc;

import hust.soict.dsai.aims.media.Media;

public class DigitalVideoDisc extends Disc implements Playable {
    private static int nbDigitalVideoDiscs = 0;

    public DigitalVideoDisc( String title) {
        ++nbDigitalVideoDiscs;
//        id = (int)Math.random()*1000;
        setTitle(title);
    }
    public DigitalVideoDisc( String category, String title,  float cost){
        ++nbDigitalVideoDiscs;
//        id = (int)Math.random()*1000;

        setTitle(title);
        setCategory(category);
        setCost(cost);
    }
    public DigitalVideoDisc(String director, String category,String title,  float cost ){
        ++nbDigitalVideoDiscs;
//        id = (int)Math.random()*1000;
        setTitle(title);
        setDirector(director);
        setCost(cost);
        setCategory(category);
    }
    public DigitalVideoDisc( String title, String category, String director, int length,float cost){
        ++nbDigitalVideoDiscs;
//        id = (int)Math.random()*1000;
        setTitle(title);
        setLength(length);
        setCategory(category);
        setCost(cost);
        setDirector(director);
    }






    public void myToString(){
        System.out.println( "DVD - " + getTitle()  + " - " + getCategory() + " - " + getDirector() + " - " + getLength() + " : " + getCost() +"$");
    }


    @Override
    public void play() {
        System.out.println("Playing DVD: " + getTitle());
        System.out.println("DVD length: " + getLength());

    }
}
