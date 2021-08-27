package com.ace.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LeetCode424Test
{
	@Test
	public void shouldReturnLongestRepeatingCharacterReplacement()
	{
		assertEquals(2, LeetCode424.characterReplacement("ABAA", 0));
		assertEquals(4, LeetCode424.characterReplacement("AAAA", 2));
		assertEquals(4, LeetCode424.characterReplacement("ABAB", 2));
		assertEquals(4, LeetCode424.characterReplacement("AABABBA", 1));
		assertEquals(2, LeetCode424.characterReplacement("AABA", 0));
		assertEquals(2, LeetCode424.characterReplacement("ABCDE", 1));
		assertEquals(4, LeetCode424.characterReplacement("ABBB", 2));
	}
}
