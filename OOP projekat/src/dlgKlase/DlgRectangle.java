package dlgKlase;

import java.awt.Color;
import java.awt.Point;

import javax.swing.JPanel;
import javax.swing.JTextField;

import projekat.Dijalog;
import projekat.Rectangle;
import projekat.Shape;;

public class DlgRectangle extends Dijalog{
	
	private final JPanel contentPanel = new JPanel();
	private Point upperLeft;
	private int width;
	private int height;
	private Color color;
	
	public DlgRectangle(){
		
	}
	
	public DlgRectangle(Point upperLeft, int width, int height){
		this.upperLeft = upperLeft;
		this.width = width;
		this.height = height;
	}

	public DlgRectangle(Point upperLeft, int width, int height, Color color){
		this(upperLeft, width, height);
		this.color = color;
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
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public JPanel getContentPanel() {
		return contentPanel;
	}

	//NAKNADNO UBACENO - PROVERITI
	public Shape getRectangle() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public void setRectangle(Rectangle rectangle) {
		this.upperLeft = upperLeft;
		this.width = width;
		this.height = height;
		
	}

	//NAKNADNO UBACENO - PROVERITI
	public boolean isCommited() {
		return false;
	}

}
