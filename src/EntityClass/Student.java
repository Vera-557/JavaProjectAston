package EntityClass;
import comparators.InterfaceCompare;

public class Student implements InterfaceCompare<Student> {
    private String groupNumber;
    private double averageScore;
    private int studentBookNumber;

    public Student(String groupNumber, int studentBookNumber, double averageScore) {
        this.groupNumber = groupNumber;
        this.averageScore = averageScore;
        this.studentBookNumber = studentBookNumber;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    public int getStudentBookNumber() {
        return studentBookNumber;
    }

    public void setStudentBookNumber(int studentBookNumber) {
        this.studentBookNumber = studentBookNumber;
    }

    @Override
    public int compareTo(Student o2, String compareBy) {
        switch (compareBy) {
            case "groupNumber":
                return this.getGroupNumber().compareToIgnoreCase(o2.getGroupNumber());
            case "studentBookNumber":
                return Integer.compare(this.getStudentBookNumber(), o2.getStudentBookNumber());
            case "averageScore":
                return Double.compare(this.getAverageScore(), o2.getAverageScore());
            default:
                throw new IllegalArgumentException("Неверное поле сортировки: " + compareBy);
        }
    }
}
