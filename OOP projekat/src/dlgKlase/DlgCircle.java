package dlgKlase;

import java.awt.Color;
import java.awt.Point;

//import projekat.Dijalog;
import projekat.*;

public class DlgCircle extends Dijalog{
	
	private int radius;
	private Point center;
	private Color color;
	
	
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
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public void setCircle(Circle circle) {
		this.radius = radius;
		this.center = center;
	}
	
	//NAKNADNO UBACENO - PROVERITI
	public boolean isComited() {
		// TODO Auto-generated method stub
		return false;
	}
	
	//NAKNADNO UBACENO - PROVERITI
	public Shape getCircle() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
