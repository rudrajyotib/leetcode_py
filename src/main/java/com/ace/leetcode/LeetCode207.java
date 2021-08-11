package com.ace.leetcode;

import java.util.HashSet;
import java.util.Set;

import static java.lang.String.format;

public class LeetCode207
{
	public static boolean solution(int[][] courses)
	{
		Set<String> uniqueCourses = new HashSet<>();
		for (int[] course : courses)
		{
			if (uniqueCourses.contains(format("%s,%s", course[1], course[0])))
			{
				return false;
			}
			uniqueCourses.add(format("%s,%s", course[0], course[1]));
			
		}
		return true;
	}
}
