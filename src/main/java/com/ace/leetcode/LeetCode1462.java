package com.ace.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode1462
{
	public static List<Boolean> checkIfPrerequisiteUsingFloydWarshall(int numCourses, int[][] prerequisites, int[][] queries)
	{
		List<Boolean> result = new ArrayList<>();
		if (prerequisites.length == 0)
		{
			for (int i = 0; i < numCourses; i++)
			{
				result.add(false);
			}
			return result;
		}
		
		Boolean[][] graph = createGraph(numCourses);
		for (int[] prerequisite : prerequisites)
		{
			graph[prerequisite[0]][prerequisite[1]] = true;
		}
		
		for (int k = 0; k < numCourses; k++)
		{
			for (int i = 0; i < numCourses; i++)
			{
				for (int j = 0; j < numCourses; j++)
				{
					if (graph[i][k] != null && graph[k][j] != null && (graph[i][k] && graph[k][j]))
					{
						graph[i][j] = true;
					}
				}
			}
		}
		
		for (int[] query : queries)
		{
			result.add(graph[query[0]][query[1]]);
		}
		
		return result;
	}
	
	private static Boolean[][] createGraph(int numCourses)
	{
		Boolean[][] graph = new Boolean[numCourses][numCourses];
		for (int i = 0; i < numCourses; i++)
		{
			for (int j = 0; j < numCourses; j++)
			{
				if (i == j)
				{
					graph[i][j] = true;
				}
				else
				{
					graph[i][j] = false;
				}
			}
		}
		return graph;
	}
}
