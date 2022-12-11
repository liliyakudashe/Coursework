package tasks;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MonthlyTask extends Task{
    public MonthlyTask(String name, String description, LocalDateTime localDateTime, PersonalOrWork personalOrWork) {
        super(name, description, localDateTime, personalOrWork);
    }

    @Override
    public boolean isCurrentTask(LocalDate valueDate) {
        LocalDate localDate = this.getLocalDateTime().toLocalDate();
        return localDate.equals(valueDate) || localDate.isBefore(valueDate) && valueDate.getDayOfMonth() == localDate.getDayOfMonth();
    }
}
