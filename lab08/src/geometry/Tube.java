package geometry;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Tube extends Cylinder {
    protected int radius1;

    public Tube(int mass, int radius, int radius1) {
        super(mass, radius);
        setRadius1(radius1);
    }

    public int getRadius1() {
        return radius1;
    }

    public final void setRadius1(int radius1) {
        if(radius1 < 0) {
            throw new IllegalArgumentException("Promień nie może być mniejszy od zera.");
        } else {
            this.radius1 = radius1;
        }
    }

    @Override
    public double calculateMoment() {
        return (1./2) * mass * (Math.pow(radius, 2) + Math.pow(radius1, 2));
    }

    @Override
    public void readData(JTable table) {
        super.readData(table);
        try {
            setRadius1(Integer.parseInt(table.getValueAt(2, 1).toString()));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Błąd formatu liczby dla promienia");
        }
    }

    @Override
    public void showData(JTable table, DefaultTableModel model) {
        model.setRowCount(3);
        table.setValueAt("Masa", 0, 0);
        table.setValueAt(mass, 0, 1);
        table.setValueAt("Promień zewnętrzny", 1, 0);
        table.setValueAt(radius, 1, 1);

        table.setValueAt("Promień wewnętrzny.", 2, 0);
        table.setValueAt(radius1, 2, 1);
    }

}
