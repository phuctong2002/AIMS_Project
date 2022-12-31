package hust.soict.dsai.aims.media;

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
    public void play() {
        System.out.println("Playing Track : " + this.getTitle());
        System.out.println("Track length : " + this.getLength());
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
