package tasks;

import java.time.LocalDateTime;
import java.util.Objects;

public class Task {
    private static String name;
    //private final String name;
    private final LocalDateTime localDateTime;
    private final PersonalOrWork personalOrWork;
    private int id;
    private static int count = 0;

    public Task(String name, LocalDateTime localDateTime, PersonalOrWork personalOrWork) {
        count++;
        this.name = name;
        this.localDateTime = localDateTime;
        this.personalOrWork = personalOrWork;
        this.id = count;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public PersonalOrWork getPersonalOrWork() {
        return personalOrWork;
    }

    public int getId() {
        return id;
    }

    public static int getCount() {
        return count;
    }

    public static String getTaskInfo(){
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals(name, task.name) && Objects.equals(localDateTime, task.localDateTime) && personalOrWork == task.personalOrWork;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, localDateTime, personalOrWork, id);
    }

    @Override
    public String toString() {
        return "Название задачи: " + name +
                ", дата и время: " + localDateTime +
                ", тип задачи: " + personalOrWork +
                ", id " + id;
    }
}
