package entityclass;

import com.fasterxml.jackson.annotation.JsonProperty;
import comparators.InterfaceCompare;
import comparators.PureComparator;
import search.ValueExtractor;

/**
 * Описывает класс Student
 * @author Виктор Карпов
 */
public class Student implements InterfaceCompare<Student>, ValueExtractor<Student, Object> {
    private String groupNumber;
    private double averageScore;
    private int studentBookNumber;

    /**
     * Допустимые ключи сортировки
     */
    public enum KeySort {
        groupNumber,
        averageScore,
        studentBookNumber
    }

//    private Student(String groupNumber, int studentBookNumber, double averageScore) {
        private Student(@JsonProperty("groupNumber") String groupNumber, @JsonProperty("studentBookNumber") int studentBookNumber, @JsonProperty("averageScore") double averageScore) {
        this.groupNumber = groupNumber;
        this.averageScore = averageScore;
        this.studentBookNumber = studentBookNumber;
    }

    // TODO: Требуется ли валидатор?
    public static boolean groupNumberValidate(String str) {
        return true; // Можно добавить более сложную валидацию при необходимости
    }

    /**
     * Валидация среднего балла.
     * @param d не должен быть меньше нуля.
     * @return
     */
    public static boolean averageScoreValidate(double d) {
        if (d < 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Валидация номера зачетной книжки.
     * @param i не должен быть меньше нуля
     * @return
     */
    public static boolean studentBookNumberValidate(int i) {
        if (i < 0) {
            return false;
        } else {
            return true;
        }
    }

    @Deprecated
    public static Student create(String groupNumber, int studentBookNumber, double averageScore) throws Exception {
        return new Student(groupNumber, studentBookNumber, averageScore);
    }

    public static Student create(String groupNumber, int studentBookNumber, double averageScore, boolean needValidate) throws Exception {
        if (needValidate) {
            if (!groupNumberValidate(groupNumber)) throw new IncorrectDataException("ОШИБКА! Некорректный ввод номера группы. Введено: " + groupNumber);
            if (!studentBookNumberValidate(studentBookNumber)) throw new IncorrectDataException("ОШИБКА! Номер зачётной книжки не может быть отрицательным. Введено: " + studentBookNumber);
            if (!averageScoreValidate(averageScore)) throw new IncorrectDataException("ОШИБКА! Средний балл не может быть отрицательным. Введено: " + averageScore);
            return new Student(groupNumber, studentBookNumber, averageScore);
        } else {
            return new Student(groupNumber, studentBookNumber, averageScore);
        }
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
    public String toString() {
        return "EntityClass.Student:" +
                " " + groupNumber +
                ", '" + studentBookNumber +
                "', " + averageScore;
    }

    @Override
    public int compareTo(Student o2, String compareBy) {
        switch (compareBy) {
            case "groupNumber":
                return PureComparator.compareString(this.getGroupNumber(), o2.getGroupNumber());
            case "studentBookNumber":
                return PureComparator.compareInteger(this.getStudentBookNumber(), o2.getStudentBookNumber());
            case "averageScore":
                return PureComparator.compareDouble(this.getAverageScore(), o2.getAverageScore());
            default:
                throw new IllegalArgumentException("Неверное поле сортировки: " + compareBy);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentBookNumber == student.studentBookNumber;
    }

    @Override
    public int hashCode() {
        return studentBookNumber;
    }


    @Override
    public Object extractValue(Student object, String field) {
        switch (field) {
            case "groupNumber":
                return object.getGroupNumber();
            case "studentBookNumber":
                return object.getStudentBookNumber();
            case "averageScore":
                return object.getAverageScore();
            default:
                throw new IllegalArgumentException("Неизвестное поле: " + field);
        }
    }
}