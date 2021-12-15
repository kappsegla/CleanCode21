package greeter;

import java.time.LocalTime;

public class TimeProviderImpl implements TimeProvider {
    @Override
    public LocalTime currentTime() {
        return LocalTime.now();
    }
}
