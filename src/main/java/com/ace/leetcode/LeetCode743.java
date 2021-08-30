package com.ace.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode743
{
	public static int networkDelayTimeViaDijkstra(int[][] edges, int n, int k)
	{
		Map<Integer, Integer> distanceToK = new HashMap<>();
		boolean[] visited = new boolean[n + 1];
		for (int i = 1; i < n; i++) // for each node
		{
			normalise(edges, distanceToK, visited, k);
		}
		
		if (distanceToK.size() == n - 1)
		{
			Integer[] values = distanceToK.values().toArray(new Integer[0]);
			Arrays.sort(values);
			return values[distanceToK.size() - 1];
		}
		else
		{
			return -1;
		}
	}
	
	private static void normalise(int[][] edges, Map<Integer, Integer> distanceToK, boolean[] visited, int root)
	{
		int currentNode = getLowestUnselectedNode(distanceToK, visited, root);
		for (int[] edge : edges)
		{
			int neighbour = edge[1];
			if (currentNode == edge[0] && neighbour != root) // For all connections from selected vertex but ignore opposite connections
			{
				int distanceToNeighbour = edge[2];
				
				// recalculate distance via current node
				int currentTime = distanceToK.containsKey(currentNode) ? distanceToNeighbour + distanceToK.get(currentNode) : distanceToNeighbour;
				
				if (distanceToK.containsKey(neighbour)) // recalculate distance by setting the lowest
				{
					distanceToK.put(neighbour, Math.min(distanceToK.get(neighbour), currentTime));
				}
				else
				{
					distanceToK.put(neighbour, currentTime);
				}
			}
		}
		visited[currentNode] = true;
	}
	
	private static int getLowestUnselectedNode(Map<Integer, Integer> distanceToK, boolean[] visited, int root)
	{
		if (distanceToK.size() != 0)
		{
			int minNode = 0;
			Integer minValue = null;
			for (int node : distanceToK.keySet())
			{
				if (!visited[node])
				{
					int value = distanceToK.get(node);
					if (minValue != null)
					{
						if (minValue > value)
						{
							minNode = node;
							minValue = value;
						}
					}
					else
					{
						minNode = node;
						minValue = value;
					}
				}
			}
			return minNode;
		}
		else
		{
			return root;
		}
	}
}