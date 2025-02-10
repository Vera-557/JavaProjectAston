package loader;

import entityclass.Bus;
import entityclass.Student;
import entityclass.EntityType;
import entityclass.User;
import comparators.InterfaceCompare;

import java.util.*;

public class RandomDataLoader<T extends InterfaceCompare<T>> implements DataLoadStrategy<T> {
    private final EntityType type;
    private final Random random;

    public RandomDataLoader(final EntityType type) {
        this.type = type;
        random = new Random();
    }

    @Override
    public List<T> loadData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество требуемых случайных объектов: ");
        int count = Integer.parseInt(scanner.nextLine());
        //TODO заменить list на EntityList
        List<T> list = new ArrayList<>(count);
        switch (type) {
            case BUS ->
                busFill((List<Bus>) list, count);

            case USER ->
                userFill((List<User>) list, count);

            case STUDENT ->
                studentFill((List<Student>) list, count);

            case null, default -> System.out.println("Неизвестный тип данных, попробуйте еще раз");
        }

        return Collections.unmodifiableList(list);
    }

    private void busFill(List<Bus> list, int count) {
        for (int i = 0; i < count; i++) {
            String busNumber = createRandomBusNumber(getRandomIntegerAsString(4), getRandomString(2), getRandomInteger(1, 7));
            String model = getRandomString(random.nextInt(10) + 1);
            int odometr = getRandomInteger(random.nextInt(5) + 1);
            try {
                list.add(Bus.create(busNumber, model, odometr, true));
            } catch (Exception e) {
                throw new RuntimeException("Ошибка при создании случайного автобуса, попробуйте еще раз: " + e.getMessage());
            }

        }
    }

    private void userFill(List<User> list, int count) {
        for (int i = 0; i < count; i++) {
            String name = getRandomString(5);
            String email = createEmail(getRandomString(5), getRandomString(4), getRandomString(2));
            String password = getRandomString(5) + getRandomInteger(5);

            try {
                list.add(User.create(name, email, password, true));
            } catch (Exception e) {
                throw new RuntimeException("Ошибка при создании случайного юзера, попробуйте еще раз: " + e.getMessage());
            }
        }
    }

    private void studentFill(List<Student> list, int count) {
        for (int i = 0; i < count; i++) {
            String groupNumber = getRandomString(2) + getRandomInteger(5);
            double averageScore = random.nextDouble() * 10;
            int studentBookNumber = getRandomInteger(5);

            try {
                list.add(Student.create(groupNumber, studentBookNumber, averageScore, true));
            } catch (Exception e) {
                throw new RuntimeException("Ошибка при создании случайного студента, попробуйте еще раз: " + e.getMessage());
            }
        }
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
