import java.util.ArrayList;

public class Course {
    private String title;
    private String code;
    private StudentList studentList;

    public Course(String title, String code) {
        this.title = title;
        this.code = code;
        studentList = new StudentList();
    }

    public void enrollStudent(Student student) {
        studentList.add(student);
    }

    public boolean isStudentEnrolled(String studentId) {
        return studentList.findStudent(studentId) != null;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public void printStudents() {
        studentList.printAllStudents();
    }


    public static class StudentList {
        private ArrayList<Student> students;

        public StudentList() {
            this.students = new ArrayList<>();
        }

        private Student findStudent(String studentId) {
            for(Student student : students) {
                if(student.getStudentId().contains(studentId)) {
                    return student;
                }
            }
            return null;
        }

        private void add(Student student) {
            if(findStudent(student.getStudentId()) == null) {
                students.add(student);
            } else {
                System.out.println("Student already exists");
            }
        }

        private void printAllStudents() {
            for (Student student : students) {
                System.out.println(student.getName() + " (" + student.getStudentId() + ")");
            }
        }
    }
}
