package view;

public enum StrategyType {
    JSON("1"), MANUAL("2"), RANDOM("3"), ABORT("0");

    private final String number;

    StrategyType(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }
}
