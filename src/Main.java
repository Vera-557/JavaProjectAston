import comparators.InterfaceCompare;
import entityclass.Bus;
import entityclass.EntityList;
import comparators.ObjectValueComparator;
import comparators.Sortable;
import entityclass.EntityType;
import loader.DataLoadStrategy;
import loader.*;
import testpackage.MakeEntityClass;
import view.StrategySelector;
import view.StrategyType;
import view.TypeSelector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {


//        System.out.println(Bus.gosNumberValidate("4567 AA-8"));
//
//        // System.out.println(new Bus("AA-3 8675", "Ford", -1998));
//        System.out.println(Bus.create("AA-3 8675", "Ford", 1998, false));
//
//        List<Bus> busList = new ArrayList<>();
//        Collections.addAll(busList, MakeEntityClass.getBusArray());
//
//        Bus[] busArr = MakeEntityClass.getBusArray();
//
//        System.out.println("Вывод первоначального листа");
//        for (Bus bus : busList) {
//            System.out.println(bus.toString());
//        }
//
//        busList.sort(new ObjectValueComparator<>(Bus::getGosNumber).thenComparing(new ObjectValueComparator<>(Bus::getOdometer)));
//        System.out.println("---Вывод листа после сортировки");
//        for (Bus bus : busList) {
//            System.out.println(bus.toString());
//        }
//
//        System.out.println("======= Работа с массивом");
//        Sortable<Bus> busArray = new EntityList<>(busArr);
//
//        System.out.println("выводим массив на экран");
//        for (Bus bus : busArr) {
//            System.out.println(bus.toString());
//        }
//
//        String sortStr = Bus.KeySort.gosNumber.toString();
//        System.out.printf("Сортируем массив по полю %s, выводим на экран\n", sortStr);
//        busArray.sort(sortStr);
//        for (Bus bus : busArr) {
//            System.out.println(bus.toString());
//        }
//
//        sortStr = Bus.KeySort.odometer.toString();
//        System.out.printf("Сортируем массив по полю %s, выводим на экран\n", sortStr);
//        busArray.sortEven(sortStr);
//        for (Bus bus : busArr) {
//            System.out.println(bus.toString());
//        }

        //старт ввода данных в консоль
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

            Class<? extends InterfaceCompare<?>> entityClass = entityType.getTypeClass();

            DataLoadStrategy<?> strategy;
            switch (strategyType) {
                case JSON -> strategy = new JsonDataLoader<>(entityClass);
                case MANUAL -> strategy = new ManualDataLoader<>(entityType);
                case RANDOM -> strategy = new RandomDataLoader<>(entityType);
                default -> throw new IllegalStateException("Некорректная стратегия: " + strategyType);
            }

            DataLoaderContext<?> context = new DataLoaderContext<>(strategy);

            List<?> data = context.processStrategy();
            data.forEach(System.out::println);
        }
    }
}