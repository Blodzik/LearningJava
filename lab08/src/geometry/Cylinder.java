package geometry;

public class Cylinder extends Cone {
    public Cylinder(int mass, int radius) {
        super(mass, radius);
    }

    @Override
    public double calculateMoment() {
        return (1./2) * mass * Math.pow(radius, 2);
    }
}
