package com.ace.leetcode;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
public class LeetCode105Test
{
	@Test
	public void shouldCreateBinaryTreeFromArray()
	{
		assertTrue(new LeetCode331().verify(new String[]{"1", "2", "4", "#", "#", "5", "#", "#", "3", "6", "#", "#", "7", "#", "#"}));
	}
}