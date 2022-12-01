package tasks;

public enum PersonalOrWork {
    PERSONAL("Персональная"),
    WORK("Рабочая");

    private final String name;
    PersonalOrWork(String name) {
        this.name = name;
    }
}
