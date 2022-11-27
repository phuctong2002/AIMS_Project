package hust.soict.dsai.aims.store;

import hust.soict.dsai.disc.DigitalVideoDisc;

public class Store {
    private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[1000];
    private int qty;
    public void addDVD( DigitalVideoDisc dvd){
        itemsInStore[qty] = dvd;
        ++qty;
    }

    public void removeDVD( DigitalVideoDisc dvd){
        for( int i = 0; i < qty; ++i){
            if( dvd == itemsInStore[i]) {
                for (int j = i + 1; j < qty; ++j) {
                    itemsInStore[j - 1] = itemsInStore[j];
                }
                --qty;
                return;
            }
        }
    }
}
