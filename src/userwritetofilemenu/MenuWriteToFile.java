package userwritetofilemenu;

import datafileoutput.WriteDataToFile;
import entityclass.EntityList;
import usersortmenu.MenuSortDescription;

import java.util.Scanner;

/**
 * Сохраняет массив в файл
 * @author Виктор Карпов
 */
public class MenuWriteToFile {
    private EntityList entityList;

    public EntityList getEntityList() {
        return entityList;
    }

    public void setEntityList(EntityList entityList) {
        this.entityList = entityList;
    }

    public MenuWriteToFile(EntityList entityList) {
        this.entityList = entityList;
    }

    /**
     * Проводит запись массива в файл
     */
    public void showWriteToFileMenu() {
        if ((entityList == null) || (entityList.getArray().length == 0)) {
            System.out.println(MenuWriteToFileDescription.NULLARRAY);
            return;
        }

        System.out.println(MenuWriteToFileDescription.WELCOMETITLE);
        System.out.println(MenuWriteToFileDescription.PATHFORWRITE);
        Scanner in = new Scanner(System.in);
        try {
            if (WriteDataToFile.writeArrayToFile(entityList.getArray(), in.next(), true)){
                System.out.println(MenuWriteToFileDescription.FILESAVEANSWER);
            }
        } catch (Exception e) {
            System.out.println(MenuSortDescription.NOTCORRECTANSWER);
        }

    }
}

