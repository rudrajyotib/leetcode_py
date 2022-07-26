package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestSubstringWithoutRepeatingCharactersTest {

    @Test
    public void shouldIdentifyLongestNonRepeatingChars()
    {
        LongestSubstringWithoutRepeatingCharacters.Solution solution  = new LongestSubstringWithoutRepeatingCharacters.Solution();
        assertEquals(3, solution.lengthOfLongestSubstring("abacc"));
        assertEquals(4, solution.lengthOfLongestSubstring("abcd"));
        assertEquals(1, solution.lengthOfLongestSubstring("bbbbbbbbbbb"));
        assertEquals(3, solution.lengthOfLongestSubstring("abcabcbb"));
        assertEquals(3, solution.lengthOfLongestSubstring("abac"));
    }


}