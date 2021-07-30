package com.ace.leetcode.utils;

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
	
	@Override
	public Integer[] toInorder()
	{
		return toInorderList().toArray(new Integer[0]);
	}
	
	@Override
	public Integer[] toPostorder()
	{
		return toPostorderList().toArray(new Integer[0]);
	}
	
	@Override
	public Integer[] toPreorder()
	{
		return toPreorderList().toArray(new Integer[0]);
	}
}
