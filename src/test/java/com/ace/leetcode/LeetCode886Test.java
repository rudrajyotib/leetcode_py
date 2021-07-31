package com.ace.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LeetCode886Test
{
	@Test
	public void shouldReturnTrueWhenPartitionIsPossible()
	{
		assertTrue(LeetCode886.partition(4, new int[][]{{1, 2}, {1, 3}, {2, 4}}));
	}
	
	@Test
	public void shouldReturnFalseWhenPartitionIsNotPossible()
	{
		assertFalse(LeetCode886.partition(3, new int[][]{{1, 2}, {1, 3}, {2, 3}}));
		assertFalse(LeetCode886.partition(5, new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}}));
	}
}