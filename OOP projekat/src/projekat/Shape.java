package projekat;

import java.awt.Color;
import java.awt.Graphics;

//u ovu klasu cemo smestiti zajednicka obelezja i metode
public abstract class Shape implements Moveable{

    //selected je zajednicko za sve klase i zbog toga cemo tamo zakomentarisati a ovde ostaviti
    protected boolean selected;
    private Color color;

    //sve izvedene klase iz klase Shape imaju iste metode draw() i contains()
    //nije ih moguce implementirati u osnovnoj klasi jer im je impelementacija razlicita u svim izvedenim klasama
    //zato ovu klasu moramo definisati kao apstraktnu i unutar nje def. aprstraktne metode koje izvedene klase trebaju da implementiraju

    //uvodjenjem apstraktne klase Shape bilo bi moguce koriscenje niza elemenata tipa Shape (DrawingPanel)
    //umesto niza elemenata Object, ovim bi eliminisali mnogobrojne provere tipa sa instanceof operatora
    //jednostavno bi pozivali metode draw za svaki niz elementa

    public Shape(){

    }

    public Shape(boolean selected){
        this.selected = selected;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

	public boolean contains(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}
}
