package hust.soict.dsai.disc;

public class Track implements Playable{
    private String title;
    private int length;


    public Track(){

    }

    public Track( String title, int length){
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public void play() {
        System.out.println("Playing Track: " + getTitle());
        System.out.println("Track length: " + getLength());

    }
    @Override
    public boolean equals( Object o){
        if( this == o) return true;
        if( !(o instanceof Track ) ) return false;
        Track t = (Track) o;
        if( t.getTitle() == title && t.getLength() == length) return true;
        else return false;
    }
}
