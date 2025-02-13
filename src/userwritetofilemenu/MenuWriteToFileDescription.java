package userwritetofilemenu;

/**
 * Тестовые константы меню записи в файл
 * @author Виктор Карпов
 */
public class MenuWriteToFileDescription {

    public final static String WELCOMETITLE = "СОХРАНЕНИЕ МАССИВА В ФАЙЛ. ";
    public final static String PATHFORWRITE = "Введите путь для сохранения файла: ";
    public final static String FILESAVEANSWER = "Файл успешно сохранен.";
    public final static String NULLARRAY = "Нулевой массив. Нечего сохранять.";

    public final static String[] menuWriteToFile = (new String[]{
            WELCOMETITLE,
            "\t0. На уровень вверх",
            "\tНаберите \"999\". Для выхода из программы",
            PATHFORWRITE
    });


}
