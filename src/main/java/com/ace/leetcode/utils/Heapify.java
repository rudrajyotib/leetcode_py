package com.ace.leetcode.utils;

import java.util.LinkedList;
import java.util.List;

public class Heapify
{
	public static BinaryTree toMaxHeap(int[] values)
	{
		LinkedList<BinaryTree> nodes = new LinkedList<>();
		BinaryTree root = toBinaryTree(values, 0, nodes);
		
		while (!nodes.isEmpty())
		{
			BinaryTree node = nodes.pop();
			toMaxHeap(node);
		}
		
		return root;
	}
	
	private static void toMaxHeap(BinaryTree node)
	{
		if (node == null)
		{
			return;
		}
		BinaryTree max = getMaxNode(node.left, node.right);
		swap(node, max);
		toMaxHeap(max);
	}
	
	private static BinaryTree getMaxNode(BinaryTree left, BinaryTree right)
	{
		if (left == null)
		{
			return right;
		}
		if (right == null)
		{
			return left;
		}
		return left.getValue() > right.getValue() ? left : right;
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
	
	private static BinaryTree toBinaryTree(int[] values, int i, List<BinaryTree> nodes)
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
