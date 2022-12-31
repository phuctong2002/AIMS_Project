package hust.soict.dsai.aims.media;

public class Disc extends Media{
    private String director;
    private int length;


    public Disc(){

    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public Disc(int id,String title, String category, String director, int length){
        super( id, title, category );
        this.director = director;
        this.length = length;
    }


}
