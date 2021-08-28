package com.ace.leetcode;

import com.ace.leetcode.utils.BinaryTree;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class LeetCode109Test
{
	@Test
	public void shouldCreateBinaryTreeFromSortedList()
	{
		BinaryTree root = LeetCode109.create(new int[]{-10, -3, 0, 5, 9});
		assertThat(root.getValue(), is(0));
		assertThat(root.getLeft().getValue(), is(-10));
		assertThat(root.getRight().getValue(), is(5));
	}
}
