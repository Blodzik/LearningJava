
public class Main {
    public static void main(String[] args) {
        Warehouse<WeldingRobot> weldingWarehouse = new Warehouse<>();
        BaseRobot genericRobot = RobotFactory.produce("W", "SN-2024-01");
        WeldingRobot myWeldingRobot = null;

        if (genericRobot instanceof WeldingRobot) {
            myWeldingRobot = (WeldingRobot) genericRobot;
        }

        if (myWeldingRobot != null) {
            myWeldingRobot.addObserver(msg -> System.out.println("[ALERT SYSTEMU]: " + msg));

            // 4. Wywołanie settera baterii < 20 (powinno odpalić obserwatora)
            System.out.println("Zmieniam poziom baterii na 15%...");
            myWeldingRobot.setBatteryLevel(15);

            // 5a. Dodanie robota do Warehouse
            try {
                weldingWarehouse.store(myWeldingRobot);
                System.out.println("Robot pomyślnie dodany do magazynu.");
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

            // 5b. Wywołanie performTask korzystając z referencji typu Workable (Polimorfizm)
            // Wyciągamy robota z magazynu jako Workable
            Workable worker = weldingWarehouse.getRobotBySN("SN-2024-01");
            if (worker != null) {
                worker.performTask("Spawanie ramy podwozia");
            }
        }
    }
}