package usersortmenu;

import entityclass.Bus;
import entityclass.EntityList;
import entityclass.Student;
import entityclass.User;
import userwritetofilemenu.MenuWriteToFileDescription;


/**
 * Пользовательское меню связанное с сортировкой данных
 * @author Виктор Карпов
 */
public class MenuSort {

    private EntityList entityList;

    public EntityList getEntityList() {
        return entityList;
    }

    public void setEntityList(EntityList entityList) {
        this.entityList = entityList;
    }

    public MenuSort(EntityList entityList) {
        this.entityList = entityList;
    }


    /**
     * Показывает главное меню сортировки. Должно вызываться первым.
     * Пользователь должен выбрать поле, по которому будет проведена сортивка.
     * Список доступных для сортировки полей определяется по классу
     *
     */
    public void showSortMenu() {
        if ((entityList == null) || (entityList.getArray().length == 0)) {
            System.out.println(MenuWriteToFileDescription.NULLARRAY);
            return;
        }

        if (entityList.getArray()[0] instanceof Bus) {
            showSortBusMenu();
            return;
        }
        if (entityList.getArray()[0] instanceof Student) {
            showSortStudentMenu();
            return;
        }
        if (entityList.getArray()[0] instanceof User) {
            showSortUserMenu();
            return;
        }
        System.out.println(MenuSortDescription.NOTCORRECTARRAY);
    }


    /**
     * Проводит сортировку массива в зависимости от выбора пользователя
     */
    private void showSortBusMenu() {
        while (true) {
            switch (UserFriendlyInterface.writeMenuGetAnswer(MenuSortDescription.menuSortBusLevel)) {
                case 0: return;
                case 999:
                    System.out.println(MenuSortDescription.EXITFROMPROGRAM);
                    System.exit(0);
                case 1:
                    this.getEntityList().sort(Bus.KeySort.model.toString());
                    return;
                case 2:
                    this.getEntityList().sort(Bus.KeySort.odometer.toString());
                    return;
                case 3:
                    this.getEntityList().sort(Bus.KeySort.gosNumber.toString());
                    return;
                default:
                    System.out.println(MenuSortDescription.NOTCORRECTANSWER);
            }
        }
    }

    /**
     * Проводит сортировку массива в зависимости от выбора пользователя
     */
    private void showSortStudentMenu() {
        while (true) {
            switch (UserFriendlyInterface.writeMenuGetAnswer(MenuSortDescription.menuSortStudentLevel)) {
                case 0:
                    return;
                case 999:
                    System.out.println(MenuSortDescription.EXITFROMPROGRAM);
                    System.exit(0);
                case 1:
                    this.getEntityList().sort(Student.KeySort.groupNumber.toString());
                    return;
                case 2:
                    this.getEntityList().sort(Student.KeySort.averageScore.toString());
                    return;
                case 3:
                    this.getEntityList().sort(Student.KeySort.studentBookNumber.toString());
                    return;
                default:
                    System.out.println(MenuSortDescription.NOTCORRECTANSWER);
            }
        }
    }

    /**
     * Проводит сортировку массива в зависимости от выбора пользователя
     */
    private void showSortUserMenu() {
        while (true) {
            switch (UserFriendlyInterface.writeMenuGetAnswer(MenuSortDescription.menuSortUserLevel)) {
                case 0:
                    return;
                case 999:
                    System.out.println(MenuSortDescription.EXITFROMPROGRAM);
                    System.exit(0);
                case 1:
                    this.getEntityList().sort(User.KeySort.name.toString());
                    return;
                case 2:
                    this.getEntityList().sort(User.KeySort.email.toString());
                    return;
                default:
                    System.out.println(MenuSortDescription.NOTCORRECTANSWER);
            }
        }
    }



}
