public class Developer extends Employee {
    public Developer(int id, String name, double salary) {
        super(id, name, salary);
    }

    @Override
    public void work() {
        System.out.println(name + " (ID: " + id + " ) is writing Java code.");
    }

    public void writeCode() {
        System.out.println(name + " is fixing bugs and developing new features.");
    }

    @Override
    public double calculateBonus() {
        return (salary * 0.1);
    }
}
