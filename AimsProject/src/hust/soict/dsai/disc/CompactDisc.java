package hust.soict.dsai.disc;

import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Media implements Playable {
    private String artist;
    private List<Track> tracks = new ArrayList<Track>();

    public CompactDisc() {

    }

    @Override
    public void myToString() {
        System.out.println( "Id : "  + getId() + " - Title : " + getTitle() + " - Category: " + getCategory() + " - Cost : " + getCost() + " - Length: " + getLength() + " - Artist : " + getArtist() );
    }

    public CompactDisc(int id, String title, String category, float cost, String artist) {
        super(id, title, category, cost);
        this.artist = artist;
    }



    public String getArtist() {
        return artist;
    }

    public void addTrack( Track track){
        int index = tracks.indexOf( track);
        if( index == -1){
            tracks.add(track);
        }else{
            System.out.print("Track da ton tai");
        }
    }


    public void removeTrack( Track track){
        int index = tracks.indexOf(track);
        if( index == -1){
            System.out.println("Track khong ton tai");
        }else{
            tracks.remove( index);
            System.out.println(" removed successfully");
        }
    }
    public int getLength(){
        int sumCD = 0;
        for( Track i : tracks){
            sumCD = sumCD + i.getLength();
        }
        System.out.println("Length : " + sumCD);
        return sumCD;
    }

    @Override
    public void play() {
        System.out.println("Playing DVD: " + getTitle());
        System.out.println("DVD length: " + getLength());
        System.out.println("-------------");
        for( Track i : tracks){
            i.play();
        }
        System.out.println("-------------");

    }




}
