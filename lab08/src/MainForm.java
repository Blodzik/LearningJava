import geometry.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;

public class MainForm extends JFrame {
    private JPanel mainPanel;
    private JPanel picturePanel;
    private JComboBox<String> solidCB;
    private JTable dataTB;
    private JButton calculateBT;
    private JLabel resultLB;

    private JPanel picturePanelContainer;

    private DefaultTableModel model;
    private final AbstractSolid[] solids;


    public MainForm() {
        solids = new AbstractSolid[]{
                new Ball(10, 5),
                new Sphere(10, 5),
                new Cone(10, 4),
                new Cylinder(10, 4),
                new Tube(10, 4, 2),
                new Cuboid(10, 5, 3)
        };

        this.setContentPane(mainPanel);
        this.setTitle("Momenty bezwładności");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 500);
        this.setLocationRelativeTo(null);

        // Listenery
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent we) {
                frameOpened();
            }
        });

        solidCB.addActionListener(e -> solidCBActionPerformed());
        calculateBT.addActionListener(e -> calculateBTActionPerformed());
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        picturePanel = new PaintPanel();
    }

    private void frameOpened() {
        model = new DefaultTableModel(null, new String[]{"Nazwa", "Wartość"}) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 1;
            }
        };
        dataTB.setModel(model);
        dataTB.setRowHeight(25);

        solidCB.setSelectedIndex(0);
        solidCBActionPerformed();
    }

    private void solidCBActionPerformed() {
        int idx = solidCB.getSelectedIndex();
        String imgPath = "/resource/" + (idx + 1) + ".png";
        URL imageURL = getClass().getResource(imgPath);

        if (picturePanel instanceof PaintPanel) {
            PaintPanel pp = (PaintPanel) picturePanel; // Rzutowanie

            if (imageURL != null) {
                pp.AssignRys(new ImageIcon(imageURL).getImage());
            } else {
                pp.AssignRys(null);
            }
            pp.repaint();
        }

        solids[idx].showData(dataTB, model);
        resultLB.setText("I = ???");
    }

    private void calculateBTActionPerformed() {
        int idx = solidCB.getSelectedIndex();
        try {
            solids[idx].readData(dataTB);
            double result = solids[idx].calculateMoment();
            resultLB.setText(String.format("I = %8.3f", result));

        } catch (IllegalArgumentException | IndexOutOfBoundsException ex) {
            resultLB.setText("I = ???");
            JOptionPane.showMessageDialog(this,
                    "Błąd danych: " + ex.getMessage(),
                    "Błąd",
                    JOptionPane.ERROR_MESSAGE);
        }
    }


}
