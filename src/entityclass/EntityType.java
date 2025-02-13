package entityclass;

import comparators.InterfaceCompare;

public enum EntityType {
    BUS(Bus.class, "1"), STUDENT(Student.class, "2"), USER(User.class, "3");

    private final Class<? extends InterfaceCompare<?>> typeClass;
    private final String number;

    EntityType(Class<? extends InterfaceCompare<?>> typeClass, String number) {
        this.typeClass = typeClass;
        this.number = number;
    }

    public Class<? extends InterfaceCompare<?>> getTypeClass() {
        return typeClass;
    }

    public String getNumber(){
        return number;
    }
}
