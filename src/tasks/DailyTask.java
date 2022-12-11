package tasks;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DailyTask extends Task{
    public DailyTask(String name, String description, LocalDateTime localDateTime, PersonalOrWork personalOrWork) {
        super(name, description, localDateTime, personalOrWork);
    }

    public boolean isCurrentTask(LocalDate valueDate) {
        return getLocalDateTime().toLocalDate().equals(valueDate) || (getLocalDateTime().toLocalDate().isBefore(valueDate));
    }
}
