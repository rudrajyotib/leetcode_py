package com.ace.leetcode.utils;

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
}
