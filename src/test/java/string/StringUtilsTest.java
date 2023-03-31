package string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @Test
    void reverseStringTest() {
        String actual = StringUtils.reverseString("hej");
        String expected = "jeh";
        //skriv assert
        assertEquals(expected,actual);
    }

  @Test
  void isPalindrome(){
        boolean actual = StringUtils.isPalindrome("anna");
        boolean expected = true;

        assertEquals(expected, actual);
  }
    @Test
    void isPalindromeNotEven(){
        boolean actual = StringUtils.isPalindrome("annna");
        boolean expected = true;

        assertEquals(expected, actual);
    }

    @Test
    void isNotPalindrome(){
        boolean actual = StringUtils.isPalindrome("Martin");
        boolean expected = false;

        assertEquals(expected, actual);
    }

}
