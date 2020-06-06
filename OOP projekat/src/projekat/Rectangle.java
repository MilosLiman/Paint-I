package projekat;

import org.w3c.dom.css.Rect;

import java.awt.*;

public class Rectangle extends Shape{

    //s obzirom da se koord. sist. za crtanje nalazi u gornjem levomm uglu, izabracemo levu gornju tacku kao karakteristicnu tacku pravougaonika
    private Point upperLeft;
    private int width;
    private int height;
//    private boolean selected;

    public  Rectangle(){

    }

    public Rectangle(Point upperLeft, int width, int height){
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    public Rectangle(Point upperLeft, int width, int height, boolean selected){
        this(upperLeft, width, height);
        this.selected = selected;
    }

    public Point getUpperLeft() {
        return upperLeft;
    }

    public void setUpperLeft(Point upperLeft) {
        this.upperLeft = upperLeft;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    //metoda za odredjivanje tezisne tacke
    public Point getCenter(){
        return new Point(upperLeft.getX() + width/2, upperLeft.getY() + width/2);
    }

    //povrsina pravougaonika
    public int area(){
        return width * height;
    }

    public boolean equals(Object obj){
        if(obj instanceof Rectangle){
            Rectangle r = (Rectangle) obj;
            if(this.upperLeft.equals(r.getUpperLeft()) && this.width == r.getWidth() && this.height == r.getHeight()){
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

    public String toString(){
        return  "Upper left point=" + upperLeft + ", height=" + height + ", width=" + width;
    }

    //crtanje pravougaonika
    public void draw(Graphics g){
        g.drawRect(this.getUpperLeft().getX(), this.getUpperLeft().getY(), this.width, this.height);
        if (selected){
            g.drawRect(upperLeft.getX() -3, upperLeft.getY() - 3, 6, 6);
            g.drawRect(upperLeft.getX() + width - 3, upperLeft.getY() - 3, 6, 6);
            g.drawRect(upperLeft.getX() - 3, upperLeft.getY() + height - 3, 6, 6);
            g.drawRect(upperLeft.getX() + width - 3, upperLeft.getY() + height - 3, 6, 6);

        }
    }

    public boolean contains(Point p){
        if(upperLeft.getX() <= p.getX() && upperLeft.getY() <= p.getY() && p.getX() <= upperLeft.getX() + width && p.getY() <= upperLeft.getY() + height){
            return  true;
        }else {
            return false;
        }
    }


    @Override
    public void moveBy(int dx, int dy) {
        this.upperLeft.moveBy(dx, dy);

    }
}
