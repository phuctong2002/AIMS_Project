package hust.soict.dsai.aims.disc;


import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Disc;
import hust.soict.dsai.aims.media.Playable;

public class DigitalVideoDisc extends Disc implements Playable {
    private static int nbDigitalVideoDiscs = 0;

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
        setDirector(director);
//        this.director = director;
    }


    public DigitalVideoDisc( String title, String category, String director, int length, float cost){
        setId(nbDigitalVideoDiscs);
        ++nbDigitalVideoDiscs;
        setTitle(title);
        setCategory(category);
        setDirector(director);
        setLength(length);
//        this.director = director;
//        this.length = length;
        setCost(cost);
    }


    @Override
    public String toString(){
        return "DVD - " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getLength() + " : " + getCost();
    }

    @Override
    public void play() throws PlayerException {
        if( getLength() > 0){
            System.out.println( "Playing DVD : " + this.getTitle());
            System.out.println( "DVD length : " + this.getLength());
        }else
            throw new PlayerException("ERROR: DVD length is non-positive");
    }
}
