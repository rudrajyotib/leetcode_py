package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class SlidingWindowMaximumTest {


    @Test
    public void shouldFindSlidingWindowMaximum(){
        assertArrayEquals(new int[]{15, 25, 25, 25, 12, 30},
                new SlidingWindowMaximum().solve(new int[]{10,15,8,25,6,8,12,30}, 3));
    }

    @Test
    public void shouldFindSlidingWindowMaximumSet2(){
        assertArrayEquals(new int[]{9,9,10,10,10,10,10,10,10,9,9,9,8,8},
                new SlidingWindowMaximum().solve(new int[]{-6,-10,-7,-1,-9,9,-8,-4,10,-5,2,9,0,-7,7,4,-2,-10,8,7}, 7));
    }


    @Test
    public void shouldFindSlidingWindowMaximumSet3(){
        assertArrayEquals(new int[]{20,19,21,21,21,15,14,13,12},
                new SlidingWindowMaximum().solve(new int[]{20,19,18,17,21,15,14,13,12,11,10}, 3));
    }

    @Test
    public void shouldFindSlidingWindowMaximumSet4(){
        assertArrayEquals(new int[]{20,19,21,22,23,24,25,26},
                new SlidingWindowMaximum().solve(new int[]{20,19,18,17,21,22,23,24,25,26}, 3));
    }


    @Test
    public void shouldFindSlidingWindowMaximumForSingleSpaceWindow(){
        assertArrayEquals(new int[]{20, 25, 30},
                new SlidingWindowMaximum().solve(new int[]{20,25,30}, 1));
    }

    @Test
    public void shouldFindSlidingWindowMaximumForInputLengthWindow(){
        assertArrayEquals(new int[]{30},
                new SlidingWindowMaximum().solve(new int[]{20,25,30}, 3));
    }


}