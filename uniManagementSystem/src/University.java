import java.util.ArrayList;

public class University {
    private CourseList courseList;

    public University() {
        courseList = new CourseList();
    }

    public void addCourse(Course course) {
        courseList.add(course);
    }

    public Course getCourse(String courseCode) {
        return courseList.findCourse(courseCode);
    }

    public void printCourses() {
        courseList.printAllCourses();
    }

    public static class CourseList {
        private ArrayList<Course> courses;

        public CourseList() {
            this.courses = new ArrayList<>();
        }

        public Course findCourse(String code) {
            for (Course course : courses) {
                if (course.getCode().contains(code)) {
                    return course;
                }
            }
            return null;
        }

        public void add(Course course) {
            if(findCourse(course.getCode()) == null) {
                courses.add(course);
            } else {
                System.out.println("Course already exists");
            }
        }

        public void printAllCourses() {
            for (Course course : courses) {
                System.out.println(course.getTitle() + " (" + course.getCode() + ")");
            }
        }
    }
}
