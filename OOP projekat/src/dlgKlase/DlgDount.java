package dlgKlase;

import java.awt.Color;
import java.awt.Point;

import javax.swing.JPanel;
import javax.swing.JTextField;

import projekat.Dijalog;
import projekat.Dount;
import projekat.Rectangle;
import projekat.Shape;;

//NAKNADNO UBACENO - PROVERITI

public class DlgDount extends Dijalog {
	private int radius;
	private Point center;
    private int innerRadius;
    
    
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
	public int getInnerRadius() {
		return innerRadius;
	}
	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}
	public void setDount(Dount dount) {
		this.radius = radius;
		this.center = center;
		this.innerRadius = innerRadius;
		
	}
	public boolean isCommited() {
		// TODO Auto-generated method stub
		return false;
	}
	public Shape dlgDount() {
		// TODO Auto-generated method stub
		return null;
	}
    
    
    

}
