package comparators;

/**
 * Сравнивает объект с другим объектом, правило сравнения передается в сигнатуру метода.
 * @param <T>
 */
public interface InterfaceCompare<T> {
    /**
     *
     * @param o2 - сравниваемое значение
     * @param compareBy
     * @return
     */
    int compareTo(T o2, String compareBy);
}
