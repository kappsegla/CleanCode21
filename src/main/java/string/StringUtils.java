package string;

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
}
