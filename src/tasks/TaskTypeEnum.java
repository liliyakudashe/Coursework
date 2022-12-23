package tasks;
public enum TaskTypeEnum {
    PERSONAL("Персональная"),
    WORK("Рабочая");

    private final String name;
    TaskTypeEnum(String name) {
        this.name = name;
    }
}
