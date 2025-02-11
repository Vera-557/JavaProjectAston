package search;

import java.util.Comparator;
import java.util.List; // Импорт для List
import java.util.ArrayList; // Импорт для ArrayList

public class BinarySearch {

    /**
     * Выполняет бинарный поиск в отсортированном массиве объектов.
     *
     * @param array    - массив объектов для поиска
     * @param value    - значение для поиска
     * @param field    - поле, по которому выполняется сравнение
     * @param extractor - экстрактор значений из объектов
     * @return индекс элемента, если найден; иначе -1
     */
    public static <T> int binarySearch(T[] array, Object value, String field, ValueExtractor<T, ?> extractor) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            Object midVal = extractor.extractValue(array[mid], field);
            int cmp = compare(midVal, value);
            if (cmp == 0) {
                return mid; // Элемент найден
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // Элемент не найден
    }

    /**
     * Сравнивает два значения.
     *
     * @param o1 первое значение
     * @param o2 второе значение
     * @return результат сравнения
     */
    private static int compare(Object o1, Object o2) {
        if (o1 instanceof Comparable && o2 instanceof Comparable) {
            return ((Comparable) o1).compareTo(o2);
        }
        throw new IllegalArgumentException("Невозможно сравнить значения: " + o1 + " и " + o2);
    }

    /**
     * Нечеткий поиск в отсортированном массиве (по частичному совпадению).
     *
     * @param array     - массив объектов для поиска
     * @param value     - значение для поиска
     * @param field     - поле, по которому выполняется сравнение
     * @param extractor - экстрактор значений из объектов
     * @return список индексов элементов, которые частично совпадают с искомым значением
     */
    public static <T> List<Integer> fuzzySearch(T[] array, String value, String field, ValueExtractor<T, ?> extractor) {
        List<Integer> matches = new ArrayList<>(); // Создание списка для хранения совпадений
        for (int i = 0; i < array.length; i++) {
            Object fieldValue = extractor.extractValue(array[i], field);
            if (fieldValue instanceof String && ((String) fieldValue).contains(value)) {
                matches.add(i);
            }
        }
        return matches;
    }
}