package hust.soict.dsai.disc;

import hust.soict.dsai.aims.media.Media;

public class Disc extends Media {

    private int length;
    private String director;


    public Disc(){

    }

    public Disc( int id, String title, String category, float cost, int length, String director){
        super( id, title, category, cost);
        this.length = length;
        this.director = director;
    }

    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void myToString(){

    }
}
