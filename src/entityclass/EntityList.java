package entityclass;

import comparators.InterfaceCompare;
import comparators.Sortable;

/**
 * Класс хранит в себе массив объектов, которые реализуют интерфейс Sortable
 * @param <T>
 */
public class EntityList<T extends InterfaceCompare> implements Sortable<T> {
    private T[] array;

    public T[] getArray() {
        return array;
    }

    public void setArray(T[] array) {
        this.array = array;
    }

    /**
     * принимает в себя массив, содержащий клсс, который может имплементировать InterfaceCompare
     * @param array
     */
    public EntityList(T[] array) {
        this.array = array;
    }


    /**
     * Прямая сортировка по ключу.
     * Автор реализации - Вера.
     * @param sortBy - ключ сортировки
     */
    @Override
    public void sort(String sortBy) {
        for (int i = 0; i < array.length; i ++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++){
                if (array[j].compareTo(array[minIndex], sortBy) < 0) {
                    minIndex = j;
                }
            }
            T temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    /**
     * Тоже, что sort, только сортируются 0 и четные индексы массива
     * @param sortBy
     */
    @Override
    public void sortEven(String sortBy) {
        for (int i = 0; i < array.length; i = i + 2) {
            int minIndex = i;
            for (int j = i + 2; j < array.length; j = j + 2){
                if (array[j].compareTo(array[minIndex], sortBy) < 0) {
                    minIndex = j;
                }
            }
            T temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }
}
