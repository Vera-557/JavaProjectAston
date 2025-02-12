package comparators;

/**
 * Класс реализует собственную локгику сравнения, не используя встроенные механизмы Java. Поддерживаемые типы: String и Integer
 * @author Виктор Карпов
 */
public class PureComparator {

    /**
     * Сравнивает два значения типа Integer
     * @param o1 первое сравниваемое значение типа Integer
     * @param o2 второе сравниваемое значение типа Integer
     * @return - значения равны, -1 если o1>02 и 1 если o1<02
     */
    public static int compareInteger(Integer o1, Integer o2) {
        if (o1 == o2) return 0;
        if (o1 > o2) {
            return 1;
        } else {
            return -1;
        }
    }

    /**
     * Сравнивает два значения типа Double
     * @param o1 первое сравниваемое значение типа Double
     * @param o2 второе сравниваемое значение типа Double
     * @return - значения равны, -1 если o1 > 02 и 1 если o1 < 02
     */
    public static int compareDouble(Double o1, Double o2) {
        if (o1 == o2) return 0;
        if (o1 > o2) {
            return 1;
        } else {
            return -1;
        }
    }

    /**
     * Сравнивает два значения типа Integer
     * @param str1 первое сравниваемое значение типа String
     * @param str2 второе сравниваемое значение типа String
     * @return - значения равны, -1 если str1 > str2 и 1 если str1 < str2
     */
    public static int compareString(String str1, String str2) {
        int minLenght;
        if (str1.length() < str2.length()) {
            minLenght = str1.length();
        } else {
            minLenght = str2.length();
        }
        for (int i = 0; i < minLenght; i++) {
            if (str1.charAt(i) == str2.charAt(i)) continue;
            if (str1.charAt(i) > str2.charAt(i)) return 1;
            if (str1.charAt(i) < str2.charAt(i)) return -1;
        }
        return 0;
    }

}
