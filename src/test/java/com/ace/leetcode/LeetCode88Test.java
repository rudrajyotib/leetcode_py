package com.ace.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LeetCode88Test
{
	@Test
	public void shouldMergeSortedArrays()
	{
		//1,2,2,3,5,6
		int[] arr = new int[]{1, 2, 2, 3, 5, 6};
		LeetCode88.mergeSortedArrays(arr, 3, new int[]{2, 5, 6}, 3);
		assertEquals(1, arr[0]);
		assertEquals(6, arr[5]);
	}
}
