package com.ace.leetcode.utils;

public class Heapify
{
	public static BinaryTree toMaxHeap(int[] values)
	{
		BinaryTree root = toBinaryTree(values, 0);
		toMaxHeap(root);
		
		return root;
	}
	
	public static void toMaxHeap(BinaryTree root)
	{
		if (root == null)
		{
			return;
		}
		
		swap(root, root.left);
		swap(root, root.right);
		toMaxHeap(root.left);
		toMaxHeap(root.right);
	}
	
	private static void swap(BinaryTree parent, BinaryTree child)
	{
		if (child != null && parent.getValue() < child.getValue())
		{
			int value = parent.getValue();
			parent.setValue(child.getValue());
			child.setValue(value);
		}
	}
	
	private static BinaryTree toBinaryTree(int[] values, int i)
	{
		if (i > values.length - 1)
		{
			return null;
		}
		int value = values[i];
		
		BinaryTree left = toBinaryTree(values, (i * 2) + 1);
		BinaryTree right = toBinaryTree(values, (i * 2) + 2);
		
		return new BinaryTree(value, left, right);
	}
}
