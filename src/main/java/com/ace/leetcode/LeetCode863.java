package com.ace.leetcode;

import com.ace.leetcode.utils.TreeNode;

import java.util.*;

public class LeetCode863
{
	public static List<Integer> distanceK(TreeNode root, TreeNode target, int k)
	{
		Map<TreeNode, TreeNode> parent = new HashMap<>();
		dfs(root, null, parent);
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(null);
		queue.add(target);
		
		Set<TreeNode> seen = new HashSet<>();
		seen.add(target);
		seen.add(null);
		
		int dist = 0;
		while (!queue.isEmpty())
		{
			TreeNode node = queue.poll();
			if (node == null)
			{
				if (dist == k)
				{
					List<Integer> ans = new ArrayList<>();
					for (TreeNode n : queue)
					{
						ans.add(n.val);
					}
					return ans;
				}
				queue.offer(null);
				dist++;
			}
			else
			{
				if (!seen.contains(node.left))
				{
					seen.add(node.left);
					queue.offer(node.left);
				}
				if (!seen.contains(node.right))
				{
					seen.add(node.right);
					queue.offer(node.right);
				}
				TreeNode par = parent.get(node);
				if (!seen.contains(par))
				{
					seen.add(par);
					queue.offer(par);
				}
			}
		}
		
		return new ArrayList<>();
	}
	
	private static void dfs(TreeNode node, TreeNode par, Map<TreeNode, TreeNode> parent)
	{
		if (node != null)
		{
			parent.put(node, par);
			dfs(node.left, node, parent);
			dfs(node.right, node, parent);
		}
	}
}
	
