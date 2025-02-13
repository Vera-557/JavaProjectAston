package entityclass;

import comparators.InterfaceCompare;

public enum EntityType {
    BUS(Bus.class), STUDENT(Student.class), USER(User.class);

    private final Class<? extends InterfaceCompare<?>> typeClass;

    EntityType(Class<? extends InterfaceCompare<?>> typeClass) {
        this.typeClass = typeClass;
    }

    public Class<? extends InterfaceCompare<?>> getTypeClass() {
        return typeClass;
    }
}
