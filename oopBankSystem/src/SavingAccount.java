public class SavingAccount extends BankAccount {
    private double interestRate;

    public SavingAccount(String holderName, double balance, int pin,  double interestRate) {
        super(holderName, balance, pin);
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        double interest = getBalance() * (interestRate / 100);
        deposit(interest);
        System.out.println("Interest applied: $" + interest);
    }
}
