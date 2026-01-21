public abstract class BaseRobot {
   protected String serialNumber;
   protected int batteryLevel;
   private static final String FACTORY_NAME = "Central Branch";

   public BaseRobot(String serialNumber, int batteryLevel) {
       setSerialNumber(serialNumber);
       setBatteryLevel(batteryLevel);
   }

    public String getSerialNumber() {
        return serialNumber;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void setSerialNumber(String serialNumber) {
        if(serialNumber != null && !serialNumber.isEmpty()) {
            this.serialNumber = serialNumber;
        } else {
            this.serialNumber = null;
        }
    }

    public void setBatteryLevel(int batteryLevel) {
        if(batteryLevel >= 0 && batteryLevel <= 100) {
            this.batteryLevel = batteryLevel;
        } else {
            this.batteryLevel = 0;
        }
    }

    public static String getFactoryName() {
       return FACTORY_NAME;
    }

    public abstract double calculateEfficiency();
}
