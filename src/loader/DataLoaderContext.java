package loader;

import comparators.InterfaceCompare;
import entityclass.EntityList;

import java.util.List;

public class DataLoaderContext<T extends InterfaceCompare> {
    private DataLoadStrategy<T> dataLoadStrategy;

    public DataLoaderContext(final DataLoadStrategy<T> dataLoadStrategy) {
        this.dataLoadStrategy = dataLoadStrategy;
    }

    public void setDataLoadStrategy(final DataLoadStrategy<T> dataLoadStrategy) {
        if (dataLoadStrategy != null) {
            this.dataLoadStrategy = dataLoadStrategy;
        }
    }

    public EntityList<T> processStrategy() {
        if (dataLoadStrategy == null) {
            throw new IllegalStateException("Стратегия не может быть null");
        }
        return dataLoadStrategy.loadData();
    }
}
