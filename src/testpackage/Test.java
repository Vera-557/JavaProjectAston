package testpackage;

import comparators.ObjectValueComparator;
import comparators.Sortable;
import entityclass.Bus;
import entityclass.EntityList;
import entityclass.EntityType;
import loader.*;
import view.StrategySelector;
import view.StrategyType;
import view.TypeSelector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception {
        System.out.println(Bus.gosNumberValidate("4567 AA-8"));

        // System.out.println(new Bus("AA-3 8675", "Ford", -1998));
        System.out.println(Bus.create("AA-3 8675", "Ford", 1998, false));

        List<Bus> busList = new ArrayList<>();
        Collections.addAll(busList, MakeEntityClass.getBusArray());

        Bus[] busArr = MakeEntityClass.getBusArray();

        System.out.println("Вывод первоначального листа");
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

        String sortStr = Bus.KeySort.gosNumber.toString();
        System.out.printf("Сортируем массив по полю %s, выводим на экран\n", sortStr);
        busArray.sort(sortStr);
        for (Bus bus : busArr) {
            System.out.println(bus.toString());
        }

        sortStr = Bus.KeySort.odometer.toString();
        System.out.printf("Сортируем массив по полю %s, выводим на экран\n", sortStr);
        busArray.sortEven(sortStr);
        for (Bus bus : busArr) {
            System.out.println(bus.toString());
        }
    }

    public static void uiTest(){
        while (true) {
            EntityType entityType = TypeSelector.entityTypeInput();
            if (entityType == null) {
                System.out.println("До скорых встреч! \uD83D\uDC8B");
                break;
            }

            StrategyType strategyType = StrategySelector.strategyTypeInput();
            if (strategyType == null) {
                System.out.println("До скорых встреч! \uD83D\uDC8B");
                break;
            }

            DataLoadStrategy<?> strategy;
            switch (strategyType) {
                case JSON -> strategy = new JsonDataLoader<>(entityType);
                case MANUAL -> strategy = new ManualDataLoader<>(entityType);
                case RANDOM -> strategy = new RandomDataLoader<>(entityType);
                default -> throw new IllegalStateException("Некорректная стратегия: " + strategyType);
            }

            DataLoaderContext<?> context = new DataLoaderContext<>(strategy);

            EntityList<?> data = context.processStrategy();
            for (Object obj : data.getArray()) {
                System.out.println(obj);
            }

            System.out.println("*****");
        }
    }
}
