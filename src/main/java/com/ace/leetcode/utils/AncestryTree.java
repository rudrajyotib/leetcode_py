package com.ace.leetcode.utils;

import java.util.Stack;

public class AncestryTree extends Node<String, AncestryTree>
{
	private AncestryTree(String name)
	{
		super(name);
	}
	
	@Override
	protected AncestryTree create(String value)
	{
		return new AncestryTree(value);
	}
	
	public String getName()
	{
		return value;
	}
	
	public AncestryTree getFather()
	{
		return left;
	}
	
	public AncestryTree getMother()
	{
		return right;
	}
	
	public static AncestryTree build(String s)
	{
		if (s == null || s.equals(""))
		{
			return null;
		}
		Stack<Node<String, AncestryTree>> descendants = new Stack<>();
		String value = getValue(0, s);
		AncestryTree root = new AncestryTree(value);
		root.add(root, value.length(), s, s.length() - 2, descendants);
		return root;
	}
	
	public AncestryTree getAncestors(String descendant)
	{
		//TODO
		return null;
	}
	
	public AncestryTree getDescendants(String ancestor)
	{
		//TODO
		return null;
	}
}
