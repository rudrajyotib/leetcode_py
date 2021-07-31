package com.ace.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode886
{
	public static boolean partition(int n, int[][] dislikes)
	{
		Map<Integer, Set<Integer>> adjacencyMatrix = new HashMap<>();
		for (int[] dislike : dislikes)
		{
			int a = dislike[0];
			int b = dislike[1];
			adjacencyMatrix.putIfAbsent(a, new HashSet<>());
			adjacencyMatrix.putIfAbsent(b, new HashSet<>());
			adjacencyMatrix.get(a).add(b);
			adjacencyMatrix.get(b).add(a);
		}
		
		Set<Integer> table1 = new HashSet<>();
		table1.add(1);
		Set<Integer> table2 = new HashSet<>(adjacencyMatrix.get(1));
		for (int i = 2; i < n; i++)
		{
			Set<Integer> dislikesOfI = adjacencyMatrix.get(i);
			if (table2.contains(i) && isTableCompatibleWithDislikes(table2, dislikesOfI))
			{
				table1.addAll(dislikesOfI);
			}
			else if (table1.contains(i) && isTableCompatibleWithDislikes(table1, dislikesOfI))
			{
				table2.addAll(dislikesOfI);
			}
			else
			{
				return false;
			}
		}
		return true;
	}
	
	private static boolean isTableCompatibleWithDislikes(Set<Integer> table, Set<Integer> dislikes)
	{
		for (Integer dislike : dislikes)
		{
			if (table.contains(dislike))
			{
				return false;
			}
		}
		return true;
	}
}
