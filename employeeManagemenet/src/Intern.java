public class Intern extends Employee{
    public Intern(int id, String name, double salary) {
        super(id, name, salary);
    }
    @Override
    public void work() {
        System.out.println(name + " (ID: " + id + " ) is learning a new programming skills");
    }

    public void learnSkills() {
        System.out.println(name + " is attending training sessions.");
    }

    @Override
    public double calculateBonus() {
        return 500;
    }
}
