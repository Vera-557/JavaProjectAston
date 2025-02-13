package loader;

import com.fasterxml.jackson.databind.ObjectMapper;
import comparators.InterfaceCompare;
import entityclass.*;
import view.Command;
import view.StrategyType;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class JsonDataLoader<T extends InterfaceCompare> implements DataLoadStrategy<T> {
    private final ObjectMapper objectMapper;
    private final EntityType type;

    public JsonDataLoader(final EntityType type) {
        objectMapper = new ObjectMapper();
        this.type = type;
    }

    //класс отвечает за загрузку json-файла
    @Override
    public EntityList<T> loadData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь к json-файлу. Также доступны команды: " + "\n"
                + "\t" + Command.ABORT.getNumber() + ". " + Command.ABORT.name().toLowerCase() + "\n"
                + "\t" + Command.EXIT.getNumber() + ". " + Command.EXIT.name().toLowerCase() + Command.EXIT.getDescription());
        String filePath = scanner.nextLine();
        if (UtilLoader.isAbort(filePath)) {
            return null;
        }
        if (UtilLoader.isExit(filePath)) {
            System.exit(0);
        }
        try {
            switch (type) {
                case BUS -> {
                    Bus[] buses = objectMapper.readValue(new File(filePath), Bus[].class);
                    EntityList<T> entityList = (EntityList<T>) new EntityList<>(buses);
                    validateList(entityList);
                    return entityList;
                }
                case STUDENT -> {
                    Student[] students = objectMapper.readValue(new File(filePath), Student[].class);
                    EntityList<T> entityList = (EntityList<T>) new EntityList<>(students);
                    validateList(entityList);
                    return entityList;
                }
                case USER -> {
                    User[] users = objectMapper.readValue(new File(filePath), User[].class);
                    EntityList<T> entityList = (EntityList<T>) new EntityList<>(users);
                    validateList(entityList);
                    return entityList;
                }
                case null, default -> {
                    throw new IllegalArgumentException("Неизвестный тип данных");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при чтении JSON: " + e.getMessage());
        }
    }

    private void validateList(final EntityList<T> list) {
        for (Object obj : list.getArray()) {
            if (!isValid(obj)) {
                throw new IllegalArgumentException("Обнаружены невалидные данные в JSON-файле");
            }
        }
    }

    private boolean isValid(final Object obj) {
        if (obj instanceof Bus bus) {
            return Bus.gosNumberValidate(bus.getGosNumber()) && Bus.modelValidate(bus.getModel()) && Bus.odometerValidate(bus.getOdometer());
        } else {
            if (obj instanceof Student student) {
                return Student.groupNumberValidate(student.getGroupNumber()) && Student.studentBookNumberValidate(student.getStudentBookNumber()) && Student.averageScoreValidate(student.getAverageScore());
            } else {
                if (obj instanceof User user) {
                    return User.emailValidate(user.getEmail()) && User.nameValidate(user.getName()) && User.passwordValidate(user.getPassword());
                }
            }
        }
        return true;
    }
}
