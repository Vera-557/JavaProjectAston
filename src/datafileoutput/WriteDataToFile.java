package datafileoutput;

/*
Доп. доп. задание: Необходимо реализовать функционал для записи отсортированных
коллекций/найденных значений в файл в режиме добавления данных
 */

import EntityClass.Bus;
import testpackage.MakeEntityClass;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Утилитный класс для записи данных в файл
 * @author Виктор Карпов
 */
public class WriteDataToFile {

    @Deprecated
    /**
     * Для тестов
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Bus[] busArr = MakeEntityClass.getBusArray();
        System.out.println(WriteDataToFile.writeArrayToFile(busArr, "e:\\test.txt", true));
    }

    /**
     * @param arr Массив для записи. В файл записываются объекты массива, после преобразования в строку ( через toSting)
     * @param path путь для записи файла
     * @param append true - дописывать данные в конец файла, false - перезаписать файл
     * @return Запись данных прошла успешно?
     */
    public static boolean writeArrayToFile(Object[] arr, String path, boolean append) {
        try(FileWriter writer = new FileWriter(path, false))
        {
            for (int i = 0; i < arr.length; i++) {
                writer.write(arr[i].toString());
                writer.write("\n");
            }
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }
}
