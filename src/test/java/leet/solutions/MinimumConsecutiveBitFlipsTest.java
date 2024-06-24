package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinimumConsecutiveBitFlipsTest {

    @Test
    public void testCase1(){
        assertEquals(3, new MinimumConsecutiveBitFlips().solve(new int[]{0,0,0,1,0,1,1,0}, 3));
    }

}