package com.ace.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class LeetCode210Test
{
	@Test
	public void shouldReturnSchedule()
	{
		assertArrayEquals(new int[0], LeetCode210.findOrder(2, new int[][]{{1, 0}, {0, 1}}));
		assertArrayEquals(new int[]{2, 0, 1}, LeetCode210.findOrder(3, new int[][]{{1, 0}}));
		assertArrayEquals(new int[0], LeetCode210.findOrder(0, new int[0][0]));
		assertArrayEquals(new int[]{0}, LeetCode210.findOrder(1, new int[][]{{0}}));
		assertArrayEquals(new int[]{0, 1}, LeetCode210.findOrder(2, new int[][]{{1, 0}}));
		assertArrayEquals(new int[]{1, 0}, LeetCode210.findOrder(2, new int[][]{{0, 1}}));
		assertArrayEquals(new int[]{0, 4, 1, 2, 3}, LeetCode210.findOrder(5, new int[][]{{1, 4}, {2, 4}, {3, 1}, {3, 2}}));
	}
}
