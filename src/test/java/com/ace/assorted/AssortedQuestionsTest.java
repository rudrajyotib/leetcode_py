package com.ace.assorted;

import org.junit.Test;

import static org.junit.Assert.*;

public class AssortedQuestionsTest
{
	@Test
	public void isBalanced()
	{
		assertFalse(AssortedQuestions.isBalanced("{[(])}"));
		assertTrue(AssortedQuestions.isBalanced("{{[[(())]]}}"));
	}
	
	@Test
	public void findPositions()
	{
		int[] result1 = AssortedQuestions.findPositions(new int[]{1, 2, 2, 3, 4, 5}, 5);
		assertEquals(5, result1[0]);
		assertEquals(6, result1[1]);
		assertEquals(4, result1[2]);
		assertEquals(1, result1[3]);
		assertEquals(2, result1[4]);
	}
	
	@Test
	public void findMedian()
	{
		int[] result1 = AssortedQuestions.findMedian(new int[]{5, 15, 1, 3});
		//5, 10, 5, 4
		assertEquals(5, result1[0]);
		assertEquals(10, result1[1]);
		assertEquals(5, result1[2]);
		assertEquals(4, result1[3]);
		
		// 2, 3, 4, 3, 4, 3
		int[] result2 = AssortedQuestions.findMedian(new int[]{2, 4, 7, 1, 5, 3});
		assertEquals(2, result2[0]);
		assertEquals(3, result2[1]);
		assertEquals(4, result2[2]);
		assertEquals(3, result2[3]);
		assertEquals(4, result2[4]);
		assertEquals(3, result2[5]);
	}
	
	@Test
	public void maxCandies()
	{
		assertEquals(14, AssortedQuestions.maxCandies(new int[]{2, 1, 7, 4, 2}, 3));
		assertEquals(228, AssortedQuestions.maxCandies(new int[]{19, 78, 76, 72, 48, 8, 24, 74, 29}, 3));
	}
	
	@Test
	public void findMaxProduct()
	{
		int[] result1 = AssortedQuestions.findMaxProduct(new int[]{1, 2, 3, 4, 5});
		assertEquals(-1, result1[0]);
		assertEquals(-1, result1[1]);
		assertEquals(6, result1[2]);
		assertEquals(24, result1[3]);
		assertEquals(60, result1[4]);
		
		int[] result2 = AssortedQuestions.findMaxProduct(new int[]{2, 1, 2, 1, 2});
		assertEquals(-1, result2[0]);
		assertEquals(-1, result2[1]);
		assertEquals(4, result2[2]);
		assertEquals(4, result2[3]);
		assertEquals(8, result2[4]);
		
		int[] result3 = AssortedQuestions.findMaxProduct(new int[]{2, 4, 7, 1, 5, 3});
		assertEquals(-1, result3[0]);
		assertEquals(-1, result3[1]);
		assertEquals(56, result3[2]);
		assertEquals(56, result3[3]);
		assertEquals(140, result3[4]);
		assertEquals(140, result3[5]);
	}
	
	@Test
	public void findSignatureCounts()
	{
		int[] result2 = AssortedQuestions.findSignatureCounts(new int[]{2, 1});
		assertEquals(2, result2[0]);
		assertEquals(2, result2[1]);
		
		int[] result1 = AssortedQuestions.findSignatureCounts(new int[]{1, 2});
		assertEquals(1, result1[0]);
		assertEquals(1, result1[1]);
	}
	
	@Test
	public void shouldReverseToMakeEqual()
	{
		assertEquals(true, AssortedQuestions.areTheyEqual(new int[]{4}, new int[]{4}));
		assertEquals(false, AssortedQuestions.areTheyEqual(new int[]{4}, new int[]{1}));
		assertEquals(true, AssortedQuestions.areTheyEqual(new int[]{1, 2, 3, 4}, new int[]{1, 4, 3, 2}));
	}
	
	@Test
	public void rotationalCipher()
	{
		assertEquals("Cheud-726?", AssortedQuestions.rotationalCipher("Zebra-493?", 3));
		assertEquals("nopqrstuvwxyzABCDEFGHIJKLM9012345678", AssortedQuestions.rotationalCipher("abcdefghijklmNOPQRSTUVWXYZ0123456789", 39));
	}
	
	@Test
	public void shouldReturnPairSums()
	{
		assertEquals(2, AssortedQuestions.pairSums(new int[]{1, 2, 3, 4, 3}, 6));
		assertEquals(4, AssortedQuestions.pairSums(new int[]{1, 5, 3, 3, 3}, 6));
	}
	
	@Test
	public void shouldContiguousSubArrays()
	{
		int[] actual = AssortedQuestions.countSubArrays(new int[]{3, 4, 1, 6, 2});
		assertEquals(1, actual[0]);
		assertEquals(3, actual[1]);
		assertEquals(1, actual[2]);
		assertEquals(5, actual[3]);
		assertEquals(1, actual[4]);
	}

//	private int getCount(Node node, Query q, String s){
//		if(node==null){
//			return 0;
//		}
//		int count=0;
//		if(s.charAt(node.val-1)==q.c){
//			count++;
//		}
//		for(Node child: node.children)
//			count+=getCount(child,q,s);
//		return count;
//	}
//
//	private Node findNode(Node root, int val){
//		if(root==null){
//			return null;
//		}
//		if(root.val==val){
//			return root;
//		}
//		for(Node child: root.children){
//			Node found = findNode(child, val);
//			if(found!=null){
//				return found;
//			}
//		}
//		return null;
//	}
//
//	int[] countOfNodes(Node root, ArrayList<Query> queries, String s) {
//		int[] result = new int[queries.size()];
//		int i=0;
//		for(Query q: queries){
//			Node node = findNode(root, q.u);
//			result[i++]=getCount(node, q, s);
//		}
//		return result;
//	}
}
