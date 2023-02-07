package gfg;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestSubArrayWithPositiveProductTest {

    @Test
    public void set1(){
        assertEquals(8, new LongestSubArrayWithPositiveProduct().solve(new int[]{6 , -10 , 6 ,-1 ,-6 ,-4 , 5 ,-10 ,4 ,2}));
        assertEquals(3, new LongestSubArrayWithPositiveProduct().solve(new int[]{1,2,3}));
        assertEquals(3, new LongestSubArrayWithPositiveProduct().solve(new int[]{0, 1, -2, -3, -4}));
        assertEquals(5, new LongestSubArrayWithPositiveProduct().solve(new int[]{4,5,6,7,7,0, 1, -2, -3, -4}));
        assertEquals(6, new LongestSubArrayWithPositiveProduct().solve(new int[]{4,5,6,7,7,0, 1, -2,4,5,6, -3, -4}));
        assertEquals(0, new LongestSubArrayWithPositiveProduct().solve(new int[]{0,0,0,0}));
        assertEquals(0, new LongestSubArrayWithPositiveProduct().solve(new int[]{0,0,-1,0,0}));
        assertEquals(2, new LongestSubArrayWithPositiveProduct().solve(new int[]{0,0,-1,-1,0,0}));
        assertEquals(2, new LongestSubArrayWithPositiveProduct().solve(new int[]{0,0,-1,-1,-1,0,0}));
        assertEquals(4, new LongestSubArrayWithPositiveProduct().solve(new int[]{0,0,-1,-1,-1,-1,0,0}));
    }


}