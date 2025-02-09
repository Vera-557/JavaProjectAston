import java.util.*;

public class Main {
    public static void main() {
        List<Integer> data = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nМеню:");
            System.out.println("1. Заполнить данные в ручную");
            System.out.println("2. Заполнить данные автоматически");
            System.out.println("3. Отсортировать данные");
            System.out.println("4. Найти элемент");
            System.out.println("5. Вывести данные");
            System.out.println("6. Выйти");
            System.out.println("Выберете опцию");

            int choice = validatedInt(scan);

            switch (choice) {
                case 1:
                    fillDataHand(scan, data);
                    break;
                case 2:
                    fillDataAuto(data);
                    break;
                case 3:
                    sortData(scan, data);
                    break;
                case 4:
                    searchData(scan, data);
                    break;
                case 5:
                    printData(data);
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
        scan.close();
    }

    private static int validatedInt(Scanner scan) {
        while (!scan.hasNextInt()) {
            System.out.println("Ошибка: введите целое число.");
            scan.next();
        }
        return scan.nextInt();
    }

    private static void fillDataHand(Scanner scan, List<Integer> data){
        System.out.println("Введите количество элементов: ");
        int count = Main.validatedInt(scan);

        data.clear();
        for (int i = 0 ; i < count; i++) {
            System.out.println("Введите элемент " + (i + 1) + ": ");
            data.add(Main.validatedInt(scan));
        }
    }

    private static void fillDataAuto(List<Integer> data) {
        data.clear();
        for (int i = 0; i < 10; i++) {
            data.add((int) (Math.random() * 100));
        }
        System.out.println("Данные заполнены автоматически.");
    }

    private static void sortData(Scanner scan, List<Integer> data) {
        System.out.println("Выберите метод сортировки:");
        System.out.println("1. По возпастанию");
        System.out.println("2. По убыванию");
        int choice = validatedInt(scan);

        if (choice == 1) {
            Collections.sort(data);
            System.out.println("Данные отсортированы по возрастанию.");
        } else if (choice == 2) {
            data.sort(Comparator.reverseOrder());
            System.out.println("Данные отсортированы по убыванию.");
        } else {
            System.out.println("Неверный выбор.");
        }
    }
//бинарный поиск
    private static void searchData(Scanner scan, List<Integer> data) {
        System.out.println("Введите элемент для поиска: ");
        int element = validatedInt(scan);

        int index = Collections.binarySearch(data, element);
        if (index >= 0) {
            System.out.println("Элемент найден на позиции: " + index);
        } else {
            System.out.println("Элемент не найден");
        }
    }
    private static void printData(List<Integer> data){
        if (data.isEmpty()) {
            System.out.println("Данные отсутствуют.");
        } else {
            System.out.println("Данные: " + data);
        }
    }
}



