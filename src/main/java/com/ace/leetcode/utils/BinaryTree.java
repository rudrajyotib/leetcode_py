package com.ace.leetcode.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTree extends Node<Integer, BinaryTree>
{
	public BinaryTree(String value)
	{
		this(Integer.parseInt(value));
	}
	
	public BinaryTree(int value)
	{
		super(value);
	}
	
	public BinaryTree(int value, BinaryTree left, BinaryTree right)
	{
		this(value);
		this.left = left;
		this.right = right;
	}
	
	@Override
	protected BinaryTree create(String value)
	{
		return new BinaryTree(value);
	}
	
	public static BinaryTree build(String s)
	{
		if (s == null || s.equals(""))
		{
			return null;
		}
		Stack<Node<Integer, BinaryTree>> descendants = new Stack<>();
		String value = getValue(0, s);
		BinaryTree root = new BinaryTree(value);
		root.add(root, value.length(), s, s.length() - 2, descendants);
		return root;
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
