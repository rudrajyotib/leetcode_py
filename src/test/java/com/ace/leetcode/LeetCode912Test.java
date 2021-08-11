package com.ace.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LeetCode912Test
{
	@Test
	public void shouldSortArray1InAscendingOrder()
	{
		assertEquals(new Integer[]{1, 2, 3, 5}, LeetCode912.sort(new Integer[]{5, 2, 3, 1}));
	}
	
	@Test
	public void shouldSortArray2InAscendingOrder()
	{
		assertEquals(new Integer[]{0, 0, 1, 1, 2, 5}, LeetCode912.sort(new Integer[]{5, 1, 1, 2, 0, 0}));
	}
	
	@Test
	public void shouldSortArray3InAscendingOrder()
	{
		assertEquals(new Integer[]{0, 2, 5, 21, 33, 78}, LeetCode912.sort(new Integer[]{33, 21, 0, 5, 78, 2}));
	}
}
