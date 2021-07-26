package com.ace.leetcode.utils;

import com.ace.leetcode.LeetCode536;
import org.junit.Before;
import org.junit.Test;

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
		assertEquals(BinaryTree.toPreorder(BinaryTree.create("4(2(3)(1))(6(5))")), new Integer[]{4, 2, 3, 1, 6, 5});
	}
	
	@Test
	public void shouldConvertToPreorderList()
	{
	
	}
	
	@Test
	public void shouldConvertToInorderList()
	{
	
	}
	
	@Test
	public void shouldConvertToPostorderList()
	{
	
	}
}