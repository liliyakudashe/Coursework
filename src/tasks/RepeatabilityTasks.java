package tasks;
public enum RepeatabilityTasks {
    ONE_TIME("однократная"),
    DAILY("ежедневная"),
    WEAKLY("еженедельная"),
    MONTHLY("ежемесячная"),
    YEAR("ежегодная");

    private final String name;
    RepeatabilityTasks(String name) {
        this.name = name;
    }
}
