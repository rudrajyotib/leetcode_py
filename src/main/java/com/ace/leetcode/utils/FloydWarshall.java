package com.ace.leetcode.utils;

public class FloydWarshall
{
	public static Integer[][] calculate(int[][] edges, int n)
	{
		int numNodes = n + 1; // as zero is not a node
		Integer[][] matrix = createSquaredMatrix(numNodes);
		for (int[] edge : edges)
		{
			matrix[edge[0]][edge[1]] = edge[2]; // initialise with input
		}
		
		for (int k = 0; k < numNodes; k++) // zero is not a node
		{
			for (int i = 0; i < numNodes; i++)
			{
				for (int j = 0; j < numNodes; j++)
				{
					if (matrix[i][k] != null && matrix[k][j] != null)
					{
						int distanceViaIKAndKJ = matrix[i][k] + matrix[k][j];
						if (matrix[i][j] != null)
						{
							matrix[i][j] = Math.min(distanceViaIKAndKJ, matrix[i][j]);
						}
						else
						{
							matrix[i][j] = distanceViaIKAndKJ;
						}
					}
				}
			}
		}
		return matrix;
	}
	
	private static Integer[][] createSquaredMatrix(int numNodes)
	{
		Integer[][] graph = new Integer[numNodes][numNodes];
		for (int i = 0; i < numNodes; i++)
		{
			for (int j = 0; j < numNodes; j++)
			{
				if (i == j)
				{
					graph[i][j] = 0;
				}
				else
				{
					graph[i][j] = null;
				}
			}
		}
		return graph;
	}
}
