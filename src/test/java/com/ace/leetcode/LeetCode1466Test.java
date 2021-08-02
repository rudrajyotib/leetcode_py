package com.ace.leetcode;

import com.ace.leetcode.utils.Graph;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LeetCode1466Test
{
	@Test
	public void shouldReorderRoutesToMakeAllPathsLeadToTargetWithTwoRoutes()
	{
		Graph<Integer> graph = new Graph<>();
		graph.addDirectedEdge(0, 1);
		graph.addDirectedEdge(1, 3);
		graph.addDirectedEdge(2, 3);
		graph.addDirectedEdge(4, 0);
		graph.addDirectedEdge(4, 5);
		
		assertEquals(3, graph.countUndirectedPathsFromRoot(0));
	}
	
	@Test
	public void shouldReorderRoutesToMakeAllPathsLeadToTargetWithSingleRoute()
	{
		Graph<Integer> graph = new Graph<>();
		graph.addDirectedEdge(1, 0);
		graph.addDirectedEdge(1, 2);
		graph.addDirectedEdge(3, 2);
		graph.addDirectedEdge(3, 4);
		
		assertEquals(2, graph.countUndirectedPathsFromRoot(0));
	}
	
	@Test
	public void shouldReorderRoutesToMakeAllPathsLeadToTargetWithZeroRoute()
	{
		Graph<Integer> graph = new Graph<>();
		graph.addDirectedEdge(1, 0);
		graph.addDirectedEdge(2, 0);
		
		assertEquals(0, graph.countUndirectedPathsFromRoot(0));
	}
}
