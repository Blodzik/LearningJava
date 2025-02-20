import java.util.ArrayList;
import java.util.Scanner;

public class BankAccount {
    private int accountNumber;
    private static int nextAccountNumber = 1000;
    private String holderName;
    private double balance;
    private ArrayList<String> transactionHistory;
    private int pin;

    public BankAccount(String holderName, double balance, int pin) {
        this.accountNumber = nextAccountNumber++;
        this.holderName = holderName;
        this.balance = balance;
        this.pin = pin;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account opened with balance: $" + balance);
    }

    public double getBalance() {
        return balance;
    }

    public void printBalance() {
        System.out.println("Balance: " + balance);
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited $" + amount);
        transactionHistory.add("Deposited $" + amount);
    }

    public void withdraw(double amount) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTries = 0;

        while (numberOfTries < 3) {
            System.out.print("Enter your PIN: ");
            int enteredPin = scanner.nextInt();

            if (enteredPin == pin) {
                if (amount > balance) {
                    System.out.println("Insufficient balance.");
                } else {
                    balance -= amount;
                    System.out.println("Withdrawn $" + amount);
                    transactionHistory.add("Withdrawn $" + amount);
                }
                return;
            } else { //
                numberOfTries++;
                System.out.println("Incorrect PIN. Attempts left: " + (3 - numberOfTries));
            }
        }

        System.out.println("Your account has been blocked due to multiple incorrect PIN attempts.");
    }

    public void printTransactionHistory() {
        System.out.println("Transaction History for: " + holderName + ":");
        for (String transation : transactionHistory) {
            System.out.println(transation);
        }
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber=" + accountNumber +
                ", holderName='" + holderName + '\'' +
                ", balance=" + balance +
                '}';
    }
}
