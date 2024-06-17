package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinimumFuelCostToReportToCapitalTest {

    @Test
    public void testCase1() {
        assertEquals(13, new MinimumFuelCostToReportToCapital().solve(
                new int[][]{new int[]{3, 4},
                        new int[]{3, 2},
                        new int[]{1, 2},
                        new int[]{1, 0},
                        new int[]{5, 0},
                        new int[]{5, 6},
                        new int[]{5, 7},
                        new int[]{8, 7},
                        new int[]{9, 7},
                        new int[]{10, 7},
                }, 3
        ));
    }

    @Test
    public void testCase2() {
        assertEquals(7, new MinimumFuelCostToReportToCapital().solve(
                new int[][]{new int[]{3, 1},
                        new int[]{3, 2},
                        new int[]{1, 0},
                        new int[]{5, 0},
                        new int[]{4, 0},
                        new int[]{4, 6}
                }, 2
        ));
    }

    @Test
    public void testCase3() {
        assertEquals(0, new MinimumFuelCostToReportToCapital().solve(
                new int[][]{new int[]{}}, 1
        ));
    }

    @Test
    public void testCase4() {
        assertEquals(4, new MinimumFuelCostToReportToCapital().solve(
                new int[][]{new int[]{3, 0},
                        new int[]{0, 2},
                        new int[]{1, 0},
                        new int[]{4, 0},
                }, 20
        ));
    }

}