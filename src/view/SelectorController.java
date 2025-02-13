package view;

import entityclass.EntityList;
import entityclass.EntityType;
import loader.*;

public class SelectorController {
    public static EntityList<?> run() {
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
            if (strategyType == StrategyType.ABORT) {
                System.out.println("Снова выбирайте тип данных");
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
                for (Object obj : data.getArray()) {
                    System.out.println(obj);
                }

                System.out.println("*****");
                return data;
            }
        }
        throw new RuntimeException("Не удалось создать массив данных");
    }
}
