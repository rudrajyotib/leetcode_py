package com.ace.leetcode.utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class GraphTest
{
	@Test
	public void shouldCreateDirectedGraph()
	{
		Graph<Integer> graph = new Graph<>();
		graph.addDirectedEdge(0, 1);
		graph.addDirectedEdge(1, 3);
		graph.addDirectedEdge(2, 3);
		graph.addDirectedEdge(4, 0);
		graph.addDirectedEdge(4, 5);
		
		assertEquals(6, graph.size());
		assertEquals(5, graph.edges());
	}
	
	@Test
	public void shouldCreateUndirectedGraph()
	{
		Graph<Integer> graph = new Graph<>();
		graph.addUndirectedEdge(0, 1);
		graph.addUndirectedEdge(1, 3);
		graph.addUndirectedEdge(2, 3);
		graph.addUndirectedEdge(4, 0);
		graph.addUndirectedEdge(4, 5);
		
		assertEquals(6, graph.size());
		assertEquals(10, graph.edges());
	}
	
	@Test
	public void shouldCreateGraphVertex()
	{
		Graph.Vertex<Integer> v0 = new Graph.Vertex<>(0);
		Graph.Vertex<Integer> v1 = new Graph.Vertex<>(0);
		Graph.Vertex<Integer> v2 = new Graph.Vertex<>(1);
		assertEquals(v0, v1);
		assertEquals(v0, v0);
		assertNotEquals(v1, v2);
		assertNotEquals(v1, null);
		assertNotEquals(v1, new StringBuilder());
		
		assertEquals(0, v0.hashCode());
		assertEquals(1, v2.hashCode());
	}
}