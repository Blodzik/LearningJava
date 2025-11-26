package geometry;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Cone extends AbstractSolid {
    protected int radius;

    public Cone(int mass, int radius) {
        super(mass);
        setRadius(radius);
    }

    public int getRadius() {
        return radius;
    }

    public final void setRadius(int radius) {
        if(radius < 0) {
            throw new IllegalArgumentException("Promień nie może być mniejszy od zera");
        }
        this.radius = radius;
    }

    @Override
    public double calculateMoment() {
        return (3./10) * mass * Math.pow(radius, 2);
    }

    @Override
    public void readData(JTable table) {
        super.readData(table);
        try {
            setRadius(Integer.parseInt(table.getValueAt(1, 1).toString()));
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("Błąd formatu liczby dla promienia.");
        }
    }

    @Override
    public void showData(JTable table, DefaultTableModel model) {
        super.showData(table, model);
        model.setRowCount(2);
        model.setValueAt("Promień", 1, 0);
        model.setValueAt(radius, 1, 1);
    }

}
