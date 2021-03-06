package com.ace.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode207
{
	public static boolean solution(int numCourses, int[][] prerequisites)
	{
		Map<Integer, Set<Integer>> coursesWithPrerequisites = createGraph(prerequisites);
		int[] visited = new int[numCourses];
		for (int course : coursesWithPrerequisites.keySet())
		{
			if (hasCircularDependency(visited, course, coursesWithPrerequisites))
			{
				return false;
			}
		}
		
		return true;
	}
	
	private static boolean hasCircularDependency(int[] visited, int course, Map<Integer, Set<Integer>> coursesWithPrerequisites)
	{
		if (visited[course] == -1) // circular
		{
			return true;
		}
		
		if (visited[course] == 1) // already completed loop
		{
			return false;
		}
		
		visited[course] = -1; // visited
		
		if (coursesWithPrerequisites.containsKey(course))
		{
			for (int prerequisite : coursesWithPrerequisites.get(course))
			{
				if (hasCircularDependency(visited, prerequisite, coursesWithPrerequisites))
				{
					return true;
				}
			}
		}
		visited[course] = 1; // completed loop
		return false;
	}
	
	private static Map<Integer, Set<Integer>> createGraph(int[][] prerequisites)
	{
		Map<Integer, Set<Integer>> coursesWithPrerequisites = new HashMap<>();
		
		for (int[] courses : prerequisites)
		{
			int course = courses[0];
			int prerequisite = courses[1];
			if (coursesWithPrerequisites.containsKey(course))
			{
				Set<Integer> dependencies = coursesWithPrerequisites.get(course);
				dependencies.add(prerequisite);
			}
			else
			{
				Set<Integer> dependency = new HashSet<>();
				dependency.add(prerequisite);
				coursesWithPrerequisites.put(course, dependency);
			}
		}
		return coursesWithPrerequisites;
	}
}
