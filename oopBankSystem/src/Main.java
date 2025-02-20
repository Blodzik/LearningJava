//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        BankAccount first = new BankAccount("Nazar", 1000, 12345);

        System.out.println(first.toString());
        //first.deposit(500);
        //first.getBalance();

        first.withdraw(200);
        //first.getBalance();

        //first.getBalance();

        first.printTransactionHistory();

        SavingAccount firstS = new SavingAccount("Artur", 890, 54321, 7);
        firstS.applyInterest();
        System.out.println(firstS.toString());

//        BankAccount second = new BankAccount("Adrian", 5000, 12345);
//        BankAccount third = new BankAccount("Mike", 10000, 12345);
//        System.out.println(second.toString());
//        System.out.println(third.toString());
    }
}