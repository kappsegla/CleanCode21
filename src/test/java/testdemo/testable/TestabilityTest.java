package testdemo.testable;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TestabilityTest {

    @Test
    void sendingEmailWithWrongAdressThrowsExceptionShouldLogError(){

        var mailSender = new SpyMailSender();

        Testability testability = new Testability(new DummyLogger(), mailSender);
        testability.run();
        assertThat(mailSender.counter).isEqualTo(1);
    }
}