package com.ace.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LeetCode849Test
{
	@Test
	public void shouldReturnMaxDistToClosest()
	{
		assertEquals(2, LeetCode849.maxDistToClosest(new int[]{1, 0, 0, 0, 1, 0, 1}));
		assertEquals(3, LeetCode849.maxDistToClosest(new int[]{1, 0, 0, 0}));
		assertEquals(1, LeetCode849.maxDistToClosest(new int[]{0, 1}));
	}
}