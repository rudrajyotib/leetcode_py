package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class SortArrayByIncreasingFrequencyTest {

    @Test
    public void testCase1(){
        assertArrayEquals(new int[]{1,1,1}, new SortArrayByIncreasingFrequency().solve(new int[]{1,1,1}));
        assertArrayEquals(new int[]{2,2,1,1,1}, new SortArrayByIncreasingFrequency().solve(new int[]{1,1,1,2,2}));
        assertArrayEquals(new int[]{4,3,2,2,1,1,1}, new SortArrayByIncreasingFrequency().solve(new int[]{1,1,1,2,2,3,4}));
    }


}