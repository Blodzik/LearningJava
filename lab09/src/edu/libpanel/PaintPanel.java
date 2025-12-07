package edu.libpanel;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class PaintPanel extends JPanel {
    private BufferedImage image;

    public PaintPanel() {
        super();
        this.setBackground(Color.WHITE);
    }

    public void assignDrawing(BufferedImage img) {
        this.image = img;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 0, 0, this);
        }
    }
}