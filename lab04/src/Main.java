import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        CBusRoute bus = new CBusRoute(123);
//        CBusRoute tram = new CBusRoute(4);
//
//        tram.addBusStop("Wiadukt");
//        tram.addBusStop("Zajezdanie", "Bronowice", "Centrum");
//        tram.addBusStop("Petla", 750, 3.5f);
//        tram.addBusStop("Politechnika", 5000, 5.0f);
//        tram.addBusStop("Rondo",  1200, 6.0f, "Nowa Huta", "Krowodza", "Kleparz");
//
//
//        bus.addBusStop("Dworzec Glowny", 500, 2.5f);
//        bus.addBusStop("Galeria Centrum", 600, 3.0f);
//        bus.addBusStop("Politechnika", 1200, 6.0f, "AGH", "UJ", "AKADEMIA ROLNICZA");
//        bus.addBusStop("Cmentarz Rakowicki", 400, 2.0f);
//        bus.addBusStop("Wilenska", 400, 2.0f, "Kurdwanow", "Prokocim");
//        bus.addBusStop("Zajezdnia");
//
//
//        System.out.println(tram);
//        System.out.println(bus);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nr. pojazdu: ");
        int number = scanner.nextInt();

        System.out.println("Podaj liczbe przystankow: ");
        int numberOfStops = scanner.nextInt();
        CBusRoute pojazd = new CBusRoute(number);
        for(int i = 0; i < numberOfStops; i++) {
            System.out.println("Podaj nazwe przystanku: ");
            String name = scanner.next();

            System.out.println("Podaj liczbe przesiadek: ");
            int numberOfChanges = scanner.nextInt();
            String nameOfChange = "";
            if(numberOfChanges > 0) {
                for(int j = 0; j < numberOfChanges; j++) {
                    System.out.println("Podaj nazwe przesiadki: ");
                    nameOfChange = scanner.next();
                }
            }

            System.out.println("Podaj za ile metrow jest nastepny przystanek: ");
            int lengthNextStop = scanner.nextInt();

            System.out.println("Podaj za ile minut bedzie nastepny przystanek: ");
            float timeNextStop = scanner.nextFloat();
            if(numberOfChanges > 0) {
                pojazd.addBusStop(name, lengthNextStop, timeNextStop, nameOfChange);
            } else {
                pojazd.addBusStop(name, lengthNextStop, timeNextStop);
            }

        }
        System.out.println(pojazd);
    }
}