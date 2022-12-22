package tasks;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DailyTask extends Task{
    public DailyTask(String name, String description, LocalDateTime localDateTime, TaskTypeEnum taskTypeEnum) {
        super(name, description, localDateTime, taskTypeEnum);
    }

    public boolean isCurrentTask(LocalDate valueDate) {
        return getLocalDateTime().toLocalDate().equals(valueDate) || (getLocalDateTime().toLocalDate().isBefore(valueDate));
    }
}
