package projekat;

import javax.swing.*;
import java.awt.*;

public class TestFrame {

    public static void main(String[] args){
        //kreiramo prozor
        //u panel se smesta okno sadrzaja
        JFrame frame = new JFrame("FRAME");
        frame.getContentPane().add(new DrawingPanel());
        //setBounds prozoru se postavlja pozicija i dimenzije
        frame.setBounds(100, 100, 450, 300);
        //predefinisana staticka konstanta ukazuje da prilikom zatvaranja prozora treba da se izvrsi izvrsenje aplikacije
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


        JToggleButton tglbtnSelection = new JToggleButton("Selection");
        JToolBar toolBar = new JToolBar();
        toolBar.add(tglbtnSelection);
        JToggleButton tglbtnPoint = new JToggleButton("Point");
        toolBar.add(tglbtnPoint);
        ButtonGroup group = new ButtonGroup();
        group.add(tglbtnSelection);
        group.add(tglbtnPoint);

    }

}
