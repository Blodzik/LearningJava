import java.util.ArrayList;

public class Student {
    private String name;
    private String studentId;
    private ArrayList<Grade> grades;

    public Student(String name, String studentId) {
        this.name = name;
        this.studentId = studentId;
        this.grades = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getStudentId() {
        return studentId;
    }

    public void addGrade(Grade grade) {
        grades.add(grade);
    }

    public void printGrades() {
        for (Grade grade : grades) {
            System.out.println(grade.getCourseCode() + ": " + grade.getNumericScore());
        }
    }


}
