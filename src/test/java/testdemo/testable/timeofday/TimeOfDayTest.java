package testdemo.testable.timeofday;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class TimeOfDayTest {
    @Test
    void getTimeOfDayReturnsMorningBetween6And12() {
        LocalDateTime localDateTime = LocalDateTime.of(2021,11,3,7,0,0);

        var result = TimeOfDay.getTimeOfDay(localDateTime);
        assertEquals("Morning",result);
    }

    @Test
    void getTimeOfDayReturnsAfternoonBetween12And18() {
        LocalDateTime localDateTime = LocalDateTime.of(2021,11,3,13,0,0);

        var result = TimeOfDay.getTimeOfDay(localDateTime);
        assertEquals("Afternoon",result);
    }
}