package EntityClass;

import comparators.InterfaceCompare;
import comparators.Sortable;

/**
 * Класс хранит в себе массив объектов, которые реализуют интерфейс Sortable
 * @param <T>
 */
public class EntityList<T extends InterfaceCompare> implements Sortable<T> {
    T[] array;

    public EntityList(T[] array) {
        this.array = array;
    }


    /**
     * Прямая сортировка по ключу
     * @param sortBy - ключ сортировки
     */
    @Override
    public void sort(String sortBy) {
        for (int i = 0; i < array.length; i ++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++){
                if (array[j].compareTo(array[minIndex], "odometer") < 0) {
                    minIndex = j;
                }
            }
            T temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }
}
