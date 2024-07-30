package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinimumDeleteToMakeStringBalancedTest {

    @Test
    public void testCase1(){
        assertEquals(2, new MinimumDeleteToMakeStringBalanced().solve("aababbab"));
        assertEquals(2, new MinimumDeleteToMakeStringBalanced().solve("bbaaaaabb"));
        assertEquals(0, new MinimumDeleteToMakeStringBalanced().solve("aabb"));
        assertEquals(0, new MinimumDeleteToMakeStringBalanced().solve("aaabbbb"));
        assertEquals(0, new MinimumDeleteToMakeStringBalanced().solve("bbb"));
        assertEquals(0, new MinimumDeleteToMakeStringBalanced().solve("aaaaa"));
    }

}