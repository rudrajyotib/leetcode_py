package com.ace.leetcode;

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
	
	public static class TreeNode
	{
		public int val;
		public TreeNode left;
		public TreeNode right;
		
		TreeNode(int val, TreeNode left, TreeNode right)
		{
			this.val = val;
			this.left = left;
			this.right = right;
		}
		
		public static TreeNode create(Integer[] nums)
		{
			return build(nums, 0, nums.length - 1);
		}
		
		private static TreeNode build(Integer[] nums, int i, int size)
		{
			if (i > size || nums[i] == null)
			{
				return null;
			}
			//27,null,34,null,58,50,null,44
			TreeNode leftNode = build(nums, i * 2 + 1, size);
			TreeNode rightNode = build(nums, i * 2 + 2, size);
			return new TreeNode(nums[i], leftNode, rightNode);
		}
	}
}
