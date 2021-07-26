package com.ace.leetcode.utils;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree
{
	private final int value;
	private BinaryTree left;
	private BinaryTree right;
	
	public BinaryTree(int value, BinaryTree left, BinaryTree right)
	{
		this.value = value;
		this.left = left;
		this.right = right;
	}
	
	public BinaryTree(char value)
	{
		this.value = Integer.parseInt("" + value);
	}
	
	public static BinaryTree create(String s)
	{
		if (s == null)
		{
			return null;
		}
		//	"4(2(3)(1))(6(5))"
		BinaryTree root = new BinaryTree(s.charAt(0));
		build(root, root, 1, s, s.length() - 2);
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
			currentNode.left = new BinaryTree(s.charAt(i + 1));
			if (s.charAt(i + 2) == ')' && lastIndex > i + 3) // found right so go back up a level by returning parent
			{
				currentNode.right = new BinaryTree(s.charAt(i + 4));
				build(parent, parent, i + 5, s, lastIndex);
			}
			else // find next child
			{
				build(currentNode, currentNode.left, i + 2, s, lastIndex);
			}
		}
		else
		{
			if (s.charAt(i) == ')' && s.charAt(i + 1) == ')' && lastIndex > i + 2) // found right node for parent
			{
				parent.right = new BinaryTree(s.charAt(i + 3));
				build(parent, parent.right, i + 4, s, lastIndex); // add to right node
			}
			else
			{
				build(parent, parent, i + 1, s, lastIndex);
			}
		}
	}
	
	
	public void setLeft(BinaryTree left)
	{
		this.left = left;
	}
	
	public void setRight(BinaryTree right)
	{
		this.right = right;
	}
	
	public int getValue()
	{
		return value;
	}
	
	public BinaryTree getLeft()
	{
		return left;
	}
	
	public BinaryTree getRight()
	{
		return right;
	}
	
	public static Integer[] toInorder(BinaryTree root)
	{
		List<Integer> values = new ArrayList<>();
		toInorderList(root, values);
		return values.toArray(new Integer[0]);
	}
	
	public static Integer[] toPostorder(BinaryTree root)
	{
		List<Integer> values = new ArrayList<>();
		toPostorderList(root, values);
		return values.toArray(new Integer[0]);
	}
	
	public static Integer[] toPreorder(BinaryTree root)
	{
		List<Integer> values = new ArrayList<>();
		toPreorderList(root, values);
		return values.toArray(new Integer[0]);
	}
	
	private static void toPreorderList(BinaryTree node, List<Integer> values)
	{
		if (node == null)
		{
			return;
		}
		
		values.add(node.value);
		toPreorderList(node.left, values);
		toPreorderList(node.right, values);
	}
	
	private static void toInorderList(BinaryTree node, List<Integer> values)
	{
		if (node == null)
		{
			return;
		}
		toInorderList(node.left, values);
		values.add(node.value);
		toInorderList(node.right, values);
	}
	
	private static void toPostorderList(BinaryTree node, List<Integer> values)
	{
		if (node == null)
		{
			return;
		}
		toPostorderList(node.left, values);
		toPostorderList(node.right, values);
		values.add(node.value);
	}
}
