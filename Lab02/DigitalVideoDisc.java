public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
    public DigitalVideoDisc( String title) {
        this.setTitle(title);
    }
    public DigitalVideoDisc( String category, String title,  float cost){
        this.setTitle(title);
        this.setCategory(category);
        this.setCost(cost);
    }
    public DigitalVideoDisc(String director, String category,String title,  float cost ){
        this.setTitle(title);
        this.setDirector(director);
        this.setCost(cost);
        this.setCategory(category);
    }
    public DigitalVideoDisc( String title, String category, String director, int length,float cost){
        this.setTitle(title);
        this.setLength(length);
        this.setCategory(category);
        this.setCost(cost);
        this.setDirector(director);
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

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
}
