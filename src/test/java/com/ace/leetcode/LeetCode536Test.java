package com.ace.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LeetCode536Test
{
	@Test
	public void shouldConstructBinaryTreeFromString()
	{
		assertEquals(LeetCode536.create("4(2(3)(1))(6(5))").toPreorder(), new Integer[]{4, 2, 3, 1, 6, 5});
	}
}