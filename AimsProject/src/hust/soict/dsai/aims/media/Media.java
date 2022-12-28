package hust.soict.dsai.aims.media;

import java.util.Comparator;

public abstract class Media {


    public static final Comparator<Media> COMPARE_BY_TITLE_COST =  new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
    private int id;
    private String title;
    private String category;
    private float cost;

    public Media(){

    }

    public Media( int id, String title, String category, float cost){
        this.category = category;
        this.title = title;
        this.cost = cost;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    abstract public void myToString();
    @Override
    public boolean equals(Object o) {
        if( o == this){
            return true;
        }
        if( !( o instanceof Media)){
            return false;
        }
        Media media = (Media) o;
        if( media.getTitle() == title) return true;
        else return false;
    }




}
