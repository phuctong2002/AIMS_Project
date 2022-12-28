package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {

    @Override
    public int compare(Media o1, Media o2) {

        if( o1.getTitle() == o2.getTitle()){
            return o1.getCost() <= o2.getCost() ? 1: -1;
        }else{
            if (o1.getTitle().compareTo( o2.getTitle()) < 0) return -1;
            else return 1;
        }
    }
}
