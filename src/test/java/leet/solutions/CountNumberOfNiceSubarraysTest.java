package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class CountNumberOfNiceSubarraysTest {

    @Test
    public void testCase1(){
        assertEquals(2, new CountNumberOfNiceSubarrays().solve(
                new int[]{1,1,2,1,1}, 3
        ));

        assertEquals(16, new CountNumberOfNiceSubarrays().solve(
                new int[]{2,2,2,1,2,2,1,2,2,2}, 2
        ));

        assertEquals(0, new CountNumberOfNiceSubarrays().solve(
                new int[]{2,2,2,1,2,2,1,2,2,2}, 3
        ));
    }


}