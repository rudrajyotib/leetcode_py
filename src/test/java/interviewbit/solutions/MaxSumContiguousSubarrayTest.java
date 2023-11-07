package interviewbit.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxSumContiguousSubarrayTest {

    @Test
    public void set1(){
        assertEquals(10, new MaxSumContiguousSubarray().solve(new int[]{1, 2, 3, 4, -10}));
        assertEquals(6, new MaxSumContiguousSubarray().solve(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        assertEquals(6, new MaxSumContiguousSubarray().solve(new int[]{6}));
    }

}