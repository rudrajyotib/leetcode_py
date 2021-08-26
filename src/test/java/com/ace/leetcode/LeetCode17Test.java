package com.ace.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LeetCode17Test
{
	@Test
	public void shouldReturnLetterCombinations()
	{
		assertEquals(new String[]{"ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"}, LeetCode17.letterCombinations("23").toArray(new String[0]));
		assertEquals(new String[]{"dd", "de", "df", "ed", "ee", "ef", "fd", "fe", "ff"}, LeetCode17.letterCombinations("33").toArray(new String[0]));
	}
}