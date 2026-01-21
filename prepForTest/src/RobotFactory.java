public class RobotFactory {
    public static BaseRobot produce(String type, String serialNumber) {
        if(type.equalsIgnoreCase("W")) {
            return new WeldingRobot(serialNumber, 0, 100);
        }
        return null;
    }
}
