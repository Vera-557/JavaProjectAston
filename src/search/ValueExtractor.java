package search;

public interface ValueExtractor<T, R> {
    /**
     * Метод для получения значения поля.
     *
     * @param t     объект, из которого извлекается значение.
     * @param field имя поля.
     * @return значение поля типа R.
     */
    R extractValue(T t, String field);
}