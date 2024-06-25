package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class RemoveDuplicatesFromSortedArray2Test {


    @Test
    public void testCase1(){
        int[] input = new int[]{1,1,1,2,2,2,3,3,};
        assertEquals(6, new RemoveDuplicatesFromSortedArray2().solve(input));

    }

    @Test
    public void testCase2(){
        int[] input = new int[]{1,1,1,2,2,2,3,3,4,5,5,5,6};
        assertEquals(10, new RemoveDuplicatesFromSortedArray2().solve(input));

    }

}