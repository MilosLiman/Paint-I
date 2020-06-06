package projekat;

import java.awt.*;

//drugi nacin za kreiranje linije, koriscenjem kompozicije
public class Line2 extends Shape{

    private Point startPoint;
    private Point endPoint;
//    private boolean selected;

    public Line2(){

    }

    public Line2(Point startPoint, Point endPoint){
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public Line2(Point startPoint, Point endPoint, boolean selected){
        this(startPoint,endPoint);
        this.selected = selected;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    //startP i endP su tipa Point pa je u metodi length klase Line2 moguce iskoristi funkcionalnost klase Point - njene metode distance
    //izracunava se duzina linija na osnovu udaljenosti dve tacke, pocetne i kranje
    public double lenghth(){
        //jedan nacin
//        return this.startPoint.distance(this.endPoint);

        //drugi nacin
        return startPoint.distance(endPoint.getX(), endPoint.getY());
    }

    //redefinisanje metode sa nazivom equals
    public boolean equals(Object obj){
        if(obj instanceof Line2) {
            Line2 l = (Line2) obj;
            //DUZI NACIN
//            if(l.getStartPoint().getX() == this.getStartPoint().getX() &&
//            l.getStartPoint().getY() == this.getStartPoint().getY() &&
//            l.getEndPoint().getX() == this.getEndPoint().getX() &&
//            l.getEndPoint().getY() == this.getEndPoint().getY())

            if(l.getStartPoint().equals(this.getStartPoint()) && l.getEndPoint().equals(this.getEndPoint())){
                return true;
            } else {
                return false;
            }
        }else {
            return false;
        }
    }

    //redefinisanje metode toString
    public String toString(){
        return this.getStartPoint() + "->" + this.getEndPoint();
    }

    //crtanje linije
    //na osnovu koordinata pocetne i krajnje tacke

    public void draw(Graphics g){
        g.drawLine(this.getStartPoint().getX(), this.getStartPoint().getY(), this.getEndPoint().getX(), this.getEndPoint().getY());
        if(selected){
            g.drawRect(getStartPoint().getX() - 3, getStartPoint().getY() - 3, 6 , 6);
            g.drawRect(getEndPoint().getX() - 3, getEndPoint().getY() - 3, 6 , 6);
        }
    }


    public boolean contains(int x, int y){
       if(startPoint.distance(x, y) - endPoint.distance(x, y) - lenghth() <= 0.05){
           return true;
       }else{
           return false;
       }
    }


    public void moveOn(int x, int y) {
        //apsolutno pomeranje
        //odredjuje se srednja tacka linije i pomera se linija tako da se njena srednja tacka pomeri na zadate koordinate
        int middleX =(this.startPoint.getX() + this.endPoint.getX())/2;
        int middleY =(this.startPoint.getY() + this.endPoint.getY())/2;
        int dx = x - middleX;
        int dy = y - middleY;
        this.startPoint.moveBy(dx, dy);
        this.endPoint.moveBy(dx, dy);
    }


    //PROVEIRI DA LI RADI, AKO NE ONDA KOD IZ KNJIGE
    @Override
    public void moveBy(int dx, int dy) {
        this.startPoint.moveBy(dx, dy);
        this.endPoint.moveBy(dx, dy);
    }
}
