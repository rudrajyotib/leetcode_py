package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaximumTotalImportanceOfRoadsTest {

    @Test
    public void testCase1(){
        assertEquals(43, new MaximumTotalImportanceOfRoads().solve(
                5,
                new int[][]{
                        new int[]{0,1},
                        new int[]{2,1},
                        new int[]{3,1},
                        new int[]{2,3},
                        new int[]{0,2},
                        new int[]{2,4}

                }
        ));
    }

    @Test
    public void testCase2(){
        assertEquals(20, new MaximumTotalImportanceOfRoads().solve(
                5,
                new int[][]{
                        new int[]{0,3},
                        new int[]{3,1},
                        new int[]{2,4}

                }
        ));
    }
}