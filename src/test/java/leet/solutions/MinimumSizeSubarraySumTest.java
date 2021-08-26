package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinimumSizeSubarraySumTest {

    @Test
    public void shouldFindMinimumSubarrayMatchingTarget() {
        MinimumSizeSubarraySum minimumSizeSubarraySum = new MinimumSizeSubarraySum();
        assertEquals(2, minimumSizeSubarraySum.solve(7, new int[]{2, 3, 1, 2, 4, 3}));
        assertEquals(2, minimumSizeSubarraySum.solve(7, new int[]{2, 3, 2, 2, 4, 3}));
        assertEquals(1, minimumSizeSubarraySum.solve(7, new int[]{2, 3, 2, 2, 4, 3, 7}));
        assertEquals(0, minimumSizeSubarraySum.solve(17, new int[]{2, 3, 2, 2, 4, 3}));
        assertEquals(1, minimumSizeSubarraySum.solve(7, new int[]{8, 9, 10, 5, 11, 3, 19, 4, 3}));
        assertEquals(3, minimumSizeSubarraySum.solve(11, new int[]{1, 2, 3, 4, 5}));
    }


}