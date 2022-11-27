package hust.soict.dsai.cart;

import hust.soict.dsai.disc.DigitalVideoDisc;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;


    public void addDigitalVideoDisc(DigitalVideoDisc disc){
        if( qtyOrdered == MAX_NUMBERS_ORDERED){
            System.out.println("hust.soict.dsai.cart.Cart full");
        }else{
            itemsOrdered[qtyOrdered] = disc;
            ++qtyOrdered;
        }
    }
    public void removeDigitalVideoDisc(DigitalVideoDisc disc){
        for( int i = 0; i < qtyOrdered; ++i){
            if( disc.equals(itemsOrdered[i])){
                System.out.println("removed item");
                for( int j = i + 1; j < qtyOrdered; ++j){
                    itemsOrdered[j - 1] = itemsOrdered[j];
                }
                --qtyOrdered;
                return;
            }
        }
        System.out.println("Not found item");
    }
    public float totalCost(){
        float sum = 0;
        for( int i = 0; i < qtyOrdered; ++i){
            sum += itemsOrdered[i].getCost();
        }
        return sum;
    }

    public void print(){
        for( int i = 0; i < qtyOrdered; ++i){
            itemsOrdered[i].myToString();
        }
        System.out.println("Total cost : " + totalCost());
    }

    public void searchById( int id){
        int qty = 0;
        for( int i = 0; i < qtyOrdered; ++i){
            if( id == itemsOrdered[i].getId() ){
                ++qty;
                itemsOrdered[i].myToString();
            }
        }
        if( qty == 0){
            System.out.println("Not found");
        }
    }

    public void searchByTitle( String title){
        int qty = 0;
        for( int i = 0; i < qtyOrdered; ++i ){
            if( title == itemsOrdered[i].getTitle() ){
                ++qty;
                itemsOrdered[i].myToString();
            }
        }
        if( qty == 0 ){
            System.out.println("Not found");
        }
    }
}
