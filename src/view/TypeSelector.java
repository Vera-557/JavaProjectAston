package view;

import entityclass.EntityType;

import java.util.Scanner;

public class TypeSelector {
    public static EntityType entityTypeInput() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("ВЫБЕРИТЕ ТИП ДАННЫХ, ВВЕДЯ СООТВЕТСТВУЮЩУЮ ЦИФРУ:" + "\n"
                    + "\t" + EntityType.BUS.getNumber() + ". " + EntityType.BUS.name().toLowerCase() + "\n"
                    + "\t" + EntityType.STUDENT.getNumber() + ". " + EntityType.STUDENT.name().toLowerCase() + "\n"
                    + "\t" + EntityType.USER.getNumber() + ". " + EntityType.USER.name().toLowerCase() + "\n"
                    + "\t" + Command.EXIT.getNumber() + ". " + Command.EXIT.name().toLowerCase() + Command.EXIT.getDescription());
            String input = scanner.nextLine().toUpperCase();

            if (input.substring(0, 1).equals(Command.EXIT.getNumber())) {
                break;
            }

            String number = input.substring(0, 1);
            for (EntityType type : EntityType.values()) {
                if (type.getNumber().equals(number)) {
                    return type;
                }
            }
            System.out.println("Некорректный ввод, попробуйте еще раз");
        }
        return null;
    }
}
