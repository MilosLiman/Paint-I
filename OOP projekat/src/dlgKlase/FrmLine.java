package dlgKlase;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import projekat.Line2;
import projekat.Point;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmLine extends JFrame {

    private JPanel contentPane;
    DefaultListModel<Line2> dlm = new DefaultListModel<Line2>();

    JList list;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FrmLine frame = new FrmLine();
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
    public FrmLine() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setTitle("Frame Line");
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel pnlJug = new JPanel();
        contentPane.add(pnlJug, BorderLayout.SOUTH);

        JButton btnDodaj = new JButton("Dodaj");
        btnDodaj.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DlgLine2 dlg = new DlgLine2();
                dlg.setVisible(true);

                if (dlg.isOk) {
                    Line2 l1 = new Line2(new Point(Integer.parseInt(dlg.getTxtStartX().getText().toString()), Integer.parseInt(dlg.getTxtStartY().getText().toString())),
                            new Point(Integer.parseInt(dlg.getTxtEndX().getText().toString()), Integer.parseInt(dlg.getTxtEndY().getText().toString())));

                    dlm.addElement(l1);
                }
            }
        });
        pnlJug.add(btnDodaj);

        JButton btnModifikuj = new JButton("Modifikuj");
        btnModifikuj.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (list.isSelectionEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "Nije selektovan ni jedan red!",
                            "Greška",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    System.out.println(dlm.elementAt(list.getSelectedIndex()).toString());

                    //String[] split = dlm.elementAt(list.getSelectedIndex()).toString().split("[\\W]");

                    Line2 temp = dlm.elementAt(list.getSelectedIndex());

                    DlgLine2 dlg = new DlgLine2();
					/*dlg.getTxtStartX().setText(split[1]);
					dlg.getTxtStartY().setText(split[3]);
					dlg.getTxtEndX().setText(split[8]);
					dlg.getTxtEndY().setText(split[10]);*/

                    dlg.getTxtStartX().setText(Integer.toString(temp.getStartPoint().getX()));
                    dlg.getTxtStartY().setText(Integer.toString(temp.getStartPoint().getY()));
                    dlg.getTxtEndX().setText(Integer.toString(temp.getEndPoint().getX()));
                    dlg.getTxtEndY().setText(Integer.toString(temp.getEndPoint().getY()));

                    dlg.setVisible(true);

                    if (dlg.isOk) {
                        dlm.removeElementAt(list.getSelectedIndex());
                        Line2 l1 = new Line2(new Point(Integer.parseInt(dlg.getTxtStartX().getText().toString()), Integer.parseInt(dlg.getTxtStartY().getText().toString())),
                                new Point(Integer.parseInt(dlg.getTxtEndX().getText().toString()), Integer.parseInt(dlg.getTxtEndY().getText().toString())));

                        dlm.addElement(l1);
                    }
                }
            }
        });
        pnlJug.add(btnModifikuj);

        JButton btnUkloniSve = new JButton("Ukloni sve");
        btnUkloniSve.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dlm.clear();
            }
        });
        pnlJug.add(btnUkloniSve);

        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);

        list = new JList();
        scrollPane.setViewportView(list);
        list.setModel(dlm);
    }

}