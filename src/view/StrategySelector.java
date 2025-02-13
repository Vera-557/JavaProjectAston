package view;

import java.util.Scanner;

public class StrategySelector {
    public static StrategyType strategyTypeInput() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("ВВЕДИТЕ ИСТОЧНИК ДАННЫХ, ВВЕДЯ СООТВЕТСТВУЮЩУЮ ЦИФРУ:" + "\n"
                    + "\t" + StrategyType.JSON.getNumber() + ". " + StrategyType.JSON.name().toLowerCase() + "\n"
                    + "\t" + StrategyType.MANUAL.getNumber() + ". " + StrategyType.MANUAL.name().toLowerCase() + "\n"
                    + "\t" + StrategyType.RANDOM.getNumber() + ". " + StrategyType.RANDOM.name().toLowerCase() + "\n"
                    + "\t" + StrategyType.ABORT.getNumber() + ". " + StrategyType.ABORT.name().toLowerCase() + "\n"
                    + "\t" + Command.EXIT.getNumber() + ". " + Command.EXIT.name().toLowerCase() + Command.EXIT.getDescription());
            String input = scanner.nextLine().toUpperCase();

            if (input.substring(0, 1).equals(Command.ABORT.getNumber())) {
                return StrategyType.ABORT;
            }

            if (input.length() > 2) {
                if (input.substring(0, 3).equals(Command.EXIT.getNumber())) {
                    return null;

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
    }
}
