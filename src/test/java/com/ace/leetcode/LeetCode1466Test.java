package com.ace.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LeetCode1466Test
{
	@Test
	public void shouldReorderRoutesToMakeAllPathsLeadToTargetWithTwoRoutes()
	{
		assertEquals(3, LeetCode1466.calculateRoute(6, new int[][]{{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}}));
	}
	
	@Test
	public void shouldReorderRoutesToMakeAllPathsLeadToTargetWithSingleRoute()
	{
		assertEquals(2, LeetCode1466.calculateRoute(5, new int[][]{{1, 0}, {1, 2}, {3, 2}, {3, 4}}));
	}
	
	@Test
	public void shouldReorderRoutesToMakeAllPathsLeadToTargetWithZeroRoute()
	{
		assertEquals(0, LeetCode1466.calculateRoute(5, new int[][]{{1, 0}, {2, 0}}));
	}
}
