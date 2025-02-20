//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Employee tim = new Employee("Tim", "18/06/2006","12/12/2025");
        System.out.println(tim);
        System.out.println("Age: " + tim.getAge());
        System.out.println("Pay: " + tim.collectPay());

        SalariedEmployee joe   = new SalariedEmployee("Joe", "18/06/2005","12/12/2023", 35000);
        System.out.println(joe.toString());
        System.out.println("Joes paycheck: " + joe.collectPay());

        joe.retire();
        System.out.println("Joes paycheck after retire: " + joe.collectPay());

        HourlyEmployee mary = new HourlyEmployee("Mary", "21/02/2006", "11/11/2024", 20);
        System.out.println(mary);
        System.out.println("Mary paycheck: " + mary.collectPay());
        System.out.println("Mary holidays paycheck: " + mary.getDoublePay() );
    }
}