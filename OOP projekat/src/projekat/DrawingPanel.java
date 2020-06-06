package projekat;

import javax.swing.*;

import dlgKlase.DlgRectangle;
import dlgKlase.DlgCircle;
import dlgKlase.DlgDount;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import dlgKlase.DlgRectangle;

public class DrawingPanel extends JPanel {

    //obelezja
    //private TestFrame frame;
	//obelezje frame obezbedjuje referenciranje objekta prozora aplikacije
    private GlavniProz frame;
    //obelezje shapes je lista oblika koji se nalaze na crtezu
    private ArrayList<Shape> shapes = new ArrayList<Shape>();
    private Point startPoint;
    private Shape selected;

//    private Object[] shapes = new Object[10];

    //konstruktor klase
    //uvek na isti nacin popunjava listu oblika sa po jednim objektom svake od predhodno definisanih klasa
    public DrawingPanel(){
//        shapes[0] = new Point(80, 100);
//        shapes[1] = new Line2(new Point(200, 80), new Point(250,180));
//        shapes[2] = new Circle(40, new Point(50,50));
//        shapes[3] = new Rectangle(new Point(130, 30), 40, 20);
//        shapes[4] = new Dount(40, new Point(100, 150), 20);
    }
    
    public DrawingPanel(GlavniProz frame){
    	this.frame = frame;
    	
    	//osluskujemo dogadjaj - da li je korisnik kliknuo
    	addMouseListener(new MouseAdapter(){
    		public void mouseClicked(MouseEvent arg0){
    			this.mouseClicked(arg0);
    		}
    	});
    }
    
    //ako je korisnik kliknuo, ovo je odgovor panela na pojavu tog dogadjaja
    protected void thisMouseClicked(MouseEvent e) {
      Shape newShape = null;
      //ako je pritisnuto dugme za selekciju, ponisti se trenutna selekcija
      if(frame.getTglbtnSelection().isSelected()){
          selected = null;
          //prolazi se kroz sve oblike u listi
          Iterator<Shape> it = shapes.iterator();
          while (it.hasNext()){
              Shape shape = it.next();
              shape.setSelected(false);
              if(shape.contains(e.getX(), e.getY())){
                  selected = shape;
              }
              if (selected != null){
                  selected.setSelected(true);
              }else if(frame.getTglbtnLine().isSelected()){
                  if(startPoint == null){
                     startPoint = new Point(e.getX(), e.getY());
                  }else {
                      newShape = new Line2(startPoint, new Point(e.getX(), e.getY()));
                      startPoint = null;
                  }
              }else if(frame.getTglbtnRectangle().isSelected()){
            	  DlgRectangle dlg = new DlgRectangle();
            	  dlg.setModal(true);
            	  dlg.setRectangle(new Rectangle(new Point(e.getX(), e.getY()), -1, -1));
            	  dlg.setVisible(true);
            	  if(!dlg.isCommited()){
            		  return;
            	  }
            	  try{
            		  newShape = dlg.getRectangle();
            	  }catch(Exception ex){
            		  JOptionPane.showMessageDialog(frame, "Wrong data type", "Error", JOptionPane.ERROR_MESSAGE);
            	  }
              }else if(frame.getTglbtnCircle().isSelected()){
            	  DlgCircle dlg = new DlgCircle();
            	  dlg.setModal(true);
            	  dlg.setCircle(new Circle(-1, new Point(e.getX(), e.getY())));
            	  dlg.setVisible(true);
            	  if(!dlg.isComited()){
            		  return;
            	  }
            	  try{
            		  newShape = dlg.getCircle();
            	  }catch(Exception ex){
            		  JOptionPane.showMessageDialog(frame, "Wrong data type", "Error", JOptionPane.ERROR_MESSAGE);
            	  }
              }else if (frame.getTglbtnDount().isSelected()){
            	  DlgDount dlg = new DlgDount();
            	  dlg.setModal(true);
            	  dlg.setDount(new Dount(-1, new Point(e.getX(), e.getY()), -1));
            	  dlg.setVisible(true);
            	  if(!dlg.isCommited()){
            		  return;
            	  }
            	  try{
            		  newShape = dlg.dlgDount();
            	  }catch(Exception ex){
            		  JOptionPane.showMessageDialog(frame, "Wrong data type", "Error", JOptionPane.ERROR_MESSAGE);
            	  }
              }
              if(newShape != null){
            	  shapes.add(newShape);
            	  repaint();
              }
              
          }
      }
      
  }
    
    
    public void paint(Graphics g){
  	  Iterator<Shape> it = shapes.iterator();
  	  while(it.hasNext()){
  		  it.next().draw(g);
  	  }
    }
    
    public Shape getSelected(){
    	return selected;
    }
    
    public ArrayList<Shape> getShapes(){
  	  return shapes;
    }

    //preklapamo metodu paint() u izvedenoj klasi kako bi smo iscrtali nekoliko objekata klasa oblika koje smo predhodno definisali
//    public void paint(Graphics g){
//        super.paint(g);
//        for (int i = 0; i < shapes.length; i++){
//            Object obj = shapes[i];
//            if(obj != null){
//                if(obj instanceof Point){
//                    Point p = (Point) obj;
//                    p.draw(g);
//                }else if(obj instanceof Line2){
//                    Line2 l = (Line2) obj;
//                    l.draw(g);
//                }else if(obj instanceof Circle){
//                    Circle c = (Circle) obj;
//                    c.draw(g);
//                }else if (obj instanceof Rectangle){
//                    Rectangle r = (Rectangle) obj;
//                    r.draw(g);
//                }else if (obj instanceof Dount){
//                    Dount d = (Dount) obj;
//                    d.draw(g);
//                }
//            }
//        }
//    }


//    protected void thisMouseClicked(MouseEvent e) {
//        Shape newShape = null;
//        if(frame.getTglbtnSelection().isSelected()){
//            selected = null;
//            Iterator<Shape> it = shapes.iterator();
//            while (it.hasNext()){
//                Shape shape = it.next();
//                shape.setSelected(false);
//                if(shape.contains(e.getX(), e.getY())){
//                    selected = shape;
//                }
//                if (selected != null){
//                    selected.setSelected(true);
//                }else if(frame.getTgblbtnLine().isSelected()){
//                    if(startPoint == null){
//                       startPoint = new Point(e.getX(), e.getY());
//                    }else {
//                        newShape = new Line2(startPoint, new Point(e.getX(), e.getY()));
//                        startPoint = null;
//                    }
//                }else if(frame.getTgblbtnRectangle().isSelected()){
//                    DlgRectangle dlg = new DlgRectangle;
//                }
//            }
//        }
//    }


    //"dinamicko povezivanje"
    //SKRACENA VERZIJA - prednosta apstraktne klase
    //apstraktna metoda draw u klasi Shape omogucava da kompajler uspesno prevede izvorni kod jer u klasi Shape postoji apstraktna metoda draw()
//    public void paint(Graphics g){
//        Point p = new Point(80, 100);
//        p.draw(g);
//
//        Line2 l = new Line2(new Point(200, 80), new Point(250,180));
//        l.draw(g);
//
//        Circle c = new Circle(40, new Point(50,50));
//        c.draw(g);
//
//        Rectangle r = new Rectangle(new Point(130, 30), 40, 20);
//        r.draw(g);
//
//        Dount d = new Dount(40, new Point(100, 150), 20);
//        d.draw(g);
//    }


}
