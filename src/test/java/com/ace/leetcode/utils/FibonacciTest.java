package com.ace.leetcode.utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FibonacciTest
{
	@Test
	public void getFibOfNumber()
	{
		assertEquals(2, Fibonacci.getNumber(3));
		assertEquals(3, Fibonacci.getNumber(4));
		assertEquals(5, Fibonacci.getNumber(5));
		assertEquals(8, Fibonacci.getNumber(6));
		assertEquals(13, Fibonacci.getNumber(7));
	}
}