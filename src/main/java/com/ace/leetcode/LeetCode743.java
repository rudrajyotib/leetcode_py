package com.ace.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode743
{
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
		int time = 0;
		for (Vertex connection : connectionsWithTime.values())
		{
			if (time == 0)
			{
				time = connection.value;
			}
			else
			{
				time = Math.max(time, connection.value);
			}
		}
		return time;
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