package com.ace.assorted;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AssortedQuestionsTest
{
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
