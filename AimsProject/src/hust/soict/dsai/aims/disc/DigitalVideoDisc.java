package hust.soict.dsai.aims.disc;


import hust.soict.dsai.aims.media.Disc;
import hust.soict.dsai.aims.media.Playable;

public class DigitalVideoDisc extends Disc implements Playable {
    private static int nbDigitalVideoDiscs = 0;
    private String director;
    private int length;



    public DigitalVideoDisc(){
        setId( nbDigitalVideoDiscs);
        ++nbDigitalVideoDiscs;
    }
    public DigitalVideoDisc( String title){
        setId( nbDigitalVideoDiscs);
        ++nbDigitalVideoDiscs;
        setTitle(title);
    }

    public DigitalVideoDisc( String category, String title, float cost){
        setId( nbDigitalVideoDiscs);
        ++nbDigitalVideoDiscs;
        setCategory( category);
        setTitle(title);
        setCost(cost);
    }

    public DigitalVideoDisc( String director, String category, String title, float cost){
        setId( nbDigitalVideoDiscs);
        ++nbDigitalVideoDiscs;
        setCost(cost);
        setTitle(title);
        setCategory(category);
        this.director = director;
    }


    public DigitalVideoDisc( String title, String category, String director, int length, float cost){
        setId(nbDigitalVideoDiscs);
        ++nbDigitalVideoDiscs;
        setTitle(title);
        setCategory(category);
        this.director = director;
        this.length = length;
        setCost(cost);
    }



    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }



    @Override
    public String toString(){
        return "DVD - " + getTitle() + " - " + getCategory() + " - " + director + " - " + length + " : " + getCost();
    }

    @Override
    public void play() {
        System.out.println( "Playing DVD : " + this.getTitle());
        System.out.println( "DVD length : " + this.getLength());
    }
}
