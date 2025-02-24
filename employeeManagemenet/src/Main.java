//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Employee emp1 = new Manager(101, "John", 60000);
        Employee emp2 = new Developer(102, "Alice", 40000);
        Employee emp3 = new Intern(103, "Bob", 20000);

        emp1.work();
        emp2.work();
        emp3.work();

        ((Manager) emp1).manageTeam();
        ((Developer) emp2).writeCode();
        ((Intern) emp3).learnSkills();

        System.out.println("Bonus: " + emp1.calculateBonus());
        System.out.println("Bonus: " + emp2.calculateBonus());
        System.out.println("Bonus: " + emp3.calculateBonus());
    }
}