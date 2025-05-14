public class Grade {
    private String courseCode;
    private double numericScore;

    public Grade(String courseCode, double numericScore) {
        this.courseCode = courseCode;
        this.numericScore = numericScore;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public double getNumericScore() {
        return numericScore;
    }
}
