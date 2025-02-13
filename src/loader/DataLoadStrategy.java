package loader;

import comparators.InterfaceCompare;
import entityclass.EntityList;

import java.util.List;
//интерфейс для объединения стратегий
public interface DataLoadStrategy<T extends InterfaceCompare> {
    EntityList<T> loadData();
}
