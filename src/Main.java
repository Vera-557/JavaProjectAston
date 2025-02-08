import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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
        return  scan.nextInt();
    }
}

