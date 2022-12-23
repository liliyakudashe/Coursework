package tasks;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class OneTimeTask extends Task {
    public OneTimeTask(String name, String description, LocalDateTime localDateTime, TaskTypeEnum taskTypeEnum) {
        super(name, description, localDateTime, taskTypeEnum);
    }

    public boolean isCurrentTask(LocalDate valueDate) {
        LocalDate localDate = this.getLocalDateTime().toLocalDate();
        return localDate.equals(valueDate);
    }
}
