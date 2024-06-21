package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class SubArraySumDivisibleByKTest {

    @Test
    public void testCase1(){
        assertEquals(7, new SubArraySumDivisibleByK().solve(
                new int[]{4,5,0,-2,-3,1}, 5
        ));
    }

}