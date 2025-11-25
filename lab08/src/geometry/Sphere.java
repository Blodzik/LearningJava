package geometry;

public class Sphere extends Ball {
    public Sphere(int mass, int diameter) {
        super(mass, diameter);
    }

    @Override
    public double calculateMoment() {
        return (1./6) * mass * Math.pow(diameter,2);
    }
}
