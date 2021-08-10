package com.ace.leetcode.utils;

import java.util.Collections;
import java.util.Stack;

public class Heapify
{
	public static BinaryTree toMaxHeap(int[] values)
	{
		Stack<BinaryTree> nodes = new Stack<>();
		BinaryTree root = toBinaryTree(values, 0, nodes);
		Collections.reverse(nodes);
		
		while (!nodes.isEmpty())
		{
			toMaxHeap(nodes.pop());
		}
		
		return root;
	}
	
	private static void toMaxHeap(BinaryTree node)
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
	
	private static BinaryTree toBinaryTree(int[] values, int i, Stack<BinaryTree> nodes)
	{
		if (i > values.length - 1)
		{
			return null;
		}
		int value = values[i];
		
		BinaryTree left = toBinaryTree(values, (i * 2) + 1, nodes);
		BinaryTree right = toBinaryTree(values, (i * 2) + 2, nodes);
		
		BinaryTree node = new BinaryTree(value, left, right);
		nodes.add(node);
		return node;
	}
}
