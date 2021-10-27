package testdemo.stringcalculator;

import java.util.Arrays;

public class StringCalc {

    public int add(String s) {
        if( s.isEmpty())
            return 0;
        s = s.replaceAll("\n",",");
        String[] parts = s.split(",");
        return Arrays.stream(parts)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
