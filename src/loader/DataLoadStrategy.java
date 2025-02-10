package loader;

import java.util.List;
//интерфейс для объединения стратегий
public interface DataLoadStrategy<T> {
    List<T> loadData();
}
