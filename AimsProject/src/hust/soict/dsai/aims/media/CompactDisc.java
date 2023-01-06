package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Media implements Playable{
    private String artist;
    private List<Track> tracks = new ArrayList<Track>();

    public CompactDisc( int id, String title, String category, float cost){
        super( id, title, category);
        setCost(cost);
    }

    public CompactDisc(String title, String category, float cost, String artist){
        super( title, category, cost);
        this.artist = artist;
    }
    public CompactDisc(){

    }

    public CompactDisc( int id, String title, String category, float cost, String artist){
        setId(id);
        setTitle( title);
        setCategory(category);
        setCost( cost);
        this.artist = artist;
    }
    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track) {
        if( tracks.contains(track)){
            System.out.println("Track exist");
        }else{
            tracks.add( track);
            System.out.println("Add successfully");
        }
    }

    public void removeTrack( Track track){
        if( tracks.contains(track)){
            tracks.remove( tracks.indexOf(track));
            System.out.println("Remove successfully");
        }else{
            System.out.println("Track don't exist");
        }
    }

    public int getLength(){
        int totalLength = 0;
        for( Track track: tracks){
            totalLength += track.getLength();
        }
        return totalLength;
    }

    @Override
    public void play() throws PlayerException{
        if( getLength() > 0){
            System.out.println( "CD title : " + this.getTitle() );
            System.out.println( "CD length : " + this.getLength());

            for( Track track : tracks){
                try{
                    track.play();
                }catch(PlayerException e){
                    throw e;
                }

            }
        }else{
            throw new PlayerException("ERROR : CD length is non-positive");
        }
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public String toString(){
        return "CD - " + getTitle() + " - " + getCategory() + " - " + getArtist() + " - " + getCost();
    }
}
