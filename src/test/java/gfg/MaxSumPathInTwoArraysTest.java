package gfg;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class MaxSumPathInTwoArraysTest {

    @Test
    public void testCase1() {
        assertEquals(41, new MaxSumPathInTwoArrays().maxPathSum(
                List.of(1, 3, 5, 9, 10, 12),
                List.of(2, 4, 9, 10, 13)
        ));

        assertEquals(42, new MaxSumPathInTwoArrays().maxPathSum(
                List.of(1, 3, 5, 9, 10, 12),
                List.of(2, 4, 6, 14, 16)
        ));

        assertEquals(41, new MaxSumPathInTwoArrays().maxPathSum(
                List.of(1, 3, 5, 9, 10, 12),
                List.of(1, 4, 6, 14, 16)
        ));

        assertEquals(59, new MaxSumPathInTwoArrays().maxPathSum(
                List.of(2, 4, 6, 8, 15, 20),
                List.of(11, 13, 15)
        ));
    }

}