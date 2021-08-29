package com.ace.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LeetCode1848Test
{
	@Test
	public void shouldReturnLengthOfLongestSubstring()
	{
		assertEquals(0, LeetCode1848.getMinDistance(new int[]{1,1,1,1,1,1,1,1,1,1}, 1, 9));
		assertEquals(1, LeetCode1848.getMinDistance(new int[]{1, 2, 3, 4, 5}, 5, 3));
		assertEquals(0, LeetCode1848.getMinDistance(new int[]{1}, 1, 0));
		assertEquals(0, LeetCode1848.getMinDistance(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 1, 0));
	}
}