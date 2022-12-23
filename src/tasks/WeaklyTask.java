package tasks;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class WeaklyTask extends Task {

    public WeaklyTask(String name, String description, LocalDateTime localDateTime, TaskTypeEnum taskTypeEnum) {
        super(name, description, localDateTime, taskTypeEnum);
    }

    public boolean isCurrentTask(LocalDate valueDate) {
        return valueDate.isAfter(this.getLocalDateTime().toLocalDate()) && valueDate.getDayOfWeek().equals(this.getLocalDateTime().toLocalDate().getDayOfWeek());
    }
}
