package entityclass;

import com.fasterxml.jackson.annotation.JsonProperty;
import comparators.InterfaceCompare;
import comparators.PureComparator;
import search.ValueExtractor;

/**
 * Описывает класс Bus
 * @author Виктор Карпов
 */
public class Bus implements InterfaceCompare<Bus>, ValueExtractor<Bus, Object> {
    private String gosNumber;
    private String model;
    private int odometer;

    /**
     * Допустимые ключи сортировки
     */
    public enum KeySort {
        gosNumber,
        model,
        odometer
    }

//    private Bus(String gosNumber, String model, int odometer) {
    private Bus(@JsonProperty("gosNumber") String gosNumber, @JsonProperty("model") String model, @JsonProperty("odometer") int odometer) {
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

    @Deprecated
    public static Bus create(String gosNumber, String model, int odometer) {
        return new Bus(gosNumber, model, odometer);
    }

    public static Bus create(String gosNumber, String model, int odometer, boolean needValidate) throws Exception {
        if (needValidate) {
            if (!gosNumberValidate(gosNumber)) throw new IncorrectDataException("ОШИБКА! Некорректный ввод номера автомобиля. Введено: " + gosNumber);
            if (!modelValidate(model)) throw new IncorrectDataException("ОШИБКА! Некорректный ввод модели. Разрешаются только цифры и буквы Введено: " + model);
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
                "', " + odometer;
    }

    @Override
    public int compareTo(Bus o2, String compareBy) {
        switch (compareBy) {
            case "gosNumber":
                return PureComparator.compareString(this.getGosNumber(), o2.getGosNumber());
            case "model":
                return PureComparator.compareString(this.getModel(), o2.getModel());
            case "odometer":
                return PureComparator.compareInteger(this.getOdometer(), o2.getOdometer());
            default:
                throw new IllegalArgumentException("Неверное поле сортировки: " + compareBy);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bus bus = (Bus) o;
        return gosNumber.equals(bus.gosNumber);
    }

    @Override
    public int hashCode() {
        return gosNumber.hashCode();
    }


    @Override
    public Object extractValue(Bus object, String field) {
        switch (field) {
            case "gosNumber":
                return object.getGosNumber();
            case "model":
                return object.getModel();
            case "odometer":
                return object.getOdometer();
            default:
                throw new IllegalArgumentException("Неизвестное поле: " + field);
        }
    }
}