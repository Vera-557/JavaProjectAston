package view;

import entityclass.EntityType;

import java.util.Scanner;

public class TypeSelector {
    public static EntityType entityTypeInput() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("ВЫБЕРИТЕ ТИП ДАННЫХ, ВВЕДЯ СООТВЕТСТВУЮЩУЮ ЦИФРУ:" + "\n"
                    + EntityType.BUS.getNumber() + ". " + EntityType.BUS.name() + "\n"
                    + EntityType.STUDENT.getNumber() + ". " + EntityType.STUDENT.name() + "\n"
                    + EntityType.USER.getNumber() + ". " + EntityType.USER.name() + "\n"
                    + "Команда для выхода: " + Command.EXIT);
            String input = scanner.nextLine().toUpperCase();

            if (input.equals(Command.EXIT.name())) {
                return null;
            }

            try {
                String number = input.substring(0, 1);
                for (EntityType type : EntityType.values()) {
                    if (type.getNumber().equals(number)) {
                        return type;
                    }
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: неправильный ввод. Попробуйте еще раз. " + e.getMessage());
            }
        }
    }
}
