package EntityClass;

import comparators.InterfaceCompare;

public class User implements InterfaceCompare<User> {
//    public class EntityClass.User implements Comparable<EntityClass.User> {
    private String name;
    private String email;
    private String password;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
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

    @Override
    public String toString() {
        return "EntityClass.User:" +
                " " + name +
                ", '" + email +
                "', " + password
                ;
    }

    @Override
    public int compareTo(User o2, String compareBy) {
        switch (compareBy) {
            case "name":
                return this.getName().compareToIgnoreCase(o2.getName());
            case "email":
                return this.getEmail().compareToIgnoreCase(o2.getEmail());
            case "password":
                return this.getPassword().compareTo(o2.getPassword());
            default:
                throw new IllegalArgumentException("Неверное поле сортировки: " + compareBy);
        }
    }


}
