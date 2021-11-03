package testdemo.testable.timeofday;

import java.time.LocalDateTime;

public class NightDateTimeProvider implements LocalDateTimeProvider {
    @Override
    public LocalDateTime getDateTime() {
        return LocalDateTime.of(2021,11,03,21,0);
    }
}
