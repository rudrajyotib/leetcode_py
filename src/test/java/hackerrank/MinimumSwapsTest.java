package hackerrank;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinimumSwapsTest {

    @Test
    public void testCase1(){
        assertEquals(5, MinimumSwaps.minimumSwaps(new int[]{7,1,3, 2, 4, 5, 6}));
        assertEquals(1, MinimumSwaps.minimumSwaps(new int[]{7,2,3,4,5,6,1}));
    }

}