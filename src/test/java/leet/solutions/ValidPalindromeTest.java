package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidPalindromeTest {

    @Test
    public void shouldValidatePalindrome()
    {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        assertTrue(validPalindrome.isPalindrome("A man, a plan, a canal: Panama"));
        assertTrue(validPalindrome.isPalindrome("          &*&*&*&*&*"));
        assertFalse(validPalindrome.isPalindrome("          &*&*&*ac&*&*"));
        assertTrue(validPalindrome.isPalindrome("          &*&a*&*&*&*"));
        assertTrue(validPalindrome.isPalindrome("        &*&*&&&*&&*1d1        "));
        assertTrue(validPalindrome.isPalindrome("        &*&*&&&*&&*1d1   *&*&*     "));
        assertTrue(validPalindrome.isPalindrome("        &*&*&&&*&&*1(*(*(*(*d(*((*(*1   *&*&*     "));
    }

}