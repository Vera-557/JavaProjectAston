package comparators;

/**
 * Интерфейс сортировки
 * @author Виктор Карпов
 * @param <T>
 */
public interface Sortable<T> {

    /**
     * Сортировка в прямом порядке
     * @param sortBy указывает по какому полю требуется сортировка
     */
    void sort (String sortBy);

    /**
     * Сортировка в прямом порядке по четным индексам
     * @param sortBy указывает по какому полю требуется сортировка
     */
    void sortEven (String sortBy);
}
