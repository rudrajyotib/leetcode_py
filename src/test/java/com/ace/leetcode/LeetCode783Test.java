package com.ace.leetcode;

import ds.util.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LeetCode783Test
{
	@Test
	public void shouldReturnLengthOfLongestSubstring()
	{
		 TreeNode tree1 = create(new Integer[]{1, 0, 48, null, null, 12, 49});
		assertEquals(1, LeetCode783.minDiffInBST(tree1));
		
		 TreeNode tree2 =  create(new Integer[]{4, 2, 6, 1, 3});
		assertEquals(1, LeetCode783.minDiffInBST(tree2));
		
		 TreeNode tree3 = new  TreeNode(27, null, new  TreeNode(34, null, new  TreeNode(58, new  TreeNode(50, new  TreeNode(44, null, null), null), null)));
		assertEquals(6, LeetCode783.minDiffInBST(tree3));
		
		 TreeNode tree4 = new  TreeNode(5, new  TreeNode(1, null, null), new  TreeNode(7, null, null));
		assertEquals(2, LeetCode783.minDiffInBST(tree4));
	}
	
	private TreeNode create(Integer[] array){
		return build(array, 0, array.length - 1);
	}

	private static TreeNode build(Integer[] nums, int i, int size)
	{
		if (i > size || nums[i] == null)
		{
			return null;
		}
		//27,null,34,null,58,50,null,44
		TreeNode leftNode = build(nums, i * 2 + 1, size);
		TreeNode rightNode = build(nums, i * 2 + 2, size);
		return new TreeNode(nums[i], leftNode, rightNode);
	}
}