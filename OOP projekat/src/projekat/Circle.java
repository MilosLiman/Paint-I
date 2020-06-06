package projekat;

import java.awt.*;

public class Circle extends Shape{

    private int radius;
    private Point center;
//    private boolean selected;

    public Circle(){

    }

    public Circle(int radius, Point center){
        this.radius = radius;
        this.center = center;
    }

    public Circle(int radius, Point center, boolean selected){
        this(radius, center);
        this.selected = selected;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    //metoda za racunjanje povrsine kruga
    public double area(){
        return radius * radius * Math.PI;
    }


    public boolean equals(Object obj){
        if(obj instanceof Circle){
            Circle c = (Circle) obj;
            if(this.radius == c.getRadius() && this.center.equals(c.getCenter())){
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

    public String toString(){
        return "Center=" + center + ", radius=" + radius;
    }

    //crtanje kruga
    //drawOval
    public void draw(Graphics g){
        g.drawOval(this.getCenter().getX() - this.radius, this.getCenter().getY() - this.radius, this.radius*2, this.radius*2);
        if(selected){
            //posmatra se krug u okviru pravougaonika, zbog toga drawRect, tj kada se selektuje bice selektovan pravougaonik oko kruznice
            g.drawRect(center.getX() - radius - 3, center.getY() - 3, 6, 6);
            g.drawRect(center.getX() + radius - 3, center.getY() - 3, 6, 6);
            g.drawRect(center.getX() - radius - 3, center.getY() - 3, 6, 6);
            g.drawRect(center.getX() + radius - 3, center.getY() - 3, 6, 6);
        }
    }

    //centar je tacka iz klase Point koja predstavlja centar kruga sa koord. x i y
    //merimo distancu od tacke koja je centar kruga sa zadatom tackom iz klase Point p, koju pravimo u ovoj metodi
    //ako kliknemo bilo unutar kruga, do ivice, a to je ograniceno manje ili jednako od radijusa bice selektovan krug
    public boolean contains(Point p) {
        return center.distance(p.getX(), p.getY()) <= radius;
    }

    // @OVERLOAD, kada se dve ili vise metoda zovu isto ali primaju razlicite parametre razlicitog tipa (npr int x, double x) ili razliciti broj
    //metode contains imaju isti naziv, razl parametre, dakle overload (nije overloadig tj preklapanje)

    public boolean contains(int x, int y) {
        return this.center.distance(x, y) <= radius;
    }

    @Override
    public void moveBy(int dx, int dy) {
        this.center.moveBy(dx, dy);
    }
}
