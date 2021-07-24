package com.ace.leetcode;

import com.ace.leetcode.utils.BinaryTree;

public class LeetCode536
{
	public static BinaryTree create(String input)
	{
		BinaryTree root = new BinaryTree(input.charAt(0));
		buildTree(root, root, 1, input, input.length() - 1);
		return root;
	}
	
	private static void buildTree(BinaryTree parent, BinaryTree currentNode, int i, String input, int lastIndex)
	{
		if (i > lastIndex)
		{
			return;
		}
		
		if (input.charAt(i) == '(')
		{
			BinaryTree left = new BinaryTree(input.charAt(i + 1));
			currentNode.setLeft(left);
			if (input.charAt(i + 2) == ')' && i < input.length() - 4)
			{
				currentNode.setLeft(left);
				currentNode.setRight(new BinaryTree(input.charAt(i + 4)));
				buildTree(parent, currentNode, i + 5, input, lastIndex);
			}
			buildTree(currentNode, left, i + 2, input, lastIndex);
		}
		else
		{
			if (i + 3 < input.length() && input.charAt(i + 3) != ')')
			{
				BinaryTree right = new BinaryTree(input.charAt(i + 3));
				parent.setRight(right);
				buildTree(parent, right, i + 4, input, lastIndex);
			}
		}
	}
}
