package com.ace.leetcode;

import java.util.HashMap;
import java.util.Map;

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
		for (Integer value : a1.get(s).values())
		{
			if (value == null)
			{
				return -1;
			}
			highest = highest != null ? Math.max(highest, value) : value;
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
			if (s != end) // ignore route to self because we only want routes away from self
			{
				if (a0.containsKey(start))
				{
					Map<Integer, Integer> neighbour = a0.get(start);
					neighbour.put(end, edge[2]);
				}
				else
				{
					Map<Integer, Integer> neighbour = new HashMap<>();
					neighbour.put(start, 0);
					neighbour.put(end, edge[2]);
					a0.put(start, neighbour);
				}
			}
		}
		int count = 1;
		Map<Integer, Integer> row1 = a0.get(1);
		for (Map<Integer, Integer> values : a0.values())
		{
			values.put(1, row1.getOrDefault(count, null));
			count += 1;
		}
		
		return a0;
	}
	
	public static int networkDelayTimeViaDijkstra(int[][] edges, int n, int k)
	{
		Map<Integer, Vertex> graph = new HashMap<>();
		for (int i = 1; i < n; i++)
		{
			normalise(edges, graph, k);
		}
		
		if (graph.size() == n - 1)
		{
			return calculateMaxTime(graph);
		}
		else
		{
			return -1;
		}
	}
	
	private static void normalise(int[][] edges, Map<Integer, Vertex> graph, int root)
	{
		int start = graph.size() > 0 ? getLowestUnselectedNode(graph) : root; // Select the lowest vertex
		for (int[] edge : edges)
		{
			int neighbour = edge[1];
			if (start == edge[0] && neighbour != root) // For all connections from selected vertex but ignore opposite connections
			{
				int distanceToNeighbour = edge[2];
				int currentTime = graph.containsKey(start) ? distanceToNeighbour + graph.get(start).value : distanceToNeighbour; // Distance from current value
				
				if (graph.containsKey(neighbour)) // recalculate distance by setting the lowest
				{
					Vertex time = graph.get(neighbour);
					time.setValue(Math.min(time.value, currentTime));
					graph.put(neighbour, time);
				}
				else
				{
					graph.put(neighbour, new Vertex(false, currentTime));
				}
			}
		}
	}
	
	private static int getLowestUnselectedNode(Map<Integer, Vertex> grid)
	{
		// Select the lowest unselected node
		int currentMinNode = 0;
		Integer currentMinTime = null;
		for (int node : grid.keySet())
		{
			Vertex vertex = grid.get(node);
			if (!vertex.visited)
			{
				if (currentMinTime == null)
				{
					currentMinTime = vertex.value;
					currentMinNode = node;
				}
				
				if ((vertex.value < currentMinTime || vertex.value == currentMinTime))
				{
					currentMinTime = vertex.value;
					currentMinNode = node;
				}
			}
		}
		Vertex time = grid.get(currentMinNode);
		time.setVisited(true);
		return currentMinNode;
	}
	
	private static int calculateMaxTime(Map<Integer, Vertex> connectionsWithTime)
	{
		int max = 0;
		for (Vertex connection : connectionsWithTime.values())
		{
			max = max > 0 ? Math.max(connection.value, max) : connection.value;
		}
		return max;
	}
	
	private static class Vertex
	{
		private int value;
		private boolean visited;
		
		public Vertex(boolean visited, int time)
		{
			this.visited = visited;
			this.value = time;
		}
		
		public void setVisited(boolean visited)
		{
			this.visited = visited;
		}
		
		public void setValue(int value)
		{
			this.value = value;
		}
	}
}