import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
    Bus bus1 = new Bus("1748 AA-3", "Ford", 345098);
    Bus bus2 = new Bus("1748 AA-2", "Nissan", 115000);
    Bus bus3 = new Bus("5554 AA-2", "GAZ", 15790);
    Bus bus4 = new Bus("1112 AA-1", "Ford", 11500);
    Bus bus5 = new Bus("5555 AA-7", "Volvo");
    List<Bus> busList = new ArrayList<>();
    busList.add(bus1);
    busList.add(bus2);
    busList.add(bus3);
    busList.add(bus4);
    busList.add(bus5);

    Bus[] busArr = {bus1, bus2, bus3, bus4, bus5};

        for (Bus bus : busList) {
            System.out.println(bus.toString());
        }




        System.out.println("===");

         busList.sort(new ObjectValueComparator<>(Bus::getGosNumber).thenComparing(new ObjectValueComparator<>(Bus::getOdometer)));
//        Collections.sort(busList);


        System.out.println(busList.get(1).compareTo(busList.get(2), "odometer"));

        for (Bus bus : busList) {
            System.out.println(bus.toString());
        }

//        Sortable<Bus> srt = new Bus("1748 AA-3", "Ford", 345098);

        Sortable2<Bus> busArray = new BusArray(busArr);

        System.out.println("С массивом");
        for (Bus bus : busArr) {
            System.out.println(bus.toString());
        }
        System.out.println("Сортируем");
        busArray.sort("model");
        //bus1.sort(busArr, "model");
        for (Bus bus : busArr) {
            System.out.println(bus.toString());
        }
    }

}
