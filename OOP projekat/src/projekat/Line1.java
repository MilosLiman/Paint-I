package projekat;

//prvi nacin za kreiranje linije, definisanjem polja primitivnog tipa
public class Line1 {

    //koordinate pocetne tacke
    private int startX;
    private int startY;
    //koordinate krajnje tacke
    private int endX;
    private int endY;
    private boolean selected;

    public Line1(){

    }

    public Line1(int startX, int startY, int endX, int endY){
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }

    public Line1(int startX, int startY, int endX, int endY, boolean selected){
        this(startX, startY, endX, endY);
        this.selected = selected;
    }

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public int getEndX() {
        return endX;
    }

    public void setEndX(int endX) {
        this.endX = endX;
    }

    public int getEndY() {
        return endY;
    }

    public void setEndY(int endY) {
        this.endY = endY;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    //metoda za racunjanje duzine linije
    //izracunava udaljenost dve tacke
    public double lenght(){
        int dx = this.startX - this.endX;
        int dy = this.startY = this.endY;
        double length = Math.sqrt(dx * dx + dy * dy);
        return  length;
    }
}
