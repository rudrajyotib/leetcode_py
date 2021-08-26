package com.ace.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode207Test
{
	@Test
	public void shouldReturnTrueIfCoursesAreMutuallyInclusive()
	{
		assertTrue(LeetCode207.solution(2, new int[][]{{1, 0}}));
		assertTrue(LeetCode207.solution(2, new int[][]{{0, 1}}));
		assertTrue(LeetCode207.solution(5, new int[][]{{1, 4}, {2, 4}, {3, 1}, {3, 2}}));
	}
	
	@Test
	public void shouldReturnFalseIfCoursesAreMutuallyExclusive()
	{
		assertFalse(LeetCode207.solution(2, new int[][]{{1, 0}, {0, 1}}));
		assertFalse(LeetCode207.solution(19, new int[][]{{0, 10}, {3, 18}, {5, 5}, {6, 11}, {11, 14}, {13, 1}, {15, 1}, {17, 4}}));
		assertFalse(LeetCode207.solution(3, new int[][]{{1, 0}, {0, 2}, {2, 1}}));
	}
	
	@Test
	public void shouldReturnSchedule()
	{
		assertArrayEquals(new int[0], LeetCode207.findOrder(2, new int[][]{{1, 0}, {0, 1}}));
		assertArrayEquals(new int[]{2, 0, 1}, LeetCode207.findOrder(3, new int[][]{{1, 0}}));
		assertArrayEquals(new int[0], LeetCode207.findOrder(0, new int[0][0]));
		assertArrayEquals(new int[]{0}, LeetCode207.findOrder(1, new int[][]{{0}}));
		assertArrayEquals(new int[]{0, 1}, LeetCode207.findOrder(2, new int[][]{{1, 0}}));
		assertArrayEquals(new int[]{1, 0}, LeetCode207.findOrder(2, new int[][]{{0, 1}}));
		assertArrayEquals(new int[]{0, 4, 1, 2, 3}, LeetCode207.findOrder(5, new int[][]{{1, 4}, {2, 4}, {3, 1}, {3, 2}}));
	}
}
