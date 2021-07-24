package com.ace.leetcode;

import com.ace.leetcode.utils.BinaryTree;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LeetCode536Test
{
	@Test
	public void shouldConstructBinaryTreeFromString()
	{
		assertEquals(BinaryTree.toPreorder(LeetCode536.create("4(2(3)(1))(6(5))")), new Integer[]{4, 2, 3, 1, 6, 5});
	}
}