package edu.lab09;

import edu.libpanel.PaintPanel;
import edu.shapes.IShape;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Document {
    private List<IShape> shapes;
    private BufferedImage image;
    private PaintPanel graphicArea;
    private IShape shapeSelected;

    public Document(PaintPanel graphicArea) {
        this.graphicArea = graphicArea;
        this.image = new BufferedImage(graphicArea.getWidth(),
                graphicArea.getHeight(),
                BufferedImage.TYPE_INT_RGB);
        this.shapes = new ArrayList<>();
        this.shapeSelected = null;
    }

    private void repaintImage() {
        graphicArea.assignDrawing(image);
        graphicArea.repaint();
    }

    private void clearImage() {
        Graphics gg = image.getGraphics();
        gg.setColor(Color.WHITE);
        gg.fillRect(0, 0, image.getWidth(), image.getHeight());
    }

    public void clear() {
        shapes.clear();
        clearImage();
        repaintImage();
    }

    public boolean selectShape(int ax, int ay) {
        ListIterator<IShape> it = shapes.listIterator(shapes.size());
        while (it.hasPrevious()) {
            IShape f = it.previous();
            if (f.select(ax, ay)) {
                shapeSelected = f;
                return true;
            }
        }
        return false;
    }

    public void deselectShape() {
        shapeSelected = null;
    }

    public void addShape(IShape newShape) {
        shapes.add(newShape);
    }

    public void moveSelectedTo(int x, int y) {
        if (shapeSelected != null) {
            shapeSelected.moveTo(x, y);
        }
    }

    public long redraw() {
        long t = System.currentTimeMillis();
        clearImage();
        Graphics g = image.getGraphics();

        ((Graphics2D) g).setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        for (IShape shape : shapes) {
            if (shape != shapeSelected) shape.draw(g, false);
        }

        if (shapeSelected != null) {
            ((Graphics2D) g).setComposite(
                    AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f));
            shapeSelected.draw(g, true);
        }

        repaintImage();
        return System.currentTimeMillis() - t;
    }
}