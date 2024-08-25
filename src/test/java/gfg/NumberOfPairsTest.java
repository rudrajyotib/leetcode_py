package gfg;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberOfPairsTest {

    @Test
    public void testCase1() {
        assertEquals(3, new NumberOfPairs().countPairs(
                new int[]{2, 1, 6},
                new int[]{1, 5}
        ));
    }

    @Test
    public void testCase2() {
        assertEquals(5, new NumberOfPairs().countPairs(
                new int[]{2, 3, 4, 5},
                new int[]{1, 2, 3}
        ));
    }


}