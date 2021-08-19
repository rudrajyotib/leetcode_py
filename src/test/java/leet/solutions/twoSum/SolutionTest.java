package leet.solutions.twoSum;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SolutionTest {

    @Test
    public void testTwoSumSet1()
    {
        Solution solution = new Solution();
        int[] result = solution.twoSum(new int[]{2, 5, 8}, 10);
        assertEquals(2, result.length);
        assertTrue(Arrays.stream(result).anyMatch(i -> i == 0));
        assertTrue(Arrays.stream(result).anyMatch(i -> i == 2));
    }

    @Test
    public void testTwoSumSet2()
    {
        Solution solution = new Solution();
        int[] result = solution.twoSum(new int[]{2, 4, 5, 7, 8, 9}, 15);
        assertEquals(2, result.length);
        assertTrue(Arrays.stream(result).anyMatch(i -> i == 3));
        assertTrue(Arrays.stream(result).anyMatch(i -> i == 4));
    }

    @Test
    public void testTwoSumSet3()
    {
        Solution solution = new Solution();
        int[] result = solution.twoSum(new int[]{5, 4, 6, 7, 8, 9}, 10);
        assertEquals(2, result.length);
        assertTrue(Arrays.stream(result).anyMatch(i -> i == 1));
        assertTrue(Arrays.stream(result).anyMatch(i -> i == 2));
    }


}