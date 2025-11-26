package geometry;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public abstract class AbstractSolid {
    protected int mass;

    public AbstractSolid(int mass) {
        setMass(mass);
    }

    public int getMass() {
        return mass;
    }

    public final void setMass(int mass) {
        if(mass < 0) {
            throw new IllegalArgumentException("Masa nie może być mniejsza od zera");
        }
        this.mass = mass;
    }

    public abstract double calculateMoment();

    public void readData(JTable table) {
        try {
            setMass(Integer.parseInt(table.getValueAt(0, 1).toString()));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Błąd formatu liczby dla masy.");
        }
    }

    public void showData(JTable table, DefaultTableModel model) {
        model.setRowCount(1); // Resetujemy do 1 wiersza (sama masa)
        table.setValueAt("Masa", 0, 0);
        table.setValueAt(mass, 0, 1);
    }


}
