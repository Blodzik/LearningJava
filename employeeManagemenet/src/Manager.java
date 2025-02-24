public class Manager extends Employee {
    public Manager(int id, String name, double salary) {
        super(id, name, salary);
    }

    @Override
    public void work() {
        System.out.println(name + " (ID: " + id + " ) is managing the team." );
    }

    public void manageTeam() {
        System.out.println(name + "is organizing meetings and assigning tasks.");
    }

    @Override
    public double calculateBonus() {
        return (salary * 0.2);
    }
}
