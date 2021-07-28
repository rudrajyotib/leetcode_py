package com.ace.leetcode.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	public BinaryTree(String value)
	{
		this.value = Integer.parseInt(value);
	}
	
	public static BinaryTree create(String input)
	{
		if (input == null || input.equals(""))
		{
			return null;
		}
		
		String value = getValue(0, input);
		BinaryTree root = new BinaryTree(value);
		build(root, value.length(), input, input.length() - 2, new HashMap<>());
		return root;
	}
	
	private static void build(BinaryTree currentNode, int i, String s, int lastIndex, Map<Integer, BinaryTree> parents)
	{
		if (i > lastIndex)
		{
			return;
		}
	
		int start = i + 1;
		
		if (s.charAt(i) == '(') // found left node
		{
			int end = i + 3;
			String left = getValue(start, s);
			currentNode.setLeft(left);
			parents.put(currentNode.getLeft().getValue(), currentNode);
			if (s.charAt(start + left.length()) == ')' && lastIndex > end) // found right so go back up a level by returning parent
			{
				int rightEnd = setRight(end + left.length(), s, currentNode, parents);
				build(currentNode, rightEnd, s, lastIndex, parents);
			}
			else // find next child
			{
				build(currentNode.getLeft(), start + left.length(), s, lastIndex, parents);
			}
		}
		else
		{
			if (s.charAt(i) == ')' && s.charAt(start) == '(') // found right node for parent
			{
				int rightEnd = setRight(i + 2, s, currentNode, parents);
				build(currentNode.getRight(), rightEnd, s, lastIndex, parents); // add to right node
			}
			else
			{
				build(parents.get(currentNode.getValue()), start, s, lastIndex, parents);
			}
		}
	}
	
	private static int setRight(int i, String s, BinaryTree node, Map<Integer, BinaryTree> ancestors)
	{
		String right = getValue(i, s);
		node.setRight(right);
		ancestors.put(node.getRight().getValue(), node);
		return i + right.length();
	}
	
	private static String getValue(int start, String s)
	{
		int leftStart = s.indexOf('(', start);
		int rightStart = s.indexOf(')', start);
		int end = leftStart > 0 ? Math.min(leftStart, rightStart) : rightStart;
		return s.substring(start, end > 0 ? end : 1);
	}
	
	private void setLeft(String left)
	{
		this.left = new BinaryTree(left);
	}
	
	private void setRight(String right)
	{
		this.right = new BinaryTree(right);
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
