


public class Main {
    public static void main(String[] args) {
        University university = new University();

        Course math = new Course("Mathematics", "MATH101");
        Course cs = new Course("Computer Science", "CS102");

        university.addCourse(math);
        university.addCourse(cs);

        Student alice = new Student("Alice", "S01");
        Student bob = new Student("Bob", "S02");

        math.enrollStudent(alice);
        math.enrollStudent(bob);

        cs.enrollStudent(bob); // Bob is enrolled in CS

        alice.addGrade(new Grade("MATH101", 95));
        bob.addGrade(new Grade("MATH101", 88));
        bob.addGrade(new Grade("CS102", 92));

        university.printCourses();
        math.printStudents();
        bob.printGrades();
    }
}