package com.ace.leetcode;

import com.ace.leetcode.utils.BinaryTree;

public class LeetCode105
{
	
	public static BinaryTree create(int[] preorder, int[] inorder)
	{
		int lastIndex = preorder.length - 1;
		return buildTree(preorder, 0, lastIndex, inorder, 0);
	}
	
	private static BinaryTree buildTree(int[] preorder,
										int preorderStartIndex,
										int preorderEndIndex,
										int[] inorder,
										int inorderStartIndex)
	{
		if (preorderStartIndex > preorderEndIndex)
		{
			return null;
		}
		
		int indexOfCurrentRootValueInInorderArray = 0;
		while (inorder[indexOfCurrentRootValueInInorderArray] != preorder[preorderStartIndex])
		{
			indexOfCurrentRootValueInInorderArray++;
		}
		
		// Location of the root in inorder array + preorderStartIndex - inorderStartIndex
		// How many spaces do you have to the left of the current root and last root which tell you where to get the current right node from
		int tnel = indexOfCurrentRootValueInInorderArray + preorderStartIndex - inorderStartIndex;
		
		BinaryTree left = buildTree(preorder, preorderStartIndex + 1, tnel, inorder, inorderStartIndex);
		BinaryTree right = buildTree(preorder, tnel + 1, preorderEndIndex, inorder, indexOfCurrentRootValueInInorderArray + 1);
		
		return new BinaryTree(preorder[preorderStartIndex], left, right);
	}
	
}
