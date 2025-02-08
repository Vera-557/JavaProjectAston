import EntityClass.Bus;
import EntityClass.EntityList;
import comparators.ObjectValueComparator;
import comparators.Sortable;
import testpackage.MakeEntityClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    List<Bus> busList = new ArrayList<>();
    Collections.addAll(busList, MakeEntityClass.getBusArray());

    Bus[] busArr = MakeEntityClass.getBusArray();

    System.out.println("Вывод перовначального листа");
    for (Bus bus : busList) {
            System.out.println(bus.toString());
        }

        busList.sort(new ObjectValueComparator<>(Bus::getGosNumber).thenComparing(new ObjectValueComparator<>(Bus::getOdometer)));
        System.out.println("---Вывод листа после сортировки");
        for (Bus bus : busList) {
            System.out.println(bus.toString());
        }

        System.out.println("======= Работа с массивом");
        Sortable<Bus> busArray = new EntityList<>(busArr);

        System.out.println("выводим массив на экран");
        for (Bus bus : busArr) {
            System.out.println(bus.toString());
        }

        String sortStr = Bus.SortKeys.GOSNUMBER;
        System.out.printf("Сортируем массив по полю %S, выводим на экран\n", sortStr);
        busArray.sort(sortStr);
        for (Bus bus : busArr) {
            System.out.println(bus.toString());
        }
    }

}
