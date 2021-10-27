package testdemo.stringcalculator;

import java.util.Arrays;

import static java.util.function.Predicate.not;

public class StringCalc {

    public int add(String s) {
        if (s.isEmpty())
            return 0;
        String[] parts = s.split("[^0-9]");
        return Arrays.stream(parts)
                .filter(not(String::isEmpty))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
