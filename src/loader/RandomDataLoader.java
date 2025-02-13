package loader;

import entityclass.*;
import comparators.InterfaceCompare;
import view.Command;

import java.util.*;

public class RandomDataLoader<T extends InterfaceCompare<T>> implements DataLoadStrategy<T> {
    private final EntityType type;
    private final Random random;

    public RandomDataLoader(final EntityType type) {
        this.type = type;
        random = new Random();
    }

    @Override
    public EntityList<T> loadData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество требуемых случайных объектов. Также доступны команды: " + "\n"
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
                return (EntityList<T>) new EntityList<>(busFill(count));
            }
            case USER -> {
                return (EntityList<T>) new EntityList<>(userFill(count));
            }
            case STUDENT -> {
                return (EntityList<T>) new EntityList<>(studentFill(count));
            }
            case null, default -> System.out.println("Неизвестный тип данных, попробуйте еще раз");
        }
        throw new IllegalArgumentException("Неизвестный тип данных, попробуйте еще раз");
    }

    private Bus[] busFill(int count) {
        Bus[] buses = new Bus[count];
        for (int i = 0; i < count; i++) {
            String busNumber = createRandomBusNumber(getRandomIntegerAsString(4), getRandomString(2), getRandomInteger(1, 7));
            String model = getRandomString(random.nextInt(10) + 1);
            int odometr = getRandomInteger(random.nextInt(5) + 1);
            try {
                buses[i] = Bus.create(busNumber, model, odometr, true);
            } catch (Exception e) {
                throw new RuntimeException("Ошибка при создании случайного автобуса, попробуйте еще раз: " + e.getMessage());
            }
        }
        return buses;
    }

    private User[] userFill(int count) {
        User[] users = new User[count];
        for (int i = 0; i < count; i++) {
            String name = getRandomString(5);
            String email = createEmail(getRandomString(5), getRandomString(4), getRandomString(2));
            String password = getRandomString(5) + getRandomInteger(5);

            try {
                users[i] = User.create(name, email, password, true);
            } catch (Exception e) {
                throw new RuntimeException("Ошибка при создании случайного юзера, попробуйте еще раз: " + e.getMessage());
            }
        }
        return users;
    }

    private Student[] studentFill(int count) {
        Student[] students = new Student[count];
        for (int i = 0; i < count; i++) {
            String groupNumber = getRandomString(2) + getRandomInteger(5);
            double averageScore = random.nextDouble() * 10;
            int studentBookNumber = getRandomInteger(5);

            try {
                students[i] = Student.create(groupNumber, studentBookNumber, averageScore, true);
            } catch (Exception e) {
                throw new RuntimeException("Ошибка при создании случайного студента, попробуйте еще раз: " + e.getMessage());
            }
        }
        return students;
    }

    private int getRandomInteger(final int length) {
        if (length < 1) {
            throw new IllegalArgumentException("Случайное число не может быть в длину меньше единицы");
        }

        int randomInteger = 0;

        for (int i = 0; i < length; i++) {
            randomInteger = randomInteger * 10 + random.nextInt(10);
        }

        return randomInteger;
    }

    private int getRandomInteger(final int length, final int maxValue) {
        if (length < 1 || maxValue < 0) {
            throw new IllegalArgumentException("Что-то случилось при генерации случайного числа с ограничением по величине");
        }

        if (length == 1 && maxValue < 8) {
            return random.nextInt(maxValue) + 1;
        }

        return getRandomInteger(length);
    }

    private String getRandomIntegerAsString(final int length) {
        return String.format("%0" + length + "d", getRandomInteger(length));
    }

    private String getRandomString(final int length) {
        if (length < 1) {
            throw new IllegalArgumentException("Cлучайная строка не может быть в длину короче одного символа");
        }
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            stringBuilder.append((char) ('A' + random.nextInt(26)));
        }

        return stringBuilder.toString();
    }

    private String createRandomBusNumber(final String numberFirstPart, final String numberLetters, final int numberLastPart) {
        return numberFirstPart +
                " " +
                numberLetters +
                "-" +
                numberLastPart;
    }

    private String createEmail(final String local, final String domain, final String tld) {
        return local + "@" + domain + "." + tld;
    }
}
