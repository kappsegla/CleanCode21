package string;

import java.util.HashSet;
import java.util.Set;

public class StringUtils {

    public static String reverseString(String string) {
        StringBuilder stringBuilder = new StringBuilder(string);
        stringBuilder.reverse();

        return stringBuilder.toString();
    }


    public static boolean isPalindrome(String palindrome) {
//        int halfSize = palindrome.length()/2;
//        for (int i = 0; i < halfSize ; i++) {
//            if (!(palindrome.charAt(i)==palindrome.charAt(palindrome.length()-1-i)))
//                return false;
//        }
//        return true;

       return palindrome.equalsIgnoreCase(reverseString(palindrome));
    }

    public static boolean stringContainsAllChars(String input) {

        input = input.toLowerCase();
        
        if (input.length() < 26)
            return false;

//        for (char c = 'a';  c <= 'z'; c++) {
//            if (!input.contains(Character.toString(c)))
//               return false;
//        }

        Set<Character> charSet = new HashSet<>(26);
        input.chars().filter(Character::isLetter).forEach(c -> charSet.add((char) c));

        if (charSet.size() != 26)
            return false;
       
       return true;
    }
}
