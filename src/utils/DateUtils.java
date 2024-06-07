package utils;

import java.time.LocalDate;

public class DateUtils {
    public static LocalDate calculateDueDate() {
        return LocalDate.now().plusWeeks(2);
    }
}
