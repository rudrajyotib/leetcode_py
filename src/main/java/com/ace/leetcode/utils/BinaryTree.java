package com.ace.leetcode.utils;

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
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		toString(this, sb);
		return sb.toString();
	}
	
	private void toString(BinaryTree node, StringBuilder sb)
	{
		sb.append(node.getValue());
		if (node.left != null)
		{
			sb.append("(");
			toString(node.left, sb);
			sb.append(")");
		}
		if (node.right != null)
		{
			sb.append("(");
			toString(node.right, sb);
			sb.append(")");
		}
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
		String value = getValue(0, s);
		BinaryTree root = new BinaryTree(value);
		root.add(root, s, value.length());
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
	
	public void setLeft(BinaryTree left)
	{
		this.left = left;
	}
	
	public void setRight(BinaryTree right)
	{
		this.right = right;
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
	
	public void setValue(int value)
	{
		this.value = value;
	}
}
