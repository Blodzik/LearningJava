import java.util.Scanner;

public class Main {
    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);

        boolean continueCalculating = true;

        double result;

        System.out.print("Enter first number: ");
        result = scanner.nextDouble();

        while (continueCalculating) {

            System.out.print("Enter operation('+', '-', '*', '/', '%', '^'): ");
            String operation = scanner.next();

            switch(operation) {
                case "+":
                    System.out.print("Enter second number: ");
                    double addNumber = scanner.nextDouble();
                    result += addNumber;
                    break;
                case "-":
                    System.out.print("Enter second number: ");
                    double subNumber = scanner.nextDouble();
                    result -= subNumber;
                    break;
                case "*":
                    System.out.print("Enter second number: ");
                    double mulNumber = scanner.nextDouble();
                    result *= mulNumber;
                    break;
                case "/":
                    System.out.print("Enter second number: ");
                    double devNumber = scanner.nextDouble();
                    if(devNumber != 0) {
                        result /= devNumber;
                    } else {
                        System.out.println("Error: division by 0 is not allowed.");
                        scanner.close();
                        return;
                    }
                    break;
                case "^":
                    System.out.print("Enter the power to raise the result to: ");
                    double power = scanner.nextDouble();
                    result = Math.pow(result, power);
                    break;
                case "%":
                    result /= 100;
                    break;
                default:
                    System.out.println("Error: invalid operation.");
                    scanner.close();
                    return;
            }

            if (result == (int) result) {
                System.out.println("Result: " + (int) result);
            } else {
                System.out.print("Result: " + result);
            }

            String choice;
            do {
                System.out.print("Do you want to continue with this result(y/n)? ");
                choice = scanner.next();
                if (!choice.equalsIgnoreCase("n") && !choice.equalsIgnoreCase("y")) {
                    System.out.println("Error: invalid input. Please enter 'y' or 'n'");
                }
            } while (!choice.equalsIgnoreCase("n") && !choice.equalsIgnoreCase("y"));

            if(choice.equalsIgnoreCase("n")) {
                continueCalculating = false;
            }
        }

        System.out.print("Calculation ended.");
        scanner.close();
    }
}