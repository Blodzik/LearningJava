import java.util.Scanner;

public class temperatureConverter {
    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter F to convert Fahrenheit to Celsius and  Kelvin;");
        System.out.println("Enter C to convert Celsius to Fahrenheit and  Kelvin;");
        System.out.println("Enter K to convert Kelvin to Celsius and  Fahrenheit;");
        System.out.print("Choose conversion type (F, C, K): ");

        String conversionType = scanner.next().toUpperCase();

        System.out.print("Enter a temperature value: ");

        if(!scanner.hasNextDouble()) {
            System.out.print("Invalid temperature value. Please enter numeric value.");
            return;
        }

        double temperature = scanner.nextDouble();

        switch (conversionType) {
            case "F" -> {
                double cValue = (temperature - 32) * 5 / 9;
                double kValue = (temperature - 32) * 5 / 9 + 273.15;
                System.out.printf("Celsius: %.2f°C%n", cValue);
                System.out.printf("Kelvin: %.2fK%n", kValue);
            }
            case "C" -> {
                double fValue = (temperature * 9 / 5) + 32;
                double kValue = temperature + 273.15;
                System.out.printf("Fahrenheit: %.2f°F%n", fValue);
                System.out.printf("Kelvin: %.2fK%n", kValue);
            }
            case "K" -> {
                if (temperature < 0) {
                    System.out.print("Invalid temperature. Kelvin can not be negative");
                } else {
                    double cValue = temperature - 273.15;
                    double fValue = (temperature - 273.15) * 9 / 5 + 32;
                    System.out.printf("Celsius: %.2f°C%n", cValue); 
                    System.out.printf("Fahrenheit: %.2f°F%n", fValue);
                }
            }
            default -> System.out.print("Invalid convertion type. Please enter F, C or K.");
        }

        scanner.close();
    }
}