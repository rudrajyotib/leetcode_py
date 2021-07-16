package com.ace.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LeetCode331Test
{
    @Test
    public void shouldCreateBinaryTreeFromArray()
    {
        assertFalse(new LeetCode331().verify(new String[]{"1", "#"}));
        assertFalse(new LeetCode331().verify(new String[]{"9", "#", "#", "1"}));
        assertTrue(new LeetCode331().verify(new String[]{"9", "3", "4", "#", "#", "1", "#", "#", "2", "#", "6", "#", "#"}));
    }
}