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


    @Test
    void doesStringContain26Chars(){
        boolean actual = StringUtils.stringContainsAllChars("fghijpklmnopqrstuvawxyzabcde");
        boolean expected = true;

        assertEquals(expected, actual);

    }
    @Test
    void stringDoesNotContain26Chars(){
        boolean actual = StringUtils.stringContainsAllChars("Martin");
        boolean expected = false;

        assertEquals(expected, actual);
    }

    @Test
    void stringDoesContainAllChars(){
        boolean actual = StringUtils.stringContainsAllChars("ABCDefGHIjKLmNOPQrStUVwXYz");
        boolean expected = true;

        assertEquals(expected, actual);
    }
    @Test
    void stringDoesContainAllCharsFilterNonLetter(){
        boolean actual = StringUtils.stringContainsAllChars("ABCDefGHIj.LmNOPQrStUVwXYz");
        boolean expected = false;

        assertEquals(expected, actual);
    }

}
