package com.ace.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode1091
{
	private static final int[] X_DIR = new int[]{-1, 0, 1, 1, 1, 0, -1, -1};
	private static final int[] Y_DIR = new int[]{-1, -1, -1, 0, 1, 1, 1, 0};
	
	public static int shortestPathBinaryMatrix(int[][] grid)
	{
		int gridLength = grid.length;
		if (grid[0][0] == 1 || grid[gridLength - 1][gridLength - 1] == 1)
		{
			return -1;
		}
		
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[gridLength][gridLength];
		queue.add(new int[]{0, 0});
		visited[0][0] = true;
		int length = 1;
		while (!queue.isEmpty())
		{
			int size = queue.size();
			for (int j = 0; j < size; j++)
			{
				int[] xy = queue.poll();
				int x = xy[0];
				int y = xy[1];
				
				if (x == gridLength - 1 && y == gridLength - 1)
				{
					return length;
				}
				
				for (int i = 0; i < X_DIR.length; i++) // look at all neighbouring cells
				{
					int newx = x + X_DIR[i];
					int newy = y + Y_DIR[i];
					
					if (newx < gridLength && newx >= 0 && newy < gridLength && newy >= 0 && grid[newx][newy] == 0 && !visited[newx][newy])
					{
						queue.add(new int[]{newx, newy});
						visited[newx][newy] = true;
					}
				}
			}
			length++;
		}
		return -1;
	}
}
