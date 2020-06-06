package projekat;

import java.awt.*;

//extends prosirivanje klase
//dount prosiruje klasu circle i time nasledjuje sva obelezja i metode klase circle koja nisu deklarisana kao privatna
public class Dount extends Circle {

    private int innerRadius;

    public Dount(){

    }

    //poziv konstruktora osnovne klase - super
    public Dount(int radius, Point center, int innerRadius){
        super(radius, center);
        this.innerRadius = innerRadius;
    }


    public int getInnerRadius() {
        return innerRadius;
    }

    public void setInnerRadius(int innerRadius) {
        this.innerRadius = innerRadius;
    }

    //klasa dount nasledjuje metodu area iz klase cirlce
    //implementacija area metod. nije odgovarajuca i moramo je izmeniti
    //radi se redefinisanje - override
    public double area(){
        //od povrsine kruga oduzimamo unutrasnju povrsinu rupe
        //da ne bi ponavljali kod iz postojece klase i pisali Math.PI * getRadius() * getRadius() koristimo super
        return super.area() - Math.PI * innerRadius * innerRadius;
    }

    public boolean equals(Object obj){
        if(obj instanceof Dount){
            Dount d = (Dount) obj;
            if(this.getRadius() == d.getRadius() && this.getCenter().equals(d.getCenter()) && this.innerRadius == d.getInnerRadius()){
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

    public String toString(){
        return super.toString() + ", inner radius=" + innerRadius;
    }

    //crtanje kruga sa rupom
    //ovo ce biti crtanje spoljasnjeg i unutrasnjeg kruga
    //crtanje spoljasnjeg moze da izvrsi nasledjena metoda draw koja se poziva koriscenjem reference super
    public void draw(Graphics g){
        super.draw(g);
        g.drawOval(this.getCenter().getX() - this.innerRadius, this.getCenter().getY() - this.innerRadius, this.innerRadius * 2, this.innerRadius * 2);
        //???????? NECE SELECTED JER JE PRIVATNO U CIRCLE
        if(isSelected()){
            g.drawRect(getCenter().getX() - this.innerRadius - 3, getCenter().getY() - innerRadius - 3, 6, 6);
            g.drawRect(getCenter().getX() + this.innerRadius - 3, getCenter().getY() - innerRadius - 3, 6, 6);
            g.drawRect(getCenter().getX() - this.innerRadius - 3, getCenter().getY() - innerRadius - 3, 6, 6);
            g.drawRect(getCenter().getX() - this.innerRadius - 3, getCenter().getY() + innerRadius - 3, 6, 6);
        }
    }

    public boolean contains(Point p){
        double dFromCenter = this.getCenter().distance(p.getX(), p.getY());
        return super.contains(p.getX(), p.getY()) && dFromCenter > innerRadius;
    }
}
