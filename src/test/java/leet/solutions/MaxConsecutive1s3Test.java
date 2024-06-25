package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxConsecutive1s3Test {

    @Test
    public void testCase1(){
        assertEquals(6, new MaxConsecutive1s3().solve(
                new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2
        ));
        assertEquals(10, new MaxConsecutive1s3().solve(
                new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3
        ));
    }


}