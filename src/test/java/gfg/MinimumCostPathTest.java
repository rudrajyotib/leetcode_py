package gfg;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinimumCostPathTest {

    @Test
    public void testCase1(){
        assertEquals(43, new MinimumCostPath().minimumCostPath(
                new int[][]{
                        new int[]{9,4,9,9},
                        new int[]{6,7,6,4},
                        new int[]{8,3,3,7},
                        new int[]{7,4,9,10},
                }
        ));
    }

    @Test
    public void testCase2(){
        assertEquals(14, new MinimumCostPath().minimumCostPath(
                new int[][]{
                        new int[]{4,4},
                        new int[]{3,7},
                }
        ));
    }

}