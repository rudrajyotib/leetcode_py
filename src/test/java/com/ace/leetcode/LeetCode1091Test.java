package com.ace.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LeetCode1091Test
{
	@Test
	public void shouldReturnLengthOfLongestSubstring()
	{
		assertEquals(14, LeetCode1091.shortestPathBinaryMatrix(new int[][]{{0, 1, 1, 0, 0, 0}, {0, 1, 0, 1, 1, 0}, {0, 1, 1, 0, 1, 0}, {0, 0, 0, 1, 1, 0}, {1, 1, 1, 1, 1, 0}, {1, 1, 1, 1, 1, 0}}));
		assertEquals(1, LeetCode1091.shortestPathBinaryMatrix(new int[][]{{0}}));
		assertEquals(3, LeetCode1091.shortestPathBinaryMatrix(new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}));
		assertEquals(-1, LeetCode1091.shortestPathBinaryMatrix(new int[][]{{0, 0, 0}, {1, 1, 0}, {1, 1, 1}}));
		assertEquals(-1, LeetCode1091.shortestPathBinaryMatrix(new int[][]{{1, 0, 0}, {1, 1, 0}, {1, 1, 0}}));
		assertEquals(4, LeetCode1091.shortestPathBinaryMatrix(new int[][]{{0, 0, 0}, {1, 1, 0}, {1, 1, 0}}));
		assertEquals(2, LeetCode1091.shortestPathBinaryMatrix(new int[][]{{0, 1}, {1, 0}}));
	}
}