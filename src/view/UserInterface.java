package view;

import entityclass.EntityList;
import entityclass.EntityType;
import loader.*;
import usersortmenu.MenuSort;
import userwritetofilemenu.MenuWriteToFile;

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

                        MenuWriteToFile menuWriteToFile = new MenuWriteToFile(data);
                        menuWriteToFile.showWriteToFileMenu();
                    }
                }
            }
        }
    }
}
