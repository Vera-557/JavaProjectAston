public interface Sortable <T> {
    void sort (T [] array);
}
/*
сортиорвка выбором

public void sort(T [] array) {
for (int i = 0; i < array.length; i ++) {
int minIndex = i;
for (int j = i + 1; j < array.length; j++){
if (((Comparable<T> array[j].compareTo(array[minIndex]) < 0) {
minIndex = j;
}
}
T temp = array[minIndex];
array[minIndex] = array[i];
array[i] = temp;
}
}
 */