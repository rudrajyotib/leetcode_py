package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class TwoSum2SortedArrayTest {

    @Test
    public void testCase1(){
        assertArrayEquals(new int[]{3, 5},
                new TwoSum2SortedArray().solve(
                        new int[]{0,1,2,3,4,7}, 6
                ));

        assertArrayEquals(new int[]{1, 2},
                new TwoSum2SortedArray().solve(
                        new int[]{1,1,2,3,4,5}, 2
                ));

        assertArrayEquals(new int[]{1, 2},
                new TwoSum2SortedArray().solve(
                        new int[]{2,2}, 4
                ));
    }

}