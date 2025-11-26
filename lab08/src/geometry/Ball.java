package geometry;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Ball extends AbstractSolid {
    protected int diameter;

    public Ball(int mass, int diameter) {
        super(mass);
        setDiameter(diameter);
    }

    public int getDiameter() {
        return diameter;
    }

    public final void setDiameter(int diameter) {
        if(diameter < 0) {
            throw new IllegalArgumentException("Średnica musi być mniejsza od zera");
        }
        this.diameter = diameter;
    }

    @Override
    public double calculateMoment() {
        return (1./10) * mass * Math.pow(diameter, 2);
    }

    @Override
    public void readData(JTable table) {
        super.readData(table);
        try {
            setDiameter(Integer.parseInt(table.getValueAt(1, 1).toString()));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Błąd formatu liczby dla średnicy.");
        }
    }

    @Override
    public void showData(JTable table, DefaultTableModel model) {
        super.showData(table, model);
        model.setRowCount(2);
        table.setValueAt("Średnica", 1, 0);
        table.setValueAt(diameter,1,1);
    }
}
