package testpackage;

import EntityClass.Bus;
import EntityClass.Student;
import EntityClass.User;

/**
 * Класс для тестов. Возвращает массив объектов.
 */
public class MakeEntityClass {
    public static Bus[] getBusArray() throws Exception {
        Bus bus1 = Bus.create("1748 AA-3", "Ford", 345098);
        Bus bus2 = Bus.create("1748 AA-2", "Nissan", 115000);
        Bus bus3 = Bus.create("5554 AA-2", "GAZ", 15790);
        Bus bus4 = Bus.create("1112 AA-1", "Ford", 11500);
        Bus bus5 = Bus.create("5555 AA-7", "Volvo", 0);
        return new Bus[]{bus1, bus2, bus3, bus4, bus5};
    }

    public static User[] getUserArray() {
        User user1 = User.create("Amper", "amper@gmail.com", "Asd");
        User user2 = User.create("Fermi", "fermi@mail.ru", "1111");
        User user3 = User.create("Nosov", "nos@ya.ru", "I'mWriter");
        User user4 = User.create("Kleopatra", "kleo@gmail.com", "nothing");
        User user5 = User.create("Rafaello", "rafic@gmail.com", "9845");
        return new User[]{user1, user2, user3, user4, user5};
    }

    public static Student[] getStudentArray() {
        Student student1 = Student.create("ВТ-11", 134, 0);
        Student student2 = Student.create("ТЭРА-31", 34134, 4.5);
        Student student3 = Student.create("Э-22", 254, 3.7);
        Student student4 = Student.create("вТ-31", 1234, 4.1);
        Student student5 = Student.create("Э-11", 23134, 0);
        return new Student[]{student1, student2, student3, student4, student5};
    }


}
