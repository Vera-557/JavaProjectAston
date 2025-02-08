package EntityClass;

import comparators.InterfaceCompare;
import comparators.Sortable;

public class Bus implements InterfaceCompare<Bus> {
    private String gosNumber;
    private String model;
    private int odometer;

    //TODO Сделать ключи через enum

    private Bus(String gosNumber, String model, int odometer) {
        this.gosNumber = gosNumber;
        this.model = model;
        this.odometer = odometer;
    }

    public static Bus create(String gosNumber, String model, int odometer) throws Exception {
//        проверка gosNumber на корректность, если да, идем дальше, если нет, кидаем исключенияч
//        проверка model на корректность, если да, идем дальше, если нет, кидаем исключенияч
//        проверка odometer на корректность, если да, идем дальше, если нет, кидаем исключенияч
        if (odometer < 0) throw new Exception("ОШИБКА! ВВЕДЕН ОТРИЦАТЕЛЬНЫЙ ОДОМЕТР");
        return new Bus(gosNumber, model, odometer);
    }

    public Bus(String gosNumber, String model) {
        this.gosNumber = gosNumber;
        this.model = model;
        this.odometer = 0;
    }

    public String getGosNumber() {
        return gosNumber;
    }

    public void setGosNumber(String gosNumber) {
        this.gosNumber = gosNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    @Override
    public String toString() {
        return "EntityClass.Bus:" +
                " " + gosNumber +
                ", '" + model +
                "', " + odometer
                ;
    }


    @Override
    public int compareTo(Bus o2, String compareBy) {
        switch (compareBy) {
            case "gosNumber":
                return this.getGosNumber().compareToIgnoreCase(o2.getGosNumber());
            case "model":
                return this.getModel().compareToIgnoreCase(o2.getModel());
            case "odometer":
                return Integer.compare(this.getOdometer(), o2.getOdometer());
            default:
                throw new IllegalArgumentException("Неверное поле сортировки: " + compareBy);
        }
    }




}
