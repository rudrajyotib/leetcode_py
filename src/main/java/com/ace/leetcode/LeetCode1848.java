package com.ace.leetcode;

public class LeetCode1848
{
	public static int getMinDistance(int[] nums, int target, int start)
	{
		int min = 0;
		Integer minIndex = null;
		for (int i = 0; i < nums.length; i++)
		{
			if (nums[i] == target)
			{
				int diff = Math.abs(i - start);
				if (minIndex != null)
				{
					if (min > diff)
					{
						minIndex = i;
						min = diff;
					}
				}
				else
				{
					minIndex = i;
					min = diff;
				}
			}
		}
		return min;
	}
}
