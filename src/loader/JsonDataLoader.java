package loader;

import com.fasterxml.jackson.databind.ObjectMapper;

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

        try {
            //TODO заменить List.class на Entity.class
            //TODO подумать как прикрутить валидацию данных из классов данных
            return objectMapper.readValue(new File(filePath), objectMapper.getTypeFactory().constructCollectionType(List.class, typeClass)); //здесь происходит чтение пути файла и наполнение массива List данными из файла
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при чтении JSON: " + e.getMessage());
        }
    }
}
