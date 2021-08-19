package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaximumSubarrayTest {

    @Test
    public void shouldFindMaxSubArray()
    {
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        assertEquals(6, maximumSubarray.solve(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        assertEquals(3, maximumSubarray.solve(new int[]{0,0,1,1,1}));
    }


}