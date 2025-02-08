import EntityClass.Bus;
import comparators.Sortable2;

public class BusArray implements Sortable2<Bus> {
    Bus[] array;

    public BusArray(Bus[] array) {
        this.array = array;
    }

    @Override
    public void sort(String sortBy) {
        for (int i = 0; i < array.length; i ++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++){
                if (array[j].compareTo(array[minIndex], "odometer") < 0) {
                    minIndex = j;
                }
            }
            Bus temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }
}
