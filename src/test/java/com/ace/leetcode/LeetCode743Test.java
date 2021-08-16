package com.ace.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LeetCode743Test
{
	@Test
	public void shouldReturnNetworkDelayTime3()
	{
		assertEquals(30, LeetCode743.networkDelayTimeViaDijkstra(new int[][]{{1, 5, 66}, {3, 5, 55}, {4, 3, 29}, {1, 2, 9}, {3, 4, 10}, {3, 1, 3}, {2, 3, 78}, {1, 4, 98}, {4, 5, 21}, {5, 2, 19}, {5, 1, 76}, {4, 1, 65}, {3, 2, 27}, {5, 3, 23}, {5, 4, 12}, {2, 1, 36}, {4, 2, 75}, {2, 4, 11}, {1, 3, 30}, {2, 5, 8}}, 5, 1));
	}
	
	@Test
	public void shouldReturnNetworkDelayTime1()
	{
		assertEquals(31, LeetCode743.networkDelayTimeViaDijkstra(new int[][]{{3, 5, 78}, {2, 1, 1}, {1, 3, 0}, {4, 3, 59}, {5, 3, 85}, {5, 2, 22}, {2, 4, 23}, {1, 4, 43}, {4, 5, 75}, {5, 1, 15}, {1, 5, 91}, {4, 1, 16}, {3, 2, 98}, {3, 4, 22}, {5, 4, 31}, {1, 2, 0}, {2, 5, 4}, {4, 2, 51}, {3, 1, 36}, {2, 3, 59}}, 5, 5));
	}
	
	@Test
	public void shouldReturnNetworkDelayTime2()
	{
		assertEquals(3, LeetCode743.networkDelayTimeViaDijkstra(new int[][]{{1, 2, 1}, {2, 1, 3}}, 2, 2));
		assertEquals(1, LeetCode743.networkDelayTimeViaDijkstra(new int[][]{{1, 2, 1}}, 2, 1));
		assertEquals(2, LeetCode743.networkDelayTimeViaDijkstra(new int[][]{{1, 2, 1}, {2, 3, 2}, {1, 3, 2}}, 3, 1));
		assertEquals(-1, LeetCode743.networkDelayTimeViaDijkstra(new int[][]{{1, 2, 1}}, 2, 2));
		assertEquals(6, LeetCode743.networkDelayTimeViaDijkstra(new int[][]{{1, 2, 1}, {2, 3, 7}, {1, 3, 4}, {2, 1, 2}}, 3, 2));
		assertEquals(2, LeetCode743.networkDelayTimeViaDijkstra(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2));
		assertEquals(2, LeetCode743.networkDelayTimeViaDijkstra(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2));
		assertEquals(3, LeetCode743.networkDelayTimeViaDijkstra(new int[][]{{1, 2, 1}, {2, 3, 2}, {1, 3, 4}}, 3, 1));
	}
}
