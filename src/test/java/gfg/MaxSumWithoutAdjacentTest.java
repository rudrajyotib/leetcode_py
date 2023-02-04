package gfg;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxSumWithoutAdjacentTest {

    @Test
    public void set1(){
        assertEquals(110, new MaxSumWithoutAdjacent().solve(new int[]{5, 5, 10, 100, 10, 5}));
        assertEquals(13, new MaxSumWithoutAdjacent().solve(new int[]{3, 2, 7, 10}));
        assertEquals(27, new MaxSumWithoutAdjacent().solve(new int[]{3, 6, 2, 1, 8, 4, 7, 3, 6, 4}));
        assertEquals(20, new MaxSumWithoutAdjacent().solve(new int[]{20}));
        assertEquals(20, new MaxSumWithoutAdjacent().solve(new int[]{20,10}));
        assertEquals(25, new MaxSumWithoutAdjacent().solve(new int[]{20,10, 5}));
        assertEquals(25, new MaxSumWithoutAdjacent().solve(new int[]{20,10, 5, 3}));
    }


}