package com.ace.leetcode.utils;

public class Fibonacci
{
	public static int getNumber(int n)
	{
		int[] fibs = new int[n + 1];
		fibs[0] = 0;
		fibs[1] = 1;
		for (int i = 2; i < n + 1; i++)
		{
			fibs[i] = fibs[i - 2] + fibs[i - 1];
		}
		
		return fibs[fibs.length - 1];
	}
}
