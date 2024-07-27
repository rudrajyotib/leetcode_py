package gfg;

import org.junit.Test;

import static org.junit.Assert.*;

public class FormPalindromeTest {

    @Test
    public void testCase1(){
        assertEquals(3, FormPalindrome.countMin("abcd"));
        assertEquals(2, FormPalindrome.countMin("aacd"));
        assertEquals(0, FormPalindrome.countMin("abba"));
        assertEquals(1, FormPalindrome.countMin("abccb"));
        assertEquals(2, FormPalindrome.countMin("abcc"));
        assertEquals(9, FormPalindrome.countMin("xyzbccbdeffes"));
        assertEquals(15, FormPalindrome.countMin("dmtjtvqyiedezraoqkfu"));
    }

}