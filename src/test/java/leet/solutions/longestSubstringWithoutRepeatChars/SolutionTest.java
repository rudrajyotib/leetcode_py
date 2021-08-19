package leet.solutions.longestSubstringWithoutRepeatChars;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void shouldIdentifyLongestNonRepeatingChars()
    {
        Solution solution  = new Solution();
        assertEquals(3, solution.lengthOfLongestSubstring("abacc"));
        assertEquals(4, solution.lengthOfLongestSubstring("abcd"));
        assertEquals(1, solution.lengthOfLongestSubstring("bbbbbbbbbbb"));
        assertEquals(3, solution.lengthOfLongestSubstring("abcabcbb"));
        assertEquals(3, solution.lengthOfLongestSubstring("abac"));
    }


}