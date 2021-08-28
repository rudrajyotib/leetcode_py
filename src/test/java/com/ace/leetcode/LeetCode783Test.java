package com.ace.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LeetCode783Test
{
	@Test
	public void shouldReturnLengthOfLongestSubstring()
	{
		LeetCode783.TreeNode tree1 = LeetCode783.TreeNode.create(new Integer[]{1, 0, 48, null, null, 12, 49});
		assertEquals(1, LeetCode783.minDiffInBST(tree1));
		
		LeetCode783.TreeNode tree2 = LeetCode783.TreeNode.create(new Integer[]{4, 2, 6, 1, 3});
		assertEquals(1, LeetCode783.minDiffInBST(tree2));
		
		LeetCode783.TreeNode tree3 = new LeetCode783.TreeNode(27, null, new LeetCode783.TreeNode(34, null, new LeetCode783.TreeNode(58, new LeetCode783.TreeNode(50, new LeetCode783.TreeNode(44, null, null), null), null)));
		assertEquals(6, LeetCode783.minDiffInBST(tree3));
		
		LeetCode783.TreeNode tree4 = new LeetCode783.TreeNode(5, new LeetCode783.TreeNode(1, null, null), new LeetCode783.TreeNode(7, null, null));
		assertEquals(2, LeetCode783.minDiffInBST(tree4));
	}
}