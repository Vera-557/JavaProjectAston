package loader;

import java.util.List;

public class DataLoaderContext<T> {
    private DataLoadStrategy<T> dataLoadStrategy;

    public DataLoaderContext(final DataLoadStrategy<T> dataLoadStrategy) {
        this.dataLoadStrategy = dataLoadStrategy;
    }

    public void setDataLoadStrategy(final DataLoadStrategy<T> dataLoadStrategy) {
        if (dataLoadStrategy != null) {
            this.dataLoadStrategy = dataLoadStrategy;
        }
    }

    public List<T> processStrategy() {
        if (dataLoadStrategy == null) {
            throw new IllegalStateException("Стратегия не может быть null");
        }
        return dataLoadStrategy.loadData();
    }
}
