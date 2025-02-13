package view;

import java.util.Scanner;

public class StrategySelector {
    public static StrategyType strategyTypeInput() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите источник данных: Доступные источники:" + "\n"
                    + StrategyType.JSON.name() + "\n"
                    + StrategyType.MANUAL.name() + "\n"
                    + StrategyType.RANDOM.name() + "\n"
                    + "Команды: " + Command.EXIT + " - для выхода; " + Command.ABORT + " - для возврата назад.");
            String input = scanner.nextLine().toUpperCase();

            if (input.equals(Command.EXIT.name())) {
                return null;
            }

            try {
                return StrategyType.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: неправильный ввод. Попробуйте еще раз. " + e.getMessage());
            }
        }
    }
}
