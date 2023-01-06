package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

import javax.swing.plaf.synth.SynthTextAreaUI;

public class Track implements Playable {
    private String title;
    private int length;

    public Track() {
    }

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    @Override
    public void play() throws PlayerException {
        if( getLength() > 0){
            System.out.println("Playing Track : " + this.getTitle());
            System.out.println("Track length : " + this.getLength());
        }else
            throw new PlayerException("ERROR: Track length is non-positive");

    }


    @Override
    public boolean equals( Object o){
        if( o instanceof Track){
            if( ((Track) o).getTitle().equals( this.title) && ((Track) o).getLength() == this.length){
                return true;
            }else return false;
        }
        return false;
    }
}
