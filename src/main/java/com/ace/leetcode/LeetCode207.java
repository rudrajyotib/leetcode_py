package com.ace.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode207
{
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
