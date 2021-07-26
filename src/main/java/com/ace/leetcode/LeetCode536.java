package com.ace.leetcode;

import com.ace.leetcode.utils.BinaryTree;

public class LeetCode536
{
	public static BinaryTree create(String input)
	{
		BinaryTree root = new BinaryTree(input.charAt(0));
		build(root, root, 1, input, input.length() - 2);
		return root;
	}
	
	private static void build(BinaryTree parent, BinaryTree currentNode, int i, String s, int lastIndex)
	{
		if (i > lastIndex)
		{
			return;
		}
		
		if (s.charAt(i) == '(') // found left node
		{
			currentNode.setLeft(new BinaryTree(s.charAt(i + 1)));
			if (s.charAt(i + 2) == ')' && lastIndex > i + 3) // found right so go back up a level by returning parent
			{
				currentNode.setRight(new BinaryTree(s.charAt(i + 4)));
				build(parent, parent, i + 5, s, lastIndex);
			}
			else // find next child
			{
				build(currentNode, currentNode.getLeft(), i + 2, s, lastIndex);
			}
		}
		else
		{
			if (s.charAt(i) == ')' && s.charAt(i + 1) == ')' && lastIndex > i + 2) // found right node for parent
			{
				parent.setRight(new BinaryTree(s.charAt(i + 3)));
				build(parent, parent.getRight(), i + 4, s, lastIndex); // add to right node
			}
			else
			{
				build(parent, parent, i + 1, s, lastIndex);
			}
		}
	}
}
