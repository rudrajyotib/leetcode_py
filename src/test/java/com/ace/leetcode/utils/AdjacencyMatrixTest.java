package com.ace.leetcode.utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AdjacencyMatrixTest
{
	@Test
	public void shouldPrint()
	{
		AdjacencyMatrix.print(AdjacencyMatrix.multiply(new int[][]{{0, 0, 1}, {0, 0, 1}, {1, 0, 0}}));
	}
	@Test
	public void shouldReturnFurthestPath()
	{
		assertEquals(new int[][]{{1, 0, 0}, {1, 0, 0}, {0, 0, 1}}, AdjacencyMatrix.multiply(AdjacencyMatrix.multiply(new int[][]{{0, 0, 1}, {0, 0, 1}, {1, 0, 0}})));
		assertEquals(new int[][]{{1, 1, 0}, {0, 0, 0}, {0, 0, 1}}, AdjacencyMatrix.multiply(AdjacencyMatrix.multiply(new int[][]{{0, 0, 1}, {0, 0, 0}, {1, 1, 0}})));
		assertEquals(new int[][]{{0, 1, 0}, {0, 1, 0}, {0, 0, 1}}, AdjacencyMatrix.multiply(AdjacencyMatrix.multiply(new int[][]{{0, 0, 1}, {0, 0, 1}, {0, 1, 0}})));
	}
	
	@Test
	public void shouldReturnTotalNumberOfPathsBetweenNodes()
	{
		assertEquals(new int[][]{{1, 2, 2, 6, 1}, {1, 0, 4, 3, 2}, {3, 0, 2, 3, 3}, {1, 1, 4, 5, 2}, {1, 1, 1, 3, 1}}, AdjacencyMatrix.multiply(AdjacencyMatrix.multiply(new int[][]{{0, 1, 0, 1, 0}, {0, 0, 1, 0, 1}, {1, 0, 0, 0, 1}, {0, 0, 1, 1, 0}, {0, 0, 0, 1, 0}})));
	}
}
