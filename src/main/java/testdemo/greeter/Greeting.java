package testdemo.greeter;

import java.util.List;

public class Greeting {
    public static String greet(String name) {
        if (name == null)
            return "Hello, my friend.";

        if (isUpperCase(name))
            return "HELLO " + name;

        return "Hello " + name.replaceAll(",", " and ");
    }

    private static boolean isUpperCase(String name) {
      /*  char[] chars = name.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if( Character.isLowerCase(chars[i]))
                return false;
        }
        return true;*/
        return name.toUpperCase().equals(name);
    }
}
