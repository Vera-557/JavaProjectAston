package testpackage;

import EntityClass.Bus;
import EntityClass.Student;
import EntityClass.User;

/**
 * Класс для тестов. Возвращает массив объектов.
 */
public class MakeEntityClass {
    public static Bus[] getBusArray() throws Exception {
        Bus bus1 = Bus.create("1748 AA-3", "Ford", 345098, false);
        Bus bus2 = Bus.create("1748 AA-2", "Nissan", 115000, false);
        Bus bus3 = Bus.create("5554 AA-2", "GAZ", 15790, false);
        Bus bus4 = Bus.create("1112 AA-1", "Ford", 11500, false);
        Bus bus5 = Bus.create("5555 AA-7", "Volvo", 10, false);
        Bus bus6 = Bus.create("5555 AA-7", "Volvo", 1, false);
        Bus bus7 = Bus.create("5555 AA-7", "Volvo", 3, false);
        Bus bus8 = Bus.create("5555 AA-7", "Volvo", 5, false);
        Bus bus9 = Bus.create("5555 AA-7", "Volvo", 7, false);
        Bus bus10 = Bus.create("5555 AA-7", "Volvo", 9, false);


        return new Bus[]{bus1, bus2, bus3, bus4, bus5, bus6, bus7, bus8, bus9, bus10};
    }

    public static User[] getUserArray() {
        User user1 = User.create("Amper", "amper@gmail.com", "Asd");
        User user2 = User.create("Fermi", "fermi@mail.ru", "1111");
        User user3 = User.create("Nosov", "nos@ya.ru", "I'mWriter");
        User user4 = User.create("Kleopatra", "kleo@gmail.com", "nothing");
        User user5 = User.create("Rafaello", "rafic@gmail.com", "9845");
        return new User[]{user1, user2, user3, user4, user5};
    }

    public static Student[] getStudentArray() throws Exception {
        Student student1 = Student.create("ВТ-11", 134, 0,false);
        Student student2 = Student.create("ТЭРА-31", 34134, 4.5, false);
        Student student3 = Student.create("Э-22", 254, 3.7, false);
        Student student4 = Student.create("вТ-31", 1234, 4.1, false);
        Student student5 = Student.create("Э-11", 23134, 0, false);
        return new Student[]{student1, student2, student3, student4, student5};
    }


}
