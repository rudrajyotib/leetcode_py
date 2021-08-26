package com.ace.leetcode;

import java.util.*;

public class LeetCode207
{
	public static int[] findOrder(int numCourses, int[][] prerequisites)
	{
		if (numCourses < 2 || prerequisites.length == 0)
		{
			int[] c = new int[numCourses];
			for (int i = 0; i < numCourses; i++)
			{
				c[i] = i;
			}
			return c;
		}
		
		Map<Integer, Set<Integer>> coursesWithPrerequisites = createGraph(prerequisites);
		List<Integer> courseOrder = new ArrayList<>();
		int[] visited = new int[numCourses];
		for (int course : coursesWithPrerequisites.keySet())
		{
			if (hasCircularDependency(visited, course, coursesWithPrerequisites, courseOrder))
			{
				return new int[0];
			}
		}
		
		int[] courseOrderA = new int[numCourses];
		int count = 0;
		for (int i = 0; i < numCourses; i++)
		{
			if (!courseOrder.contains(i))
			{
				courseOrderA[count] = i;
				count++;
			}
		}
		
		for (int course : courseOrder)
		{
			courseOrderA[count] = course;
			count++;
		}
		return courseOrderA;
	}
	
	public static boolean solution(int numCourses, int[][] prerequisites)
	{
		Map<Integer, Set<Integer>> coursesWithPrerequisites = createGraph(prerequisites);
		int[] visited = new int[numCourses];
		for (int course : coursesWithPrerequisites.keySet())
		{
			if (hasCircularDependency(visited, course, coursesWithPrerequisites, null))
			{
				return false;
			}
		}
		
		return true;
	}
	
	private static boolean hasCircularDependency(int[] visited, int course, Map<Integer, Set<Integer>> coursesWithPrerequisites, List<Integer> courseOrder)
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
				if (hasCircularDependency(visited, prerequisite, coursesWithPrerequisites, courseOrder))
				{
					return true;
				}
			}
		}
		visited[course] = 1; // completed loop
		if (courseOrder != null)
		{
			courseOrder.add(course);
		}
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
