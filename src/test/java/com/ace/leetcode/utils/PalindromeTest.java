package com.ace.leetcode.utils;

import static org.junit.Assert.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
public class PalindromeTest
{
	@Test
	public void shouldReturnTrueIfValidPalindrome()
	{
		assertTrue(new Palindrome("A man, a plan, a canal: Panama").isValid());
		assertFalse(new Palindrome("race a car").isValid());
		assertFalse(new Palindrome("").isValid());
	}
	
	@Test
	public void getLongestPalindrome()
	{
		assertEquals("bab", new Palindrome("babad").getLongestPalindrome());
		assertEquals("bb", new Palindrome("cbbd").getLongestPalindrome());
		assertEquals("a", new Palindrome("a").getLongestPalindrome());
	}
	
}