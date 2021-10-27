package testdemo.stringcalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


//https://kata-log.rocks/string-calculator-kata

public class StringCalcTest {
    StringCalc stringCalc = new StringCalc();

    @Test
    void givenAnEmptyStringShouldReturnZero() {
        assertEquals(0, stringCalc.add(""));
    }

    @Test
    void givenAStringWithOneNumberShouldReturnThatNumber() {
        assertEquals(1,stringCalc.add("1"));
    }

    @Test
    void givenAStringWithTwoNumbersReturnsSumOfNumbers() {
        assertEquals(3,stringCalc.add("1,2"));
    }

    @Test
    void givenAStringWithThreeNumbersReturnsSum() {
        assertEquals(5, stringCalc.add("1,2,2"));
    }

    @Test
    void givenAStringWithCommaOrNewLineAsSeparatorsReturnsSum() {
        assertEquals(6, stringCalc.add("1\n2,3"));
    }



}
