package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinCostToConnectAllPointsTest {

    @Test
    public void testCase1(){
        assertEquals(20,
                new MinCostToConnectAllPoints().solve(
                        new int[][]{
                                new int[]{0,0},
                                new int[]{2,2},
                                new int[]{3,10},
                                new int[]{5,2},
                                new int[]{7,0},
                        }
                ));
    }

    @Test
    public void testCase2(){
        assertEquals(18,
                new MinCostToConnectAllPoints().solve(
                        new int[][]{
                                new int[]{3,12},
                                new int[]{-2,5},
                                new int[]{-4,1}
                        }
                ));
    }


}