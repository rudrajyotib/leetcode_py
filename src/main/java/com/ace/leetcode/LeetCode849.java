package com.ace.leetcode;

public class LeetCode849
{
	public static int maxDistToClosest(int[] seats)
	{
		int n = seats.length;
		int i, j, res = 0;
		for (i = j = 0; j < n; ++j)
		{
			if (seats[j] == 1)
			{
				if (i == 0)
				{
					res = Math.max(res, j - i);
				}
				else
				{
					res = Math.max(res, (j - i + 1) / 2);
				}
				i = j + 1;
			}
		}
		res = Math.max(res, n - i);
		return res;
	}
}
