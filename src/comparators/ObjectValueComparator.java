package comparators;

import comparators.PureComparator;

import java.util.Comparator;

public class ObjectValueComparator<T, R extends Comparable<R>> implements Comparator<T> {

    /**
     * Переменная реализует интерфейс для получения значения поля
     */
    private final ValueExtractor<T, R> valueExtractor;

    public ObjectValueComparator(ValueExtractor<T, R> extractor) {
        this.valueExtractor = extractor;
    }

    /**
     * Сравнивает два значения. поддерживаемые типы: Integer и String
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return
     */
    //@Override
    public int compare(T o1, T o2) {

        if (valueExtractor.extractValue(o1) instanceof Integer) {
            return PureComparator.compareInteger((Integer) valueExtractor.extractValue(o1), (Integer) valueExtractor.extractValue(o2));
        }

        if (valueExtractor.extractValue(o1) instanceof String) {
            String str1 = (String) valueExtractor.extractValue(o1);
            String str2 = (String) valueExtractor.extractValue(o2);
            return PureComparator.compareString(str1,str2);
        }
        throw new ClassCastException("Несравниваемые значения");
    }
}
