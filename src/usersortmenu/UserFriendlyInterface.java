package usersortmenu;

import java.util.Scanner;

/**
 * Вспомогательный класс для пользовтаельского интерфейса
 * @author Виктор Карпов
 */
public class UserFriendlyInterface {


    /**
     * Возвращает цифру, соответствующую пункту меню.
     * @param menuStringArr
     * @return
     */
    public static int writeMenuGetAnswer(String[] menuStringArr) {
        while (true) {
            for (String menuStr : menuStringArr) {
                System.out.println(menuStr);
            }
            Scanner in = new Scanner(System.in);
            try {
                return in.nextInt();
            } catch (Exception e) {
                System.out.println(MenuSortDescription.NOTCORRECTANSWER);
            }
        }
    }

}
