package com.ace.leetcode;

import com.ace.leetcode.utils.BinaryTree;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class LeetCode105Test
{
	@Test
	public void shouldCreateBinaryTreeFromArray()
	{
		/*
		 * Always get node values from the preorder array.
		 * But cannot search beyond the index of where the root is in the inorder array.
		 * Preorder tells us 3 is the root node and 3 is in index 1 of inorder.
		 * Therefore left's children must be within 0-1 index of preorder array.
		 * But left is in index 1 hence left node cannot have children.
		 * Everything to the right of 3 in inorder are right nodes' child nodes.
		 */
		
		
		BinaryTree root = LeetCode105.create(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
		assertEquals(root.getValue(), 3);
		assertEquals(root.getLeft().getValue(), 9);
		assertEquals(root.getRight().getValue(), 20);
		assertNull(root.getLeft().getLeft());
		assertNull(root.getLeft().getRight());
		assertEquals(root.getRight().getLeft().getValue(), 15);
		assertEquals(root.getRight().getRight().getValue(), 7);
		
		assertEquals(BinaryTree.toInorder(root), new Integer[]{9, 3, 15, 20, 7});
		assertEquals(BinaryTree.toPreorder(root), new Integer[]{3, 9, 20, 15, 7});
	}
	
	@Test
	public void shouldCreateBinaryTreeSingleValue()
	{
		BinaryTree root = LeetCode105.create(new int[]{-1}, new int[]{-1});
		assertEquals(root.getValue(), -1);
		assertNull(root.getLeft());
		assertNull(root.getRight());
	}
}