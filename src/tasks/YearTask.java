package tasks;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class YearTask extends Task{
    public YearTask(String name, String description, LocalDateTime localDateTime, TaskTypeEnum taskTypeEnum) {
        super(name, description, localDateTime, taskTypeEnum);
    }
    @Override
    public boolean isCurrentTask(LocalDate valueDate) {
        LocalDate localDate = this.getLocalDateTime().toLocalDate();
        return valueDate.equals(localDate) || valueDate.isAfter(localDate) && valueDate.getDayOfMonth() == localDate.getDayOfMonth() && valueDate.getMonth().equals(localDate.getMonth());
    }
}
