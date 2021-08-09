package com.ace.leetcode;

import org.apache.commons.lang3.tuple.Pair;

import java.util.HashSet;
import java.util.Set;

public class LeetCode1466
{
	public static int calculateRoute(int n, int[][] connections)
	{
		int destinationNode = 0;
		int rerouteCount = 0;
		int currentNeighbour = destinationNode;
		for (int[] connection : connections)
		{
			if (connection[0] == currentNeighbour)
			{
				currentNeighbour = connection[1];
				rerouteCount += 1;
			}
			else
			{
				currentNeighbour = connection[0];
			}
			
		}
		
		return rerouteCount;
	}
}
