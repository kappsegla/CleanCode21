package testdemo.roman;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralTest {

    RomanNumeral romanNumeral = new RomanNumeral();

    //Arrange
    //Act
    //Assert

    @Test
    void convertingRomanIGivesNumber1Back() {
        assertEquals(1, romanNumeral.convert("I"), "Converting I should return 1");
    }

    @ParameterizedTest
    @CsvSource({"IX,9", "X,10", "XX,20"})
    void convertingRomanIVGivesNumber4Back(String input, int result) {
        assertEquals(result, romanNumeral.convert(input));
    }

}