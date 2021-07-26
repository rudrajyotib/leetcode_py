package com.ace.leetcode.utils;

import com.ace.leetcode.LeetCode536;
import org.junit.Before;
import org.junit.Test;

import static com.ace.leetcode.utils.BinaryTree.*;
import static org.junit.Assert.assertEquals;

public class BinaryTreeTest
{
	private BinaryTree testNode;
	
	@Before
	public void setup()
	{
		testNode = BinaryTree.create("4(2(3)(1))(6(5))");
	}
	
	@Test
	public void shouldCreateTreeFromString()
	{
		assertEquals(toPreorder(create("4(2(3)(1))(6(5))")), new Integer[]{4, 2, 3, 1, 6, 5});
		assertEquals(toPreorder(create("4(2)")), new Integer[]{4, 2});
		assertEquals(toPreorder(create("4")), new Integer[]{4});
	}
	
	@Test
	public void shouldConvertToPreorderList()
	{
		assertEquals(toPreorder(testNode), new Integer[]{4, 2, 3, 1, 6, 5});
	}
	
	@Test
	public void shouldConvertToInorderList()
	{
		assertEquals(toInorder(testNode), new Integer[]{3, 2, 1, 4, 5, 6});
	}
	
	@Test
	public void shouldConvertToPostorderList()
	{
		assertEquals(toPostorder(testNode), new Integer[]{3, 1, 2, 5, 6, 4});
	}
}