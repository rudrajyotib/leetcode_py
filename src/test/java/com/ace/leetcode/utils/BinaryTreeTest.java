package com.ace.leetcode.utils;

import org.junit.Before;
import org.junit.Test;

import static com.ace.leetcode.utils.BinaryTree.build;
import static org.junit.Assert.assertEquals;

public class BinaryTreeTest
{
	private BinaryTree testNode;
	
	@Before
	public void setup()
	{
		testNode = BinaryTree.build("4(2(3)(1))(6(5))");
	}
	
	@Test
	public void shouldConvertTreeToString()
	{
		assertEquals("4(2(3)(1))(6(5))", testNode.toString());
		assertEquals("-14(2(3)(1))(6(5))", build("-14(2(3)(1))(6(5))").toString());
		assertEquals("18(15(40(30)(60))(50))(20)", build("18(15(40(30)(60))(50))(20)").toString());
		
	}
	
	@Test
	public void shouldCreateTreeFromString()
	{
		assertEquals(build("-4(2(3)(1))(6(5))").toPreorder(), new Integer[]{-4, 2, 3, 1, 6, 5});
		assertEquals(build("4(2(3)(1))(6(5))").toPreorder(), new Integer[]{4, 2, 3, 1, 6, 5});
		assertEquals(build("4(2)").toPreorder(), new Integer[]{4, 2});
		assertEquals(build(null), null);
		assertEquals(build(""), null);
		assertEquals(build("18(15(40(30)(60))(50))(20)").toPreorder(), new Integer[]{18, 15, 40, 30, 60, 50, 20});
	}
	
	@Test
	public void shouldConvertToPreorderList()
	{
		assertEquals(testNode.toPreorder(), new Integer[]{4, 2, 3, 1, 6, 5});
	}
	
	@Test
	public void shouldConvertToInorderList()
	{
		assertEquals(testNode.toInorder(), new Integer[]{3, 2, 1, 4, 5, 6});
	}
	
	@Test
	public void shouldConvertToPostorderList()
	{
		assertEquals(testNode.toPostorder(), new Integer[]{3, 1, 2, 5, 6, 4});
	}
	
	@Test
	public void shouldReturnHeightOfTree()
	{
		assertEquals(2, testNode.getMaxDepth());
		
		BinaryTree node1 = BinaryTree.build("1(2(7))(3(4(5)(6(8)");
		assertEquals(4, node1.getMaxDepth());
		assertEquals(2, node1.getMinDepth());
		
		BinaryTree node2 = BinaryTree.build("1(2)(3)");
		assertEquals(1, node2.getMaxDepth());
		assertEquals(1, node2.getMinDepth());
		
		BinaryTree node3 = BinaryTree.build("1(2)(3(4(5)))");
		assertEquals(3, node3.getMaxDepth());
		assertEquals(1, node3.getMinDepth());
	}
}