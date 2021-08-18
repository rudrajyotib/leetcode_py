package com.ace.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LeetCode743
{
	public static int networkDelayTimeViaFloydWarshall(int[][] edges, int n, int s)
	{
		Map<Integer, Map<Integer, Integer>> a0 = loadSquaredMatrix(edges, s);
		Map<Integer, Map<Integer, Integer>> a1 = new HashMap<>();
		
		for (int k = 1; k < n + 1; k++)
		{
			for (int i = 1; i < n + 1; i++)
			{
				for (int j = 1; j < n + 1; j++)
				{
					Integer ij = a0.containsKey(i) && a0.get(i).containsKey(j) ? a0.get(i).get(j) : null;
					Integer ik = a0.containsKey(i) && a0.get(i).containsKey(k) ? a0.get(i).get(k) : null;
					Integer kj = a0.containsKey(k) && a0.get(k).containsKey(j) ? a0.get(k).get(j) : null;
					
					Integer x = null;
					
					if (ij != null && ik != null && kj != null)
					{
						x = Math.min(ij, ik + kj);
					}
					
					if (ij == null && ik != null && kj != null)
					{
						x = ik + kj;
					}
					
					if (x != null)
					{
						if (a1.containsKey(i))
						{
							Map<Integer, Integer> a1Values = a1.get(i);
							a1Values.put(j, x);
						}
						else
						{
							Map<Integer, Integer> a1Values = new HashMap<>();
							a1Values.put(j, x);
							a1.put(i, a1Values);
						}
					}
				}
			}
			a0 = a1;
		}
		
		Integer highest = null;
		if (a1.containsKey(s))
		{
			for (Integer value : a1.get(s).values())
			{
				if (value == null)
				{
					return -1;
				}
				highest = highest != null ? Math.max(highest, value) : value;
			}
		}
		return highest != null ? highest : -1;
	}
	
	private static Map<Integer, Map<Integer, Integer>> loadSquaredMatrix(int[][] edges, int s)
	{
		Map<Integer, Map<Integer, Integer>> a0 = new HashMap<>();
		for (int[] edge : edges)
		{
			int start = edge[0];
			int end = edge[1];
			if (s != end) // ignore route to self
			{
				int value = edge[2];
				if (a0.containsKey(start))
				{
					Map<Integer, Integer> neighbours = a0.get(start);
					neighbours.put(end, value);
					addVertical(a0, start, end, value);
				}
				else
				{
					Map<Integer, Integer> neighbours = new HashMap<>();
					neighbours.put(start, 0);
					neighbours.put(end, value);
					a0.put(start, neighbours);
					addVertical(a0, start, end, value);
				}
			}
		}
		return a0;
	}
	
	private static void addVertical(Map<Integer, Map<Integer, Integer>> a0, int start, int end, int value)
	{
		if (a0.containsKey(end))
		{
			a0.get(end).put(start, value);
		}
		else
		{
			Map<Integer, Integer> neighbours = new HashMap<>();
			neighbours.put(end, 0);
			neighbours.put(start, value);
			a0.put(end, neighbours);
		}
	}
	
	public static int networkDelayTimeViaDijkstra(int[][] edges, int n, int k)
	{
		PriorityQueue<NodeValue> nodeValues = new PriorityQueue<>();
		Map<Integer, NodeValue> graph = new HashMap<>();
		for (int i = 1; i < n; i++)
		{
			shorten(edges, graph, nodeValues, k);
		}
		
		if (graph.size() == n - 1)
		{
			NodeValue[] values = graph.values().toArray(new NodeValue[0]);
			Arrays.sort(values);
			return values[values.length - 1].value;
		}
		else
		{
			return -1;
		}
	}
	
	private static void shorten(int[][] edges, Map<Integer, NodeValue> graph, PriorityQueue<NodeValue> nodeValues, int root)
	{
		int start = nodeValues.size() > 0 ? nodeValues.poll().node : root;
		int distanceFromRoot = graph.containsKey(start) ? graph.get(start).value : 0;
		
		for (int[] edge : edges)
		{
			int neighbour = edge[1];
			if (start == edge[0] && neighbour != root) // For all connections from selected node but ignore opposite connections
			{
				int distanceToRootViaCurrentNode = distanceFromRoot + edge[2];
				if (graph.containsKey(neighbour)) // recalculate distance by setting the lowest
				{
					NodeValue nodeValue = graph.get(neighbour);
					int newValue = Math.min(nodeValue.value, distanceToRootViaCurrentNode);
					nodeValue.setValue(newValue);
					graph.put(neighbour, nodeValue);
				}
				else
				{
					NodeValue nodeValue = new NodeValue(neighbour, distanceToRootViaCurrentNode);
					graph.put(neighbour, nodeValue);
					nodeValues.add(nodeValue);
				}
			}
		}
	}
	
	private static class NodeValue implements Comparable<NodeValue>
	{
		private final int node;
		private int value;
		
		private NodeValue(int node, int value)
		{
			this.node = node;
			this.value = value;
		}
		
		private void setValue(int value)
		{
			this.value = value;
		}
		
		@Override
		public int compareTo(NodeValue o)
		{
			int thatValue = o.value;
			return Integer.compare(this.value, thatValue);
		}
	}
}