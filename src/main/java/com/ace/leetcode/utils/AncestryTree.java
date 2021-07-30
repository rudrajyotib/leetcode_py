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
	
	@Override
	public String[] toInorder()
	{
		return toInorderList().toArray(new String[0]);
	}
	
	@Override
	public String[] toPreorder()
	{
		return toPreorderList().toArray(new String[0]);
	}
	
	@Override
	public String[] toPostorder()
	{
		return toPostorderList().toArray(new String[0]);
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
		Stack<AncestryTree> nodes = new Stack<>();
		nodes.push(this);
		while (!nodes.empty())
		{
			AncestryTree node = nodes.pop();
			if (node.value.equals(descendant))
			{
				return node;
			}
			if (node.left != null)
			{
				nodes.push(node.left);
			}
			if (node.right != null)
			{
				nodes.push(node.right);
			}
		}
		return null;
	}
	
	public AncestryTree getDescendants(String ancestor)
	{
		//TODO
		return null;
	}
}
