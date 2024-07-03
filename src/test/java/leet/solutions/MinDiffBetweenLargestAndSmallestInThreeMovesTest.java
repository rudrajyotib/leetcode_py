package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinDiffBetweenLargestAndSmallestInThreeMovesTest {


    @Test
    public void testCase1(){
        assertEquals(9, new MinDiffBetweenLargestAndSmallestInThreeMoves().solve(new int[]{0,1,5,10,12,14,20}));
        assertEquals(0, new MinDiffBetweenLargestAndSmallestInThreeMoves().solve(new int[]{0,1,5,10}));
    }

}