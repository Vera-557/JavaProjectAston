package view;

import entityclass.EntityType;

import java.util.Scanner;

public class TypeSelector {
    public static EntityType entityTypeInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выбрать тип данных для обработки. Доступные данные:" + "\n" + EntityType.BUS.name() + "\n" + EntityType.STUDENT.name() + "\n" + EntityType.USER.name());

        try {
            EntityType inputType = EntityType.valueOf(scanner.nextLine().toUpperCase());

            switch (inputType) {
                case BUS -> {
                    return EntityType.BUS;
                }
                case USER -> {
                    return EntityType.USER;
                }
                case STUDENT -> {
                    return EntityType.STUDENT;
                }
                default -> {
                    throw new IllegalArgumentException("Что-то пошло не так при вводе данных, попробуйте еще раз");
                }
            }

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Неправильно введены данные, попробуйте еще раз: " + e.getMessage());
        }
    }
}
