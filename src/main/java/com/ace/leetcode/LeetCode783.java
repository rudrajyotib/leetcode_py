package com.ace.leetcode;

import ds.util.TreeNode;

import java.util.Stack;

public class LeetCode783
{
	public static int minDiffInBST(TreeNode root)
	{
		Integer min = null;
		Stack<TreeNode> nodes = new Stack<>();
		nodes.push(root);
		while (!nodes.isEmpty())
		{
			while (!nodes.isEmpty())
			{
				if (min != null && min == 1)
				{
					return min;
				}
				TreeNode node = nodes.pop();
				int curr = minDiffInBSTAgainstAll(root, node);
				min = min != null ? Math.min(min, curr) : curr;
				
				if (node.left != null)
				{
					nodes.push(node.left);
				}
				if (node.right != null)
				{
					nodes.push(node.right);
				}
			}
		}
		return min != null ? min : 0;
	}
	
	private static int minDiffInBSTAgainstAll(TreeNode root, TreeNode target)
	{
		Stack<TreeNode> nodes = new Stack<>();
		nodes.push(root);
		Integer min = null;
		while (!nodes.isEmpty())
		{
			if (min != null && min == 1)
			{
				return min;
			}
			TreeNode node = nodes.pop();
			if (target.val != node.val)
			{
				int diff = Math.abs(target.val - node.val);
				min = min != null ? Math.min(diff, min) : diff;
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
		return min != null ? min : 0;
	}
	

}
