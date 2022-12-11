package tasks;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class OneTimeTask extends Task {

    public OneTimeTask(String name, String description, LocalDateTime localDateTime, PersonalOrWork personalOrWork) {
        super(name, description, localDateTime, personalOrWork);
    }

    public boolean isCurrentTask(LocalDate valueDate) {
        LocalDate localDate = this.getLocalDateTime().toLocalDate();
        return localDate.equals(valueDate);
    }
}
