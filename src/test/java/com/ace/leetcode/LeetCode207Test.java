package com.ace.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
}
