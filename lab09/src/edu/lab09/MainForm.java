//package edu.lab09;
//
//import edu.libpanel.PaintPanel;
//import edu.shapes.ShapeCircle;
//
//import javax.swing.*;
//import java.awt.*;
//
//public class MainForm extends JFrame {
//    private JPanel mainPanel;
//    private JPanel graphicArea;
//
//    private void createUIComponents() {
//        // TODO: place custom component creation code here
//    }
//
//    public MainForm() {
//        this.setTitle("Kształtowniki");
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setResizable(false);
//
//        mainPanel = new JPanel(new BorderLayout());
//        graphicArea = new PaintPanel();
//        graphicArea.setPreferredSize(new Dimension(1280, 800));
//
//        mainPanel.add(graphicArea, BorderLayout.CENTER);
//        this.setContentPane(mainPanel);
//
//        this.pack();
//        this.setLocationRelativeTo(null);
//
//        Document document = new Document(graphicArea);
//
//        document.addShape(new ShapeCircle(200, 200, Color.LIGHT_GRAY, Color.RED, 70));
//        document.addShape(new ShapeCircle(600, 300, Color.YELLOW, Color.BLUE, 90));
//
//        generateRandomShapes(20);
//
//        document.redraw();
//
//        setupListeners();
//    }
//
//}

package edu.lab09; // Upewnij się, że pakiet zgadza się z Twoim folderem (na screenie masz edu.lab09)

import edu.libpanel.PaintPanel;
import edu.shapes.ShapeCircle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Random;

public class MainForm extends JFrame {
    private JPanel mainPanel;

    // ZMIANA 1: Typ pola to JPanel (żeby pasował do pliku .form), a nie PaintPanel
    private JPanel graphicArea;

    private Document document;

    public MainForm() {
        // Konfiguracja okna
        this.setTitle("Kształtowniki");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setContentPane(mainPanel);
        this.pack();
        this.setLocationRelativeTo(null);

        // ZMIANA 2: Rzutowanie na PaintPanel przy tworzeniu dokumentu
        // Ponieważ graphicArea jest teraz typu JPanel, musimy go rzutować,
        // bo wiemy, że w środku "siedzi" PaintPanel (dzięki metodzie createUIComponents)
        document = new Document((PaintPanel) graphicArea);

        document.addShape(new ShapeCircle(200, 200, Color.LIGHT_GRAY, Color.RED, 70));
        document.addShape(new ShapeCircle(600, 300, Color.YELLOW, Color.BLUE, 90));

        // Zadanie samodzielne
        generateRandomShapes(20);

        document.redraw();

        graphicArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                graphicAreaMousePressed(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                graphicAreaMouseReleased();
            }
        });

        graphicArea.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                graphicAreaMouseDragged(e);
            }
        });
    }

    // IntelliJ wywoła tę metodę automatycznie przy tworzeniu formularza.
    // To tutaj "wstrzykujemy" nasz PaintPanel w miejsce zwykłego JPanelu z designera.
    private void createUIComponents() {
        graphicArea = new PaintPanel();
    }
    // -------------------------------------------------------

    private void graphicAreaMousePressed(MouseEvent evt) {
        if (evt.getButton() == MouseEvent.BUTTON1) {

            if (document.selectShape(evt.getX(), evt.getY())) {
                document.redraw();
            }
        }
    }

    private void graphicAreaMouseReleased() {
        document.deselectShape();
        document.redraw();
    }

    private void graphicAreaMouseDragged(MouseEvent evt) {
        document.moveSelectedTo(evt.getX(), evt.getY());
        long time = document.redraw();
        if (time >= 0) {
            setTitle(String.format("Kształtowniki, czas rysowania %d ms", time));
        }
    }

    private void generateRandomShapes(int count) {
        Random rand = new Random();
        int w = graphicArea.getWidth();
        int h = graphicArea.getHeight();
        // Zabezpieczenie na wypadek gdyby panel nie miał jeszcze wymiarów
        if (w == 0) w = 800;
        if (h == 0) h = 600;

        for (int i = 0; i < count; i++) {
            int x = rand.nextInt(w);
            int y = rand.nextInt(h);
            int r = 20 + rand.nextInt(80);

            Color fill = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
            Color border = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));

            document.addShape(new ShapeCircle(x, y, fill, border, r));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainForm().setVisible(true));
    }
}