package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinimumInsertionStepsToMakeStringPalindromeTest {

    @Test
    public void testCase1() {
        assertEquals(3, new MinimumInsertionStepsToMakeStringPalindrome().solve("abcd"));
        assertEquals(2, new MinimumInsertionStepsToMakeStringPalindrome().solve("aacd"));
        assertEquals(0, new MinimumInsertionStepsToMakeStringPalindrome().solve("abba"));
        assertEquals(1, new MinimumInsertionStepsToMakeStringPalindrome().solve("abccb"));
        assertEquals(2, new MinimumInsertionStepsToMakeStringPalindrome().solve("abcc"));
        assertEquals(9, new MinimumInsertionStepsToMakeStringPalindrome().solve("xyzbccbdeffes"));
        assertEquals(15, new MinimumInsertionStepsToMakeStringPalindrome().solve("dmtjtvqyiedezraoqkfu"));
    }

}