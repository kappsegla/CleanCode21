package greeter;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

public class GreeterTest {

    @Test
    void givenATimeBefore12ReturnGodMorgon() {
        TimeProvider timeProvider = new BeforeNoon();
        Greeter greeter = new Greeter(timeProvider);
        String greeting = greeter.greet();

        assertThat(greeting).isEqualTo("God morgon.");
    }

    @Test
    void givenATimeAfter12ReturnsGodDag() {
        TimeProvider timeProvider = Mockito.mock(TimeProvider.class);
        Mockito.when(timeProvider.currentTime()).thenReturn(LocalTime.of(12,10));
        Greeter greeter = new Greeter(timeProvider);
        String greeting = greeter.greet();

        assertThat(greeting).isEqualTo("God dag.");
    }

    @Test
    void givenATimeAfter18ReturnsGodKvall() {
        TimeProvider timeProvider = Mockito.mock(TimeProvider.class);
        Mockito.when(timeProvider.currentTime()).thenReturn(LocalTime.of(18,20));
        Greeter greeter = new Greeter(timeProvider);
        String greeting = greeter.greet();

        assertThat(greeting).isEqualTo("God kväll.");
    }


}
