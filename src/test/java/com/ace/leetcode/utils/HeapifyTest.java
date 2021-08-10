package com.ace.leetcode.utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class HeapifyTest
{
	@Test
	public void shouldConvertArrayToMaxHeapWithSet1()
	{
		BinaryTree root = Heapify.toMaxHeap(new int[]{4, 10, 3, 5, 1});
		assertEquals(10, root.getValue());
		assertEquals(5, root.getLeft().getValue());
		assertEquals(4, root.getLeft().getLeft().getValue());
		assertEquals(1, root.getLeft().getRight().getValue());
		assertNull(root.getLeft().getLeft().getLeft());
		assertNull(root.getLeft().getRight().getRight());
		
		assertEquals(3, root.getRight().getValue());
		assertNull(root.getRight().getLeft());
		assertNull(root.getRight().getRight());
	}
}
