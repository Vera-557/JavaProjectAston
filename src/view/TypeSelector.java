package view;

import entityclass.EntityType;

import java.util.Scanner;

public class TypeSelector {
    public static EntityType entityTypeInput() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выбрать тип данных для обработки. Доступные данные:" + "\n" + EntityType.BUS.name() + "\n" + EntityType.STUDENT.name() + "\n" + EntityType.USER.name() + "\n" + "Команда для выхода: " + Command.EXIT);
            String input = scanner.nextLine().toUpperCase();

            if (input.equals(Command.EXIT.name())) {
                return null;
            }

            try {
                return EntityType.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: неправильный ввод. Попробуйте еще раз. " + e.getMessage());
            }
        }
    }
}
