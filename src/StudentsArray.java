import EntityClass.Bus;
import EntityClass.Student;
import comparators.Sortable2;

public class StudentsArray implements Sortable2<Student> {
    Student[] array;

    public StudentsArray(Student[] array) {
        this.array = array;
    }

    @Override
    public void sort(String sortBy) {
        for (int i = 0; i < array.length; i ++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++){
                if (array[j].compareTo(array[minIndex], sortBy) < 0) {
                    minIndex = j;
                }
            }
            Student temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }
}