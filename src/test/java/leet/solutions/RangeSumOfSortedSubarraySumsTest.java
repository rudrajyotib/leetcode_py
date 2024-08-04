package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class RangeSumOfSortedSubarraySumsTest {

    @Test
    public void testCase1(){
        assertEquals(13, new RangeSumOfSortedSubarraySums().solve(
                new int[]{1,2,3,4}, 4, 1, 5
        ));

        assertEquals(6, new RangeSumOfSortedSubarraySums().solve(
                new int[]{1,2,3,4}, 4, 3, 4
        ));

        assertEquals(50, new RangeSumOfSortedSubarraySums().solve(
                new int[]{1,2,3,4}, 4, 1, 10
        ));
    }

}