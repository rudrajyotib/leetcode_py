package com.ace.leetcode.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph<E>
{
	private final Map<Vertex<E>, List<Vertex<E>>> matrix;
	
	public Graph()
	{
		this.matrix = new HashMap<>();
	}
	
	public void addDirectedEdge(E label1, E label2)
	{
		Vertex<E> l1 = new Vertex<>(label1);
		Vertex<E> l2 = new Vertex<>(label2);
		matrix.putIfAbsent(l1, new ArrayList<>());
		matrix.putIfAbsent(l2, new ArrayList<>());
		matrix.get(l1).add(l2);
	}
	
	public void addUndirectedEdge(E label1, E label2)
	{
		Vertex<E> l1 = new Vertex<>(label1);
		Vertex<E> l2 = new Vertex<>(label2);
		matrix.putIfAbsent(l1, new ArrayList<>());
		matrix.putIfAbsent(l2, new ArrayList<>());
		matrix.get(l1).add(l2);
		matrix.get(l2).add(l1);
	}
	
	public int size()
	{
		return matrix.size();
	}
	
	public int edges()
	{
		int edges = 0;
		for (Vertex<E> vertex : matrix.keySet())
		{
			List<Vertex<E>> connections = matrix.get(vertex);
			for (Vertex<E> connection : connections)
			{
				System.out.printf("Vertex: %s > %s%n", vertex.label, connection.label);
				edges += 1;
			}
		}
		return edges;
	}
	
	public int countUndirectedPathsFromRoot(E label)
	{
		Vertex<E> root = new Vertex<>(label);
		int count = 0;
		List<Vertex<E>> visited = new ArrayList<>();
		count = countUndirectedPathsFromRoot(root, root, visited, count);
		count = countUndirectedPathsToRoot(root, visited, count);
		
		return count;
	}
	
	private int countUndirectedPathsToRoot(Vertex<E> root, List<Vertex<E>> visited, int count)
	{
		List<Vertex<E>> connections = getSourcesByTarget(root); // count in nodes
		for (Vertex<E> connection : connections)
		{
			count = countUndirectedPathsFromRoot(root, connection, visited, count);
		}
		return count;
	}
	
	private int countUndirectedPathsFromRoot(Vertex<E> root, Vertex<E> source, List<Vertex<E>> visited, int count)
	{
		List<Vertex<E>> connections = matrix.get(source);
		if (connections.isEmpty() && !visited.contains(source))
		{
			count = countUndirectedPathsToRoot(source, visited, count);
		}
		else
		{
			for (Vertex<E> connection : connections)
			{
				if (!root.label.equals(connection.label))
				{
					visited.add(connection);
					count = countUndirectedPathsFromRoot(root, connection, visited, count + 1);
				}
			}
		}
		
		return count;
	}
	
	private List<Vertex<E>> getSourcesByTarget(Vertex<E> targetKey)
	{
		List<Vertex<E>> connectionsForSource = new ArrayList<>();
		for (Vertex<E> source : matrix.keySet())
		{
			for (Vertex<E> target : matrix.get(source))
			{
				if (target.label.equals(targetKey.label))
				{
					connectionsForSource.add(source);
				}
			}
		}
		return connectionsForSource;
	}
	
	public static class Vertex<E>
	{
		private final E label;
		
		public Vertex(E label)
		{
			this.label = label;
		}
		
		@Override
		public int hashCode()
		{
			return label.hashCode();
		}
		
		@Override
		public boolean equals(Object o)
		{
			if (o == null)
			{
				return false;
			}
			if (!(o instanceof Vertex))
			{
				return false;
			}
			if (o == this)
			{
				return true;
			}
			return ((Vertex<?>) o).label.equals(this.label);
		}
	}
}
