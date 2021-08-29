package com.ace.leetcode.utils;

import java.util.Stack;

public class TreeNode
{
	public int val;
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode(int x)
	{
		val = x;
	}
	
	public static TreeNode build(String s)
	{
		if (s == null || s.equals(""))
		{
			return null;
		}
		String value = getValue(0, s);
		TreeNode root = new TreeNode(Integer.parseInt(value));
		root.add(root, s, value.length());
		return root;
	}
	
	public TreeNode add(TreeNode root, String s, int index)
	{
		Stack<TreeNode> nodes = new Stack<>();
		nodes.push(root);
		for (int i = index; i < s.length(); i++)
		{
			if (s.charAt(i) == '(') // found left node
			{
				int start = i + 1;
				String left = getValue(start, s);
				TreeNode node = create(left);
				TreeNode currentNode = nodes.peek();
				if (currentNode.left == null)
				{
					currentNode.left = node;
				}
				else
				{
					currentNode.right = node;
				}
				nodes.push(node);
				i = i + left.length();
			}
			else
			{
				nodes.pop();
			}
		}
		return nodes.peek();
	}
	
	protected TreeNode create(String value)
	{
		return new TreeNode(Integer.parseInt(value));
	}
	
	private static String getValue(int start, String s)
	{
		int leftStart = s.indexOf('(', start);
		int rightStart = s.indexOf(')', start);
		int end = leftStart > 0 ? Math.min(leftStart, rightStart) : rightStart;
		return s.substring(start, end > 0 ? end : 1);
	}
}
