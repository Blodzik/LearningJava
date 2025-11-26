package geometry;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Cuboid extends AbstractSolid{
    protected int length;
    protected int width;

    public Cuboid(int mass, int length, int width) {
        super(mass);
        setLength(length);
        setWidth(width);
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public final void setLength(int length) {
        if(length < 0) {
            throw new IllegalArgumentException("Długość nie może być mniejsza od zera");
        }
        this.length = length;
    }

    public final void setWidth(int width) {
        if(width < 0) {
            throw new IllegalArgumentException("Szerokość nie może być mniejsza od zera");
        }
        this.width = width;
    }

    @Override
    public double calculateMoment() {
        return (1./12) * mass * (Math.pow(length, 2) + Math.pow(width, 2));
    }

    @Override
    public void readData(JTable table ){
        super.readData(table);
        try {
            setLength(Integer.parseInt(table.getValueAt(1, 1).toString()));
            setWidth(Integer.parseInt(table.getValueAt(2, 1).toString()));
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("Błąd danych prostopadłościanu");
        }
    }

    @Override
    public void showData(JTable table, DefaultTableModel model){
        super.showData(table, model);
        model.setRowCount(3);
        table.setValueAt("Długość", 1, 0);
        table.setValueAt(length, 1, 1);
        table.setValueAt("Szerokość", 2, 0);
        table.setValueAt(width, 2, 1);
    }
}
