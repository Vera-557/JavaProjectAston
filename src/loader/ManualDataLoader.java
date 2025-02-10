package loader;

import entityclass.Bus;
import entityclass.Student;
import entityclass.EntityType;
import entityclass.User;
import comparators.InterfaceCompare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ManualDataLoader<T extends InterfaceCompare> implements DataLoadStrategy<T> {
    private final EntityType type;

    public ManualDataLoader(final EntityType type) {
        this.type = type;
    }

    @Override
    public List<T> loadData() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите количество элементов: ");
        int count = scanner.nextInt();
        scanner.nextLine();
        //TODO заменить list на EntityList
        List<T> list = new ArrayList<>(count);
        switch (type) {
            case BUS -> {
                busFill((List<Bus>) list, count, scanner);
                break;
            }
            case USER -> {
                userFill((List<User>) list, count, scanner);
                break;
            }
            case STUDENT -> {
                studentFill((List<Student>) list, count, scanner);
                break;
            }
            case null, default -> System.out.println("Неизвестный тип данных, попробуйте еще раз");
        }

        return Collections.unmodifiableList(list);
    }

    private void busFill(final List<Bus> list, final int count, final Scanner scanner) {
        for (int i = 0; i < count; i++) {
            System.out.println("Введите номер автобуса (строка): ");
            String number = scanner.nextLine();

            System.out.println("Введите модель автобуса (строка): ");
            String model = scanner.nextLine();

            System.out.println("Введите пробег автобуса (целое число): ");
            int odometr = Integer.parseInt(scanner.nextLine());

            try {
                list.add(Bus.create(number, model, odometr, true));
            } catch (Exception e) {
                System.out.println("Ошибка при создании автобуса вручную, попробуйте еще раз: " + e.getMessage());
                i--;
            }
        }
    }

    private void userFill(List<User> list, int count, Scanner scanner) {
        for (int i = 0; i < count; i++) {
            System.out.println("Введите имя (строка): ");
            String name = scanner.nextLine();

            System.out.println("Введите адрес почты (строка): ");
            String email = scanner.nextLine();

            System.out.println("Введите пароль (строка): ");
            String password = scanner.nextLine();

            try {
                list.add(User.create(name, email, password, true));
            } catch (Exception e) {
                System.out.println("Ошибка при создании пользователя, попробуйте еще раз: " + e.getMessage());
                i--;
            }
        }
    }

    private void studentFill(List<Student> list, int count, Scanner scanner) {
        for (int i = 0; i < count; i++) {
            System.out.println("Введите номер гуппы (строка): ");
            String groupNumber = scanner.nextLine();

            System.out.println("Введите средний балл (число с плавающей точкой): ");
            double avg = Double.parseDouble(scanner.nextLine());

            System.out.println("Введите номер зачетки (целое число): ");
            int bookNumber = Integer.parseInt(scanner.nextLine());

            try {
                list.add(Student.create(groupNumber, bookNumber, avg, true));
            } catch (Exception e) {
                System.out.println("Ошибка при создании студента, попробуйте еще раз: " + e.getMessage());
                i--;
            }
        }
    }
}
