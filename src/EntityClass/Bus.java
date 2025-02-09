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

    public static boolean gosNumberValidate(String str) {
        return str.matches("^\\d{4} [a-zA-Z]{2}-[1-7]$");
    }

    public static boolean modelValidate(String str) {
        return str.matches("[a-zA-Z0-9]*");
    }

    public static boolean odometerValidate(int i) {
        if (i < 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Возвращает экземпляр класса БЕЗ ПРОВЕРКИ данных на валидность
     * @param gosNumber
     * @param model
     * @param odometer
     * @return
     */
    public static Bus create(String gosNumber, String model, int odometer) {
            return new Bus(gosNumber, model, odometer);
    }

    
    /**
     * Возвращает экземпляр класса С ПРОВЕРКОЙ данных на валидность (если true)
     * @param gosNumber
     * @param model
     * @param odometer
     * @param needValidate
     * @return
     * @throws Exception
     */
    public static Bus create(String gosNumber, String model, int odometer, boolean needValidate) throws Exception {
        if (needValidate) {
            if (!gosNumberValidate(gosNumber)) throw new IncorrectDataException("ОШИБКА! Некорректный ввод номера автомобиля. Введено: " + gosNumber);
            if (!modelValidate(model)) throw new IncorrectDataException("ОШИБКА! Некорректный ввод модели. Разрешаются только цифры и буквы Введено: " + gosNumber);
            if (!odometerValidate(odometer)) throw new IncorrectDataException("ОШИБКА! Значение одометра не может быть отрицательным. Введено: " + odometer);
            return new Bus(gosNumber, model, odometer);
        } else {
            return new Bus(gosNumber, model, odometer);
        }
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
