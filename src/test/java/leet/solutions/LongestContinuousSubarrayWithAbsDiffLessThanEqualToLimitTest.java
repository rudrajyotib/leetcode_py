package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestContinuousSubarrayWithAbsDiffLessThanEqualToLimitTest {


    @Test
    public void testCase1(){
        assertEquals(2, new LongestContinuousSubarrayWithAbsDiffLessThanEqualToLimit().solve(
                new int[]{8,2,4,7},
                4
        ));
        assertEquals(4, new LongestContinuousSubarrayWithAbsDiffLessThanEqualToLimit().solve(
                new int[]{10,1,2,4,7,2},
                5
        ));
        assertEquals(3, new LongestContinuousSubarrayWithAbsDiffLessThanEqualToLimit().solve(
                new int[]{4,2,2,2,4,4,2,2},
                0
        ));
    }

}