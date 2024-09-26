import java.util.Scanner;

public class Main {
    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first number: ");
        double firstNumber = scanner.nextDouble();

        System.out.print("Enter operation('+', '-', '*', '/'): ");
        String operation = scanner.next();

        System.out.print("Enter second number: ");
        double secondNumber = scanner.nextDouble();

        double result;

        switch(operation) {
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                if(secondNumber != 0) {
                    result = firstNumber / secondNumber;
                } else {
                    System.out.println("Error: devision by 0 is not allowed.");
                    scanner.close();
                    return;
                }
                break;
            default:
                System.out.println("Error: invalid operation.");
                scanner.close();
                return;
        }

        if (result == (int) result) {
            System.out.print("Result: " + (int) result);
        } else {
            System.out.print("Result: " + result);
        }

        scanner.close();
    }
}