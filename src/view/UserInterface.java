package view;

import entityclass.EntityList;
import entityclass.EntityType;
import loader.*;
import usersortmenu.MenuSort;

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
                    break;
                }
                if (strategyType == StrategyType.ABORT) {
                    System.out.println("Снова выбирайте тип данных");
                    break;
                } else {
                    DataLoadStrategy<?> strategy;
                    switch (strategyType) {
                        case JSON -> strategy = new JsonDataLoader<>(entityType);
                        case MANUAL -> strategy = new ManualDataLoader<>(entityType);
                        case RANDOM -> strategy = new RandomDataLoader<>(entityType);
                        default -> throw new IllegalStateException("Некорректная стратегия: " + strategyType);
                    }

                    DataLoaderContext<?> context = new DataLoaderContext<>(strategy);

                    EntityList<?> data = context.processStrategy();

                    MenuSort menuSort = new MenuSort(data);
                    menuSort.showSortMenu();
                }
            }
        }
        return;
    }
}
