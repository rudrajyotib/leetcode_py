package com.ace.leetcode.utils;

public class AdjacencyMatrix
{
	public static int[][] multiply(int[][] matrix)
	{
		int[][] result = new int[matrix.length][matrix[0].length];
		
		for (int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix[0].length; j++)
			{
				result[i][j] = 0;
				for (int k = 0; k < matrix[0].length; k++)
				{
					result[i][j] += matrix[i][k] * matrix[k][j];
				}
			}
		}
		return result;
	}
	
	public static void print(int[][] matrix)
	{
		for (int[] ints : matrix)
		{
			for (int j = 0; j < matrix[0].length; j++)
			{
				
				System.out.print(ints[j] + " ");
			}
			System.out.println();
		}
	}
}
