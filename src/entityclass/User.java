package entityclass;

import com.fasterxml.jackson.annotation.JsonProperty;
import comparators.InterfaceCompare;
import comparators.PureComparator;

/**
 * Описывает класс User
 * @author Виктор Карпов
 */
public class User implements InterfaceCompare<User> {

    private String name;
    private String email;
    private String password;

    /**
     * Допустимые ключи сортировки
     */
    public enum KeySort {
        name,
        email,
        password
    }

//    private User(String name, String email, String password) {
        private User(@JsonProperty("name") String name, @JsonProperty("email") String email, @JsonProperty("password") String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    /**
     * Валидация правильности ввода имени пользователя
     * @param str
     * @return
     */
    public static boolean nameValidate(String str) {
        return str.matches("^[a-zA-Z]+$");
    }

    /**
     * Валидация правильности ввода email
     * @param d
     * @return
     */
    public static boolean emailValidate(String str) {
        return str.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
    }

    /**
     * Валидация правильности ввода пароля
     * @param str
     * @return
     */
    public static boolean passwordValidate(String str) {
        return true;
        //return str.matches("^[a-zA-Z]+$");
    }

    @Deprecated
    /**
     * Возвращает экземпляр класса БЕЗ ПРОВЕРКИ данных на валидность
     * @param name
     * @param email
     * @param password
     * @return
     */
    public static User create(String name, String email, String password) {
        return new User(name, email, password);
    }

    /**
     * Возвращает экземпляр класса С ПРОВЕРКОЙ данных на валидность (если true)
     * @param name
     * @param email
     * @param password
     * @param needValidate
     * @return экземпляр класса
     * @throws Exception выбрасывается в случае, если не прошла валидация на создание объекта
     */
    public static User create(String name, String email, String password, boolean needValidate) throws Exception {
        if (needValidate) {
            if (!nameValidate(name)) throw new IncorrectDataException("ОШИБКА! Некорректный ввод имени. Разрешены только буквы Введено: " + name);
            if (!emailValidate(email)) throw new IncorrectDataException("ОШИБКА! Некорректный ввод e-mail. Введено: " + email);
            if (!passwordValidate(password)) throw new IncorrectDataException("ОШИБКА! Некорректные символы в пароле. Введено: " + password);
            return new User(name, email, password);
        } else {
            return new User(name, email, password);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Извлекает значение указанного поля из объекта User.
     * @param user объект User
     * @param field имя поля
     * @return значение поля
     */
    public Object extractValue(User user, String field) {
        switch (field) {
            case "name":
                return user.getName();
            case "email":
                return user.getEmail();
            case "password":
                return user.getPassword();
            default:
                throw new IllegalArgumentException("Неверное поле: " + field);
        }
    }

    @Override
    public String toString() {
        return "EntityClass.User:" +
                " " + name +
                ", '" + email +
                "', " + password;
    }

    @Override
    public int compareTo(User o2, String compareBy) {
        switch (compareBy) {
            case "name":
                return PureComparator.compareString(this.getName(), o2.getName());
            case "email":
                return PureComparator.compareString(this.getEmail(), o2.getEmail());
            case "password":
                return PureComparator.compareString(this.getPassword(), o2.getPassword());
            default:
                throw new IllegalArgumentException("Неверное поле сортировки: " + compareBy);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return email.equals(user.email);
    }

    @Override
    public int hashCode() {
        return email.hashCode();
    }
}
