package comparators;

public interface ValueExtractor<T, R> {

    /**
     * Метод для получения значения поля. Реализуя метод, мы определяем как именно извлекать тип значения.
     * @param t T тип объекта, из которого будем извлекать значение
     * @return R - тип значения, которое мы хотим извлечь
     * @author Виктор Карпов
     */
    public R extractValue(T t);
}
