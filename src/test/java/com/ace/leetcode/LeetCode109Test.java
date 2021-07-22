package com.ace.leetcode;

import com.ace.leetcode.utils.BinaryTree;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class LeetCode109Test
{
	@Test
	public void shouldCreateBinaryTreeSortedList()
	{
		BinaryTree root = LeetCode109.create(new int[]{-10, -3, 0, 5, 9});
		assertThat(root.getValue(), is(0));
		assertThat(root.getLeft().getValue(), is(-10));
		assertThat(root.getRight().getValue(), is(5));
	}
}
