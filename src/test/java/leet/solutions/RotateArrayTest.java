package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class RotateArrayTest {

    @Test
    public void testCase1(){
        int[] input = new int[]{1,2,3,4,5};
        new RotateArray().solve(input, 2);
        assertArrayEquals(new int[]{4,5,1,2,3}, input);
    }

    @Test
    public void testCase2(){
        int[] input = new int[]{1,2,3,4,5};
        new RotateArray().solve(input, 12);
        assertArrayEquals(new int[]{4,5,1,2,3}, input);
    }

    @Test
    public void testCase3(){
        int[] input = new int[]{1,2,3,4,5};
        new RotateArray().solve(input, 11);
        assertArrayEquals(new int[]{5,1,2,3,4}, input);
    }


}