package interviewbit.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class WaterFlowTest {

    @Test
    public void shouldCalculateWaterMixInMatrix(){
        assertEquals(7, new WaterFlow().solve(
                new int[][]{
                        new int[]{4,6,8,10},
                        new int[]{5,2,20,19},
                        new int[]{6,7,14,20},
                        new int[]{7,2,3,1}
                }
        ));
    }

    @Test
    public void shouldCalculateWaterMixInMatrixSet2(){
        assertEquals(9, new WaterFlow().solve(
                new int[][]{
                        new int[]{2,2,2},
                        new int[]{2,2,2},
                        new int[]{2,2,2}
                }
        ));
    }

    @Test
    public void shouldCalculateWaterMixInMatrixSet3(){
        assertEquals(7, new WaterFlow().solve(
                new int[][]{
                        new int[]{1, 2, 2, 3, 5},
                        new int[]{3, 2, 3, 4, 4},
                        new int[]{2, 4, 5, 3, 1},
                        new int[]{6, 7, 1, 4, 5},
                        new int[]{5, 1, 1, 2, 4}
                }
        ));
    }

    @Test
    public void shouldFindWaterFlowInSingleCellTerrain(){
        assertEquals(1, new WaterFlow().solve(new int[][]{
                new int[]{1}
        }));
    }

    @Test
    public void shouldHandleSingleColumnMatrix(){
        assertEquals(5, new WaterFlow().solve(
                new int[][]{
                        new int[]{1},
                        new int[]{2},
                        new int[]{3},
                        new int[]{4},
                        new int[]{5}
                }
        ));
    }

    @Test
    public void shouldHandleSingleRowMatrix(){
        assertEquals(5, new WaterFlow().solve(
                new int[][]{
                        new int[]{1,2,3,4,5}
                }
        ));
    }



}