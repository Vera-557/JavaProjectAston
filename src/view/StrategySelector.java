package view;

import java.util.Scanner;

public class StrategySelector {
    public static StrategyType strategyTypeInput() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("ВВЕДИТЕ ИСТОЧНИК ДАННЫХ, ВВЕДЯ СООТВЕТСТВУЮЩУЮ ЦИФРУ:" + "\n"
                    + StrategyType.JSON.getNumber() + ". " + StrategyType.JSON.name().toLowerCase() + "\n"
                    + StrategyType.MANUAL.getNumber() + ". " + StrategyType.MANUAL.name().toLowerCase() + "\n"
                    + StrategyType.RANDOM.getNumber() + ". " + StrategyType.RANDOM.name().toLowerCase() + "\n"
                    + StrategyType.ABORT.getNumber() + ". " + StrategyType.ABORT.name().toLowerCase() + "\n"
                    + Command.EXIT.getNumber() + ". " + Command.EXIT.name().toLowerCase() + Command.EXIT.getDescription());
            String input = scanner.nextLine().toUpperCase();

            if (input.substring(0, 1).equals(Command.EXIT.getNumber())) {
                break;
            }

            if (input.length() > 1) {
                if (input.substring(0, 3).equals(Command.ABORT.getNumber())) {
                    return StrategyType.ABORT;
                }
            }

            String number = input.substring(0, 1);
            for (StrategyType type : StrategyType.values()) {
                if (type.getNumber().equals(number)) {
                    return type;
                }
            }
            System.out.println("Некорректный ввод, попробуйте еще раз");
        }
        return null;
    }
}
