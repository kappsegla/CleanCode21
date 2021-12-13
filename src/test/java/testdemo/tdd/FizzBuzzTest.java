package testdemo.tdd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {

    @Test
    @DisplayName("method call returns one")
    void methodCallReturnsOne() {
         assertEquals("1", FizzBuzz.fizzBuzz(1));
    }


}
