package testdemo.testable.timeofday;

import java.time.LocalDateTime;

public class TimeOfDay {

    public static String getTimeOfDay(LocalDateTime time)
    {
        if (time.getHour() < 6)
        {
            return "Night";
        }
        if (time.getHour() < 12)
        {
            return "Morning";
        }
        if (time.getHour() < 18)
        {
            return "Afternoon";
        }
        return "Evening";
    }

    public static void main(String[] args) {
        System.out.println(getTimeOfDay(LocalDateTime.now()));
    }
}
