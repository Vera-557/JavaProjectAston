import entityclass.Bus;
import entityclass.Student;
import entityclass.User;
import EntityClass.EntityList;

import search.BinarySearch;
import search.ValueExtractor;
import testpackage.MakeEntityClass;
import comparators.ObjectValueComparator;
import comparators.Sortable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        // Работа с автобусами
        System.out.println(Bus.gosNumberValidate("4567 AA-8"));
        System.out.println(Bus.create("AA-3 8675", "Ford", 1998, false));

        List<Bus> busList = new ArrayList<>();
        Collections.addAll(busList, MakeEntityClass.getBusArray());

        Bus[] busArr = MakeEntityClass.getBusArray();

        System.out.println("Вывод первоначального листа автобусов");
        for (Bus bus : busList) {
            System.out.println(bus.toString());
        }

        busList.sort(new ObjectValueComparator<>(Bus::getGosNumber).thenComparing(new ObjectValueComparator<>(Bus::getOdometer)));
        System.out.println("---Вывод листа автобусов после сортировки");
        for (Bus bus : busList) {
            System.out.println(bus.toString());
        }

        System.out.println("======= Работа с массивом автобусов");
        Sortable<Bus> busArray = new EntityList<>(busArr);

        System.out.println("Выводим массив автобусов на экран");
        for (Bus bus : busArr) {
            System.out.println(bus.toString());
        }

        String sortStr = Bus.KeySort.gosNumber.toString();
        System.out.printf("Сортируем массив автобусов по полю %s, выводим на экран\n", sortStr);
        busArray.sort(sortStr);
        for (Bus bus : busArr) {
            System.out.println(bus.toString());
        }

        // Бинарный поиск автобуса по номеру
        String busSearchKey = "1748 AA-3";
        int busIndex = BinarySearch.binarySearch(busArr, busSearchKey, "gosNumber", new ValueExtractor<Bus, Object>() {
            @Override
            public Object extractValue(Bus bus, String field) {
                return bus.extractValue(bus, field); // Используем реализацию из класса Bus
            }
        });

        if (busIndex >= 0) {
            System.out.println("Найденный автобус: " + busArr[busIndex]);
        } else {
            System.out.println("Автобус не найден.");
        }

        sortStr = Bus.KeySort.odometer.toString();
        System.out.printf("Сортируем массив автобусов по полю %s, выводим на экран\n", sortStr);
        busArray.sortEven(sortStr);
        for (Bus bus : busArr) {
            System.out.println(bus.toString());
        }

        // Работа со студентами
        Student[] students = MakeEntityClass.getStudentArray();
        EntityList<Student> studentList = new EntityList<>(students);
        studentList.sort("studentBookNumber");

        // Бинарный поиск студента по номеру зачетной книжки
        int studentSearchKey = 134;
        int studentIndex = BinarySearch.binarySearch(students, studentSearchKey, "studentBookNumber", new ValueExtractor<Student, Object>() {
            @Override
            public Object extractValue(Student student, String field) {
                return student.extractValue(student, field); // Используем реализацию из класса Student
            }
        });

        if (studentIndex >= 0) {
            System.out.println("Найденный студент: " + students[studentIndex]);
        } else {
            System.out.println("Студент не найден.");
        }

        // Работа с пользователями
        User[] users = MakeEntityClass.getUserArray();
        EntityList<User> userList = new EntityList<>(users);
        userList.sort("email");

        // Бинарный поиск пользователя по email
        String userSearchKey = "fermi@mail.ru";
        int userIndex = BinarySearch.binarySearch(users, userSearchKey, "email", new ValueExtractor<User, Object>() {
            @Override
            public Object extractValue(User user, String field) {
                return user.extractValue(user, field); // Используем реализацию из класса User
            }
        });

        if (userIndex >= 0) {
            System.out.println("Найденный пользователь: " + users[userIndex]);
        } else {
            System.out.println("Пользователь не найден.");
        }
    }
}
