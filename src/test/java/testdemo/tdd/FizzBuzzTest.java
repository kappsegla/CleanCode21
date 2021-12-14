package testdemo.tdd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {

    @Test
    @DisplayName("Method call returns one")
    void test() {
        assertEquals("1", FizzBuzz.fizzBuzz(1));

    }

    @Test
    @DisplayName("Method call returns two")
    void methodCallReturnsTwo() {
        assertEquals("2", FizzBuzz.fizzBuzz(2));
    }

    @ParameterizedTest
    @ValueSource(ints = {3,6})
    @DisplayName("Given number divisible by 3 returns fizz")
    void methodCallReturnsFizz(int number) {
        assertEquals("fizz", FizzBuzz.fizzBuzz(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {5,10})
    @DisplayName("Given number divisible by 5 returns buzz")
    void methodCallReturnsBuzz(int number) {
        assertEquals("buzz", FizzBuzz.fizzBuzz(number));
    }
    @Test
    @DisplayName("Method call returns fizzbuzz")
    void methodCallReturnsFizzBuzz() {
        assertEquals("fizzbuzz", FizzBuzz.fizzBuzz(15));
    }

}
