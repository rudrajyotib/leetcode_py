package gfg;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestCommonSubstringTest {

    @Test
    public void testCase1(){
        assertEquals(4, new LongestCommonSubstring().longestCommonSubstr("ABCDGH", "ACDGHR"));
        assertEquals(2, new LongestCommonSubstring().longestCommonSubstr("ABCDgH", "ACDGHR"));
        assertEquals(0, new LongestCommonSubstring().longestCommonSubstr("ABCD", "VWXYZ"));
        assertEquals(1, new LongestCommonSubstring().longestCommonSubstr("ABCD", "VWXYZA"));
        assertEquals(1, new LongestCommonSubstring().longestCommonSubstr("ABCD", "VWXYZAA"));
    }

}