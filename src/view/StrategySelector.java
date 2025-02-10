package view;
import java.util.Scanner;

public class StrategySelector {
    public static StrategyType strategyTypeInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите источник данных: Доступные источники:" + "\n" + StrategyType.JSON.name() + "\n" + StrategyType.MANUAL.name() + "\n" + StrategyType.RANDOM.name());

        try {
            StrategyType type = StrategyType.valueOf(scanner.nextLine().toUpperCase());

            switch (type) {
                case JSON -> {
                    return StrategyType.JSON;
                }
                case MANUAL -> {
                    return StrategyType.MANUAL;
                }
                case RANDOM -> {
                    return StrategyType.RANDOM;
                }
                default ->
                    throw new IllegalArgumentException("Что-то пошло не так при вводе данных, попробуйте еще раз");
            }

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Неправильно введены данные, попробуйте еще раз: " + e.getMessage());
        }
    }
}
