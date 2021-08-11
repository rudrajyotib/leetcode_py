package com.ace.leetcode;

import java.util.*;

public class LeetCode207
{
	public static int[] findOrder(int[][] prerequisites)
	{
		List<Integer> schedule = new ArrayList<>();
		for (int[] course : prerequisites)
		{
			if (course.length > 0)
			{
				if (!schedule.contains(course[1]))
				{
					schedule.add(course[1]);
				}
				if (!schedule.contains(course[0]))
				{
					schedule.add(course[0]);
				}
			}
		}
		if (schedule.size() == 0)
		{
			return new int[]{};
		}
		return schedule.stream().mapToInt(Number::intValue).toArray();
	}
	
	public static boolean solution(int[][] prerequisites)
	{
		Map<Integer, Set<Integer>> courses = new HashMap<>();
		for (int[] course : prerequisites)
		{
			Set<Integer> dependency = new HashSet<>();
			dependency.add(course[1]);
			
			if (dfs(courses, course[0], dependency))
			{
				if (courses.get(course[0]) != null)
				{
					Set<Integer> dependencies = courses.get(course[0]);
					dependencies.add(course[1]);
				}
				else
				{
					courses.put(course[0], dependency);
				}
			}
			else
			{
				return false;
			}
		}
		return true;
	}
	
	private static boolean dfs(Map<Integer, Set<Integer>> courses, int source, Set<Integer> dependencies)
	{
		if (dependencies == null)
		{
			return true;
		}
		if (dependencies.contains(source))
		{
			return false;
		}
		for (Integer dependent : dependencies)
		{
			return dfs(courses, source, courses.get(dependent));
		}
		return true;
	}
}
