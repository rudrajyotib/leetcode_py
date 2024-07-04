package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaximumJumpsToReachLastIndexTest {


    @Test
    public void testCase1(){
        assertEquals(-1, new MaximumJumpsToReachLastIndex().solve(
                new int[]{0,2,1,3}, 1
        ));

        assertEquals(-1, new MaximumJumpsToReachLastIndex().solve(
                new int[]{1,3,6,4,1,2}, 0
        ));
        assertEquals(5, new MaximumJumpsToReachLastIndex().solve(
                new int[]{1,3,6,4,1,2}, 3
        ));
    }

    @Test
    public void testCase2(){
        assertEquals(3, new MaximumJumpsToReachLastIndex().solve(
                new int[]{1,3,6,4,1,2}, 2
        ));
    }

}