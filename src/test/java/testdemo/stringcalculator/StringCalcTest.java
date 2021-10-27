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




}
