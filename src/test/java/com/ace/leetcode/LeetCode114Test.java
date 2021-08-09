package com.ace.leetcode;

import com.ace.leetcode.utils.BinaryTree;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class LeetCode114Test
{
	@Test
	public void shouldConvertBinaryTreeToLinkedList()
	{
		BinaryTree left = new BinaryTree(2, new BinaryTree(3), new BinaryTree(4));
		BinaryTree right = new BinaryTree(5, new BinaryTree(6), null);
		
		BinaryTree root = new BinaryTree(1, left, right);
		LeetCode114.flatten(root);
		
		assertEquals(1, root.getValue());
		assertNull(root.getLeft());
		assertEquals(2, root.getRight().getValue());
		assertEquals(3, root.getRight().getRight().getValue());
		assertEquals(4, root.getRight().getRight().getRight().getValue());
		assertEquals(5, root.getRight().getRight().getRight().getRight().getValue());
		assertEquals(6, root.getRight().getRight().getRight().getRight().getRight().getValue());
	}
	
}