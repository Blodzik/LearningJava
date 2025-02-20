public class SalariedEmployee extends Employee {
    private double anualSalary;
    private boolean isRetired;

    public SalariedEmployee(String name, String birthDate, String hireDate, double anualSalary) {
        super(name, birthDate, hireDate);
        this.anualSalary = anualSalary;
    }

    @Override
    public double collectPay() {
        double paycheck = anualSalary / 26;
        double adjustedPay = (isRetired) ? 0.8 * paycheck : paycheck;
        return adjustedPay;
    }

    public void retire() {
        terminate("12/12/2025");
        isRetired = true;
    }
}
