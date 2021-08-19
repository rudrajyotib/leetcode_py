package com.ace.leetcode.utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TreesAndHeapsTest
{
	@Test
	public void shouldConvertFromAndToArray()
	{
		Integer[] expectedValues = new Integer[]{2, 3, 4, 5, 6, 7, null, null, null, 8};
		BinaryTree root = TreesAndHeaps.createFromArray(expectedValues);
		assertEquals(2, root.getValue());
		assertEquals(7, root.getRight().getLeft().getValue());
		
		Integer[] actualValues = TreesAndHeaps.convertTreeToArray(root);
		assertEquals(2, actualValues[0].intValue());
		assertEquals(7, actualValues[5].intValue());
		assertNull(actualValues[6]);
		assertNull(actualValues[7]);
		assertNull(actualValues[8]);
		assertEquals(8, actualValues[9].intValue());
	}
	
	@Test
	public void shouldConvertToMaxHeap()
	{
		int[] args = new int[]{50, 15, 16, 30, 10, 8, 20};
		TreesAndHeaps.heapify(args);
		assertEquals(50, args[0]);
		assertEquals(30, args[1]);
		assertEquals(20, args[2]);
		assertEquals(15, args[3]);
		assertEquals(10, args[4]);
		assertEquals(8, args[5]);
		assertEquals(16, args[6]);
	}
	
	@Test
	public void shouldInsertToHeap()
	{
		int[] args = new int[]{50, 30, 20, 15, 10, 8, 16};
		int[] actual = TreesAndHeaps.insert(args, 40);
		assertEquals(50, actual[0]);
		assertEquals(40, actual[1]);
		assertEquals(30, actual[3]);
		assertEquals(16, actual[6]);
		assertEquals(15, actual[7]);
	}
}
