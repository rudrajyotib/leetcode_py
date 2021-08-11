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
	}
	
	@Test
	public void shouldReturnFalseIfCoursesAreMutuallyExclusive()
	{
		assertFalse(LeetCode207.solution(new int[][]{{1, 0}, {0, 1}}));
	}
}
