package com.ace.leetcode;

public class LeetCode912
{
	public static Integer[] sort(Integer[] nums)
	{
		int size = nums.length;
		for (int i = 0; i < size; i++)
		{
			int smallestIndex = i;
			for (int j = i + 1; j < size; j++)
			{
				if (nums[j] < nums[smallestIndex])
				{
					smallestIndex = j;
				}
			}
			int smallest = nums[smallestIndex];
			nums[smallestIndex] = nums[i];
			nums[i] = smallest;
		}
		return nums;
	}
}
