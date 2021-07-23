package com.ace.leetcode.utils;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree
{
	private final int value;
	private final BinaryTree left;
	private final BinaryTree right;
	
	public BinaryTree(int value, BinaryTree left, BinaryTree right)
	{
		this.value = value;
		this.left = left;
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
		List<Integer> inorder = new ArrayList<>();
		toInorderList(root, inorder);
		return inorder.toArray(new Integer[0]);
	}
	
	
	public static Integer[] toPreorder(BinaryTree root)
	{
		List<Integer> preorder = new ArrayList<>();
		toPreorderList(root, preorder);
		return preorder.toArray(new Integer[0]);
	}
	
	private static void toPreorderList(BinaryTree root, List<Integer> preorder)
	{
		if (root == null)
		{
			return;
		}
		
		preorder.add(root.value);
		toPreorderList(root.left, preorder);
		toPreorderList(root.right, preorder);
	}
	
	private static void toInorderList(BinaryTree root, List<Integer> inorder)
	{
		if (root == null)
		{
			return;
		}
		toInorderList(root.left, inorder);
		inorder.add(root.value);
		toInorderList(root.right, inorder);
	}
}
