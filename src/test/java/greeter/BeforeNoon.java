package greeter;

import java.time.LocalTime;

public class BeforeNoon implements TimeProvider {
    @Override
    public LocalTime currentTime() {
        return LocalTime.of(10,15);
    }
}
