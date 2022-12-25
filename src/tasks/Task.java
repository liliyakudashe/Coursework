package tasks;
import java.time.LocalDateTime;
import java.util.Objects;
public abstract class Task implements Repeatability {
    private final String name;
    private final String description;
    private final LocalDateTime localDateTime;
    private final TaskTypeEnum taskTypeEnum;
    private final int id;
    private static int count = 0;

    public Task(String name, String description, LocalDateTime localDateTime, TaskTypeEnum taskTypeEnum) {
        this.id = count++;
        this.name = name;
        this.description = description;
        this.localDateTime = localDateTime;
        this.taskTypeEnum = taskTypeEnum;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public TaskTypeEnum getTaskTypeEnum() {
        return taskTypeEnum;
    }

    public int getId() {
        return id;
    }

    public static int getCount() {
        return count;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals(name, task.name) && Objects.equals(description, task.description) && Objects.equals(localDateTime, task.localDateTime) && taskTypeEnum == task.taskTypeEnum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, localDateTime, taskTypeEnum, id);
    }

    @Override
    public String toString() {
        return "Название задачи: " + name + ", описание: " + description+
                ", дата и время: " + localDateTime +
                ", тип задачи: " + taskTypeEnum +
                ", id " + id;
    }

}
