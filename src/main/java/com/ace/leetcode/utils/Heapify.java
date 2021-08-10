package com.ace.leetcode.utils;

import java.util.Collections;
import java.util.Stack;

public class Heapify
{
	public static BinaryTree toMaxHeap(int[] values)
	{
		BinaryTree root = toBinaryTree(values, 0);
		Stack<BinaryTree> nodes = new Stack<>();
		toPostOrderStack(root, nodes);
		Collections.reverse(nodes);
		
		while (!nodes.isEmpty())
		{
			toMaxHeap(nodes.pop());
		}
		
		return root;
	}
	
	public static void toPostOrderStack(BinaryTree node, Stack<BinaryTree> nodes)
	{
		if (node == null)
		{
			return;
		}
		toPostOrderStack(node.left, nodes);
		toPostOrderStack(node.right, nodes);
		nodes.add(node);
	}
	
	public static void toMaxHeap(BinaryTree node)
	{
		if (node == null)
		{
			return;
		}
		swap(node, node.left);
		swap(node, node.right);
		toMaxHeap(node.left);
		toMaxHeap(node.right);
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
