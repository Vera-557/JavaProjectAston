package comparators;

public class PureComparator {
    public static int compareInteger(Integer o1, Integer o2) {
        if (o1 == o2) return 0;
        if (o1 > o2) {
            return 1;
        } else {
            return -1;
        }
    }

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
