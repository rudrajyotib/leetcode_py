package com.ace.leetcode.utils;

import java.util.Arrays;
import java.util.Stack;

public class TreesAndHeaps
{
	public static BinaryTree createFromArray(Integer[] args)
	{
		int lastIndex = args.length - 1;
		return createFromArray(args, 0, 1, 2, lastIndex);
	}
	
	public static Integer[] convertTreeToArray(BinaryTree root)
	{
		Stack<BinaryTree> nodes = new Stack<>();
		nodes.push(root);
		int count = 0;
		while (!nodes.isEmpty())
		{
			BinaryTree node = nodes.pop();
			count += 3;
			if (node != null)
			{
				nodes.push(node.left);
				nodes.push(node.right);
			}
		}
		
		Integer[] values = new Integer[count];
		convertTreeToArray(root, 0, values);
		
		return values;
	}
	
	private static void convertTreeToArray(BinaryTree node, int i, Integer[] values)
	{
		if (node == null)
		{
			values[i] = null;
			return;
		}
		values[i] = node.value;
		convertTreeToArray(node.left, i * 2 + 1, values);
		convertTreeToArray(node.right, i * 2 + 2, values);
	}
	
	
	private static BinaryTree createFromArray(Integer[] args, int parent, int left, int right, int lastIndex)
	{
		if (parent > lastIndex || args[parent] == null)
		{
			return null;
		}
		
		BinaryTree leftChild = createFromArray(args, left, left * 2 + 1, left * 2 + 2, lastIndex);
		BinaryTree rightChild = createFromArray(args, right, right * 2 + 1, right * 2 + 2, lastIndex);
		
		return new BinaryTree(args[parent], leftChild, rightChild);
	}
	
	public static void heapify(int[] args)
	{
		for (int i = args.length - 1; i > 0; i--)
		{
			int pi = i % 2 == 0 ? (i / 2) - 1 : i / 2;
			
			if (args[i] > args[(pi)])
			{
				int lower = args[pi];
				args[pi] = args[i];
				args[i] = lower;
			}
		}
	}
	
	public static int[] insert(int[] args, int n)
	{
		int l = args.length;
		int[] values = Arrays.copyOf(args, l + 1);
		values[l] = n;
		insertAndSort(values, l);
		return values;
	}
	
	private static void insertAndSort(int[] values, int currentIndex)
	{
		if (currentIndex < 0)
		{
			return;
		}
		int pi = currentIndex / 2;
		
		if (values[currentIndex] > values[pi])
		{
			int lower = values[pi];
			values[pi] = values[currentIndex];
			values[currentIndex] = lower;
			insertAndSort(values, pi);
		}
	}
}
