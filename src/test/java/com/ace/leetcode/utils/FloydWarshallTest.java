package com.ace.leetcode.utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FloydWarshallTest
{
	@Test
	public void shouldReturnShortestPathBetweenEveryNode()
	{
		Integer[][] result = FloydWarshall.calculate(new int[][]{{3, 1, 4}, {1, 4, 1}, {1, 2, 8}, {4, 2, 2}, {4, 3, 9}, {2, 3, 1}}, 4);
		
		assertEquals(0, result[1][1].intValue());
		assertEquals(3, result[1][2].intValue());
		assertEquals(4, result[1][3].intValue());
		assertEquals(1, result[1][4].intValue());
		
		assertEquals(5, result[2][1].intValue());
		assertEquals(0, result[2][2].intValue());
		assertEquals(1, result[2][3].intValue());
		assertEquals(6, result[2][4].intValue());
		
		assertEquals(4, result[3][1].intValue());
		assertEquals(7, result[3][2].intValue());
		assertEquals(0, result[3][3].intValue());
		assertEquals(5, result[3][4].intValue());
		
		assertEquals(7, result[4][1].intValue());
		assertEquals(2, result[4][2].intValue());
		assertEquals(3, result[4][3].intValue());
		assertEquals(0, result[4][4].intValue());
	}
}