package com.ace.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode207Test
{
	@Test
	public void shouldReturnTrueIfCoursesAreMutuallyInclusive()
	{
		assertTrue(LeetCode207.solution(new int[][]{{1, 0}}));
		assertTrue(LeetCode207.solution(new int[][]{{0, 1}}));
		assertTrue(LeetCode207.solution(new int[][]{{1, 4}, {2, 4}, {3, 1}, {3, 2}}));
	}
	
	@Test
	public void shouldReturnFalseIfCoursesAreMutuallyExclusive()
	{
		assertFalse(LeetCode207.solution(new int[][]{{1, 0}, {0, 1}}));
		assertFalse(LeetCode207.solution(new int[][]{{0, 10}, {3, 18}, {5, 5}, {6, 11}, {11, 14}, {13, 1}, {15, 1}, {17, 4}}));
		assertFalse(LeetCode207.solution(new int[][]{{1, 0}, {0, 2}, {2, 1}}));
	}
	
	@Test
	public void shouldReturnSchedule()
	{
		assertArrayEquals(new int[]{}, LeetCode207.findOrder(new int[][]{{}}));
		assertArrayEquals(new int[]{0, 1}, LeetCode207.findOrder(new int[][]{{1, 0}}));
		assertArrayEquals(new int[]{1, 0}, LeetCode207.findOrder(new int[][]{{0, 1}}));
		assertArrayEquals(new int[]{4, 1, 2, 3}, LeetCode207.findOrder(new int[][]{{1, 4}, {2, 4}, {3, 1}, {3, 2}}));
	}
}
