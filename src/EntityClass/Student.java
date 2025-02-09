package EntityClass;
import comparators.InterfaceCompare;

public class Student implements InterfaceCompare<Student> {
    private String groupNumber;
    private double averageScore;
    private int studentBookNumber;

    private Student(String groupNumber, int studentBookNumber, double averageScore) {
        this.groupNumber = groupNumber;
        this.averageScore = averageScore;
        this.studentBookNumber = studentBookNumber;
    }

    //TODO Требуется ли валидатор?
    public static boolean groupNumberValidate(String str) {
        return true;
        // return str.matches("^\\d{4} [a-zA-Z]{2}-[1-7]$");
    }

    /**
     * Валидация среднего балла. Не должен быть меньше нуля.
     * @param d
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
     * Валидация номера зачетной книжки. Не должен быть меньше нуля.
     * @param i
     * @return
     */
    public static boolean studentBookNumberValidate(int i) {
        if (i < 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Возвращает экземпляр класса БЕЗ ПРОВЕРКИ данных на валидность
     * @param groupNumber
     * @param studentBookNumber
     * @param averageScore
     * @return
     * @throws Exception
     */
    public static Student create(String groupNumber, int studentBookNumber, double averageScore) throws Exception {
            return new Student(groupNumber, studentBookNumber, averageScore);
    }

    /**
     * Возвращает экземпляр класса С ПРОВЕРКОЙ данных на валидность (если true)
     * @param groupNumber
     * @param studentBookNumber
     * @param averageScore
     * @param needValidate
     * @return
     * @throws Exception
     */
    public static Student create(String groupNumber, int studentBookNumber, double averageScore, boolean needValidate) throws Exception {
        if (needValidate) {
            if (!groupNumberValidate(groupNumber)) throw new IncorrectDataException("ОШИБКА! Некорректный ввод номера автомобиля. Введено: " + groupNumber);
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
                "', " + averageScore
                ;
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
