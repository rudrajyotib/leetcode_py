package com.ace.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LeetCode3Test
{
	@Test
	public void shouldReturnLengthOfLongestSubstring()
	{
		assertEquals(2, LeetCode3.returnLengthOfLongestSubstring("abba"));
		assertEquals(3, LeetCode3.returnLengthOfLongestSubstring("dvdf"));
		assertEquals(2, LeetCode3.returnLengthOfLongestSubstring("cdd"));
		assertEquals(2, LeetCode3.returnLengthOfLongestSubstring("au"));
		assertEquals(0, LeetCode3.returnLengthOfLongestSubstring(""));
		assertEquals(1, LeetCode3.returnLengthOfLongestSubstring(" "));
		assertEquals(3, LeetCode3.returnLengthOfLongestSubstring("abcabcbb"));
		assertEquals(1, LeetCode3.returnLengthOfLongestSubstring("bbbbb"));
		assertEquals(3, LeetCode3.returnLengthOfLongestSubstring("pwwkew"));
	}
}