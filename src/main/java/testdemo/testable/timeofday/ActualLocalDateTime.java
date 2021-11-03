package testdemo.testable.timeofday;

import java.time.LocalDateTime;

public class ActualLocalDateTime implements LocalDateTimeProvider {
    @Override
    public LocalDateTime getDateTime() {
        return LocalDateTime.now();
    }
}
