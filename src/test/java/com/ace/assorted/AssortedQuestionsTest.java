package com.ace.assorted;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AssortedQuestionsTest
{
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
}
