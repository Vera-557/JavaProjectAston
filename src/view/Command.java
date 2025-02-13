package view;

public enum Command {
    ABORT("0", " - команда для возврата на предыдущий шаг"), EXIT("999", " - команда для выхода из программы");

    private final String number;
    private final String description;

    Command(String number, String description) {
        this.number = number;
        this.description = description;
    }

    public String getNumber() {
        return number;
    }

    public String getDescription() {
        return description;
    }
}
