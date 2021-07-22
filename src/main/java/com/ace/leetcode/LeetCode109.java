package com.ace.leetcode;

import com.ace.leetcode.utils.BinaryTree;

public class LeetCode109
{
	public static BinaryTree create(int[] numbers)
	{
		return createSortedTree(numbers, 0, numbers.length - 1);
	}
	
	private static BinaryTree createSortedTree(int[] numbers, int left, int right)
	{
		if (left > right)
		{
			return null;
		}
		
		int midpoint = (left + right) >>> 1;
		
		BinaryTree leftNode = createSortedTree(numbers, left, midpoint - 1);
		BinaryTree rightNode = createSortedTree(numbers, midpoint + 1, right);
		
		return new BinaryTree(numbers[midpoint], leftNode, rightNode);
	}
}
