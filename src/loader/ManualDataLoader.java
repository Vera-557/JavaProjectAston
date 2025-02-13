package loader;

import entityclass.*;
import comparators.InterfaceCompare;
import view.Command;

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
    public EntityList<T> loadData() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите количество элементов. Также доступны команды: " + "\n"
                + "\t" + Command.ABORT.getNumber() + ". " + Command.ABORT.name().toLowerCase() + "\n"
                + "\t" + Command.EXIT.getNumber() + ". " + Command.EXIT.name().toLowerCase() + Command.EXIT.getDescription());
        String filePath = scanner.nextLine();

        if (UtilLoader.isAbort(filePath)) {
            return null;
        }
        if (UtilLoader.isExit(filePath)) {
            System.exit(0);
        }
        int count = -1;

        try {
            count = Integer.parseInt(filePath);
        } catch (NumberFormatException e) {
            System.out.println("Некорректное количество элементов, повторите ввод.");
            return null;
        }

        switch (type) {
            case BUS -> {
                return (EntityList<T>) new EntityList<>(busFill(count, scanner));
            }
            case USER -> {
                return (EntityList<T>) new EntityList<>(userFill(count, scanner));
            }
            case STUDENT -> {
                return (EntityList<T>) new EntityList<>(studentFill(count, scanner));
            }
            case null, default -> System.out.println("Неизвестный тип данных, попробуйте еще раз");
        }
        throw new IllegalArgumentException("Неизвестный тип данных, попробуйте еще раз");
    }

    private Bus[] busFill(final int count, final Scanner scanner) {
        Bus[] buses = new Bus[count];
        for (int i = 0; i < count; i++) {
            System.out.println("Введите номер автобуса (строка): ");
            String number = scanner.nextLine();

            System.out.println("Введите модель автобуса (строка): ");
            String model = scanner.nextLine();

            System.out.println("Введите пробег автобуса (целое число): ");
            int odometr = Integer.parseInt(scanner.nextLine());

            try {
                buses[i] = (Bus.create(number, model, odometr, true));
            } catch (Exception e) {
                System.out.println("Ошибка при создании автобуса вручную, попробуйте еще раз: " + e.getMessage());
                i--;
            }
        }
        return buses;
    }

    private User[] userFill(int count, Scanner scanner) {
        User[] users = new User[count];
        for (int i = 0; i < count; i++) {
            System.out.println("Введите имя (строка): ");
            String name = scanner.nextLine();

            System.out.println("Введите адрес почты (строка): ");
            String email = scanner.nextLine();

            System.out.println("Введите пароль (строка): ");
            String password = scanner.nextLine();

            try {
                users[i] = User.create(name, email, password, true);
            } catch (Exception e) {
                System.out.println("Ошибка при создании пользователя, попробуйте еще раз: " + e.getMessage());
                i--;
            }
        }
        return users;
    }

    private Student[] studentFill(int count, Scanner scanner) {
        Student[] students = new Student[count];
        for (int i = 0; i < count; i++) {
            System.out.println("Введите номер гуппы (строка): ");
            String groupNumber = scanner.nextLine();

            System.out.println("Введите средний балл (число с плавающей точкой): ");
            double avg = Double.parseDouble(scanner.nextLine());

            System.out.println("Введите номер зачетки (целое число): ");
            int bookNumber = Integer.parseInt(scanner.nextLine());

            try {
                students[i] = Student.create(groupNumber, bookNumber, avg, true);
            } catch (Exception e) {
                System.out.println("Ошибка при создании студента, попробуйте еще раз: " + e.getMessage());
                i--;
            }
        }
        return students;
    }
}
