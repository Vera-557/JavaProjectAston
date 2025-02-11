package loader;

import com.fasterxml.jackson.databind.ObjectMapper;
import entityclass.Bus;
import entityclass.Student;
import entityclass.User;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class JsonDataLoader<T> implements DataLoadStrategy<T> {
    private final ObjectMapper objectMapper;
    private final Class<T> typeClass;

    public JsonDataLoader(final Class<T> typeClass) {
        objectMapper = new ObjectMapper();
        this.typeClass = typeClass;
    }

    //класс отвечает за загрузку json-файла
    @Override
    public List<T> loadData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь к json-файлу: ");
        String filePath = scanner.nextLine();
        //TODO заменить List.class на Entity.class
        try {
            List<T> list = objectMapper.readValue(new File(filePath), objectMapper.getTypeFactory().constructCollectionType(List.class, typeClass)); //здесь происходит чтение пути файла и наполнение массива List данными из файла

            validateList(list);

            return list;
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при чтении JSON: " + e.getMessage());
        }
    }

    private void validateList(final List<T> list) {
        for (Object obj : list) {
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
