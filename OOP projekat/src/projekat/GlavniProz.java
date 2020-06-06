package projekat;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dlgKlase.DlgCircle;
import dlgKlase.DlgDount;
import dlgKlase.DlgLine2;
import dlgKlase.DlgPoint;
import dlgKlase.DlgRectangle;

import javax.swing.JToolBar;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;


//DrawingFrame
public class GlavniProz extends JFrame {

	private DrawingPanel panel = new DrawingPanel(this);
	
	private JPanel contentPane;
	private JToggleButton tglbtnSelection;
	private JToggleButton tglbtnPoint;
	private JToggleButton tglbtnLine;
	private JToggleButton tglbtnRectangle;
	private JToggleButton tglbtnCircle;
	private JToggleButton tglbtnDount;
	private JToggleButton tglbtnModify;
	private JToggleButton tglbtnDelete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GlavniProz frame = new GlavniProz();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GlavniProz() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		tglbtnSelection = new JToggleButton("Selection");
		toolBar.add(tglbtnSelection);
		
		tglbtnPoint = new JToggleButton("Point");
		toolBar.add(tglbtnPoint);
		
		tglbtnLine = new JToggleButton("Line");
		toolBar.add(tglbtnLine);
		
		tglbtnRectangle = new JToggleButton("Rectangle");
		toolBar.add(tglbtnRectangle);
		
		tglbtnCircle = new JToggleButton("Circle");
		toolBar.add(tglbtnCircle);
		
		tglbtnDount = new JToggleButton("Dount");
		toolBar.add(tglbtnDount);
		
		tglbtnModify = new JToggleButton("Modify");
		toolBar.add(tglbtnModify);
		
		tglbtnDelete = new JToggleButton("Delete");
		toolBar.add(tglbtnDelete);
		
		//sa ovim svaki klik na dugme iskljucuje drugo dugme
		ButtonGroup group = new ButtonGroup();
		group.add(tglbtnSelection);
		group.add(tglbtnPoint);
		group.add(tglbtnLine);
		group.add(tglbtnRectangle);
		group.add(tglbtnCircle);
		group.add(tglbtnDount);
		group.add(tglbtnModify);
		group.add(tglbtnDelete);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
	}

	public JToggleButton getTglbtnSelection() {
		return tglbtnSelection;
	}
	public JToggleButton getTglbtnPoint() {
		return tglbtnPoint;
	}
	public JToggleButton getTglbtnLine() {
		return tglbtnLine;
	}
	public JToggleButton getTglbtnRectangle() {
		return tglbtnRectangle;
	}
	public JToggleButton getTglbtnCircle() {
		return tglbtnCircle;
	}
	public JToggleButton getTglbtnDount() {
		return tglbtnDount;
	}
	public JToggleButton getTglbtnModify() {
		return tglbtnModify;
	}
	public JToggleButton getTglbtnDelete() {
		return tglbtnDelete;
	}
	
	//brisanje oblika
	//proverava da li je neki objekat selektovan, ako jeste brise ga iz liste
	//nakon toga trazi od panela da se ponovo iscrta, izvrsavanjem metode paint
	protected void delete(){
		Shape selected = panel.getSelected();
		if(selected != null){
			panel.getShapes().remove(selected);
		}
		panel.repaint();
	}
	
	protected void modify(){
		Shape selected = panel.getSelected();
		if(selected != null){
			if(selected instanceof Point){
				Point point = (Point) selected;
				DlgPoint dlg = new DlgPoint();
				dlg.setPoint(point);
				dlg.setModal(true);
				dlg.setVisible(true);
			}else if(selected instanceof Line2){
				Line2 line = (Line2) selected;
				DlgLine2 dlg = new DlgLine2();
				dlg.setLine2(line);
				dlg.setModal(true);
				dlg.setVisible(true);
			}else if(selected instanceof Rectangle){
				Rectangle rect = (Rectangle) selected;
				DlgRectangle dlg = new DlgRectangle();
				dlg.setRectangle(rect);
				dlg.setModal(true);
				dlg.setVisible(true);
			}else if(selected instanceof Dount){
				Dount dount = (Dount) selected;
				DlgDount dlg = new DlgDount();
				dlg.setDount(dount);
				dlg.setModal(true);
				dlg.setVisible(true);
			}else if(selected instanceof Circle){
				Circle circle = (Circle) selected;
				DlgCircle dlg = new DlgCircle();
				dlg.setCircle(circle);
				dlg.setModal(true);
				dlg.setVisible(true);
			}
		}
		
		panel.repaint();
	}
}
