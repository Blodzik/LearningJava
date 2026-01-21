import java.util.ArrayList;
import java.util.List;

public class WeldingRobot extends BaseRobot implements Workable {

    private double gasPressure;
    private List<StatusListener> observers = new ArrayList<>();

    public WeldingRobot(String serialNumber, int batteryLevel, double gasPressure) {
        super(serialNumber, batteryLevel);
        setGasPressure(gasPressure);
        this.observers = new ArrayList<>();
    }

    public void addObserver(StatusListener observer) {
        if (observer != null) {
            observers.add(observer);
        }
    }

    public void removeObserver(StatusListener observer) {
        observers.remove(observer);
    }

    public void setBatteryLevel(int batteryLevel) {
        this.batteryLevel = batteryLevel;

        if (batteryLevel < 20) {
            notifyObservers("Low Battery!");
        }
    }

    private void notifyObservers(String message) {

        if (observers == null) return;

        for (StatusListener observer : observers) {
            observer.onAlert(message);
        }
    }

    public double getGasPressure() {
        return gasPressure;
    }

    public void setGasPressure(double gasPressure) {
        this.gasPressure = Math.max(gasPressure, 0);
    }

    @Override
    public void performTask(String taskName) {
        System.out.printf("Robot [%s] spawanie: %s%n", serialNumber, taskName);
    }

    @Override
    public double calculateEfficiency() {
        return batteryLevel - gasPressure;
    }
}
