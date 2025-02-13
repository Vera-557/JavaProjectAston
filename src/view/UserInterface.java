package view;

import entityclass.*;
import loader.*;
import search.BinarySearch;
import usersortmenu.MenuSort;
import userwritetofilemenu.MenuWriteToFile;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UserInterface {
    public static void run() {
        while (true) {
            EntityType entityType = TypeSelector.entityTypeInput();
            if (entityType == null) {
                System.out.println("До скорых встреч! \uD83D\uDC8B");
                break;
            }
            while (true) {
                StrategyType strategyType = StrategySelector.strategyTypeInput();
                if (strategyType == null) {
                    System.out.println("До скорых встреч! \uD83D\uDC8B");
                    System.exit(0);
                }
                if (strategyType == StrategyType.ABORT) {
                    System.out.println("Снова выбирайте тип данных");
                    break;
                } else {
                    while (true) {
                        DataLoadStrategy<?> strategy;
                        switch (strategyType) {
                            case JSON -> strategy = new JsonDataLoader<>(entityType);
                            case MANUAL -> strategy = new ManualDataLoader<>(entityType);
                            case RANDOM -> strategy = new RandomDataLoader<>(entityType);
                            default -> throw new IllegalStateException("Некорректная стратегия: " + strategyType);
                        }

                        DataLoaderContext<?> context = new DataLoaderContext<>(strategy);

                        EntityList<?> data = context.processStrategy();
                        if (data == null) {
                            break;
                        }

                        MenuSort menuSort = new MenuSort(data);
                        menuSort.showSortMenu();

                        searchOrSave(data, entityType);
                    }
                }
            }
        }
    }

    private static void searchOrSave(final EntityList<?> data, final EntityType entityType) {

        System.out.println("Можем сохранить в файл или поискать в массиве по вашим параметрам. \n1 - сохранение в файл. \n2 - поиск по массиву.");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        switch (input) {
            case 1 -> {
                MenuWriteToFile menuWriteToFile = new MenuWriteToFile(data);
                menuWriteToFile.showWriteToFileMenu();
            }
            case 2 -> {
                detailsAboutSearch(data, entityType);
            }
            default -> throw new IllegalArgumentException("Неправильный ввод данных");
        }

    }

    private static void detailsAboutSearch(final EntityList<?> data, final EntityType entityType) {
        System.out.println("Напишите, какое поле мы ищем. Доступные поля: ");

        Class<?> className = entityType.getTypeClass();
        Field[] fields = className.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите поле (а лучше скопируйте из предложенных выше): ");
        String searchField = scanner.nextLine();

        System.out.println("Введите значение для поиска: ");
        String searchValue = scanner.nextLine();

        Object[] array = data.getArray();

        if (array.length > 0) {
            if (array[0] instanceof Bus) {
                Bus[] buses = (Bus[]) array;
                Bus newBus = buses[0];
                int index = BinarySearch.binarySearch(buses, searchValue, searchField, newBus);
                printSearchResult(index, buses);
            } else if (array[0] instanceof Student) {
                Student[] students = (Student[]) array;
                try {
                    Student newStudent = students[0];
                    int index = BinarySearch.binarySearch(students, searchValue, searchField, newStudent);
                    printSearchResult(index, students);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        } else {
            throw new RuntimeException("Массив для поиска почему-то пустой");
        }
    }

    private static <T> void printSearchResult(int index, T[] array) {
        if (index >= 0) {
            System.out.println("КАЖИСЬ НАШЕЛ: " + array[index]);
        } else {
            System.out.println("Не найдено");
        }
    }
}
