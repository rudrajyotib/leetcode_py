package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinimumIncrementToMakeArrayUniqueTest {

    @Test
    public void testCase(){
        assertEquals(6, new MinimumIncrementToMakeArrayUnique().solve(
                new int[]{3,2,1,2,1,7}
        ));
        assertEquals(1, new MinimumIncrementToMakeArrayUnique().solve(
                new int[]{2,2,1}
        ));
        assertEquals(0, new MinimumIncrementToMakeArrayUnique().solve(
                new int[]{3,2,1}
        ));
    }


}