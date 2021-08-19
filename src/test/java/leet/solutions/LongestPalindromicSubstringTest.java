package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestPalindromicSubstringTest {

    @Test
    public void shouldFindOutLongestPalindrome()
    {
        Solution solution = new Solution();
        assertEquals("aaaaaaaa", solution.longestPalindrome("aaaaaaaabvd"));
        assertEquals("a", solution.longestPalindrome("abc"));
        assertEquals("aba", solution.longestPalindrome("xabay"));
        assertEquals("a", solution.longestPalindrome("a"));
        assertEquals("aa", solution.longestPalindrome("aa"));
        assertEquals("bcaxxacb", solution.longestPalindrome("zzzzbcaxxacbyyy"));
        assertEquals("bcaxxacb", solution.longestPalindrome("bcaxxacbyyy"));
        assertEquals("bcaxxacb", solution.longestPalindrome("bcaxxacb"));
        assertEquals("bcaxacb", solution.longestPalindrome("bcaxacb"));
        assertEquals("bcaxxxacb", solution.longestPalindrome("bcaxxxacb"));
    }

}