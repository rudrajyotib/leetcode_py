package interviewbit.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class RegionInBinaryMatrixTest {

    @Test
    public void shouldFindOneOfMultipleRegions(){
        assertEquals(7, new RegionInBinaryMatrix().solve(
                new int[][]{
                        new int[]{0,1,0,0,1},
                        new int[]{1,1,0,0,1},
                        new int[]{1,0,0,0,1},
                        new int[]{1,1,1,0,1},
                }
        ));
    }

    @Test
    public void shouldFindFromSingle(){
        assertEquals(13, new RegionInBinaryMatrix().solve(
                new int[][]{
                        new int[]{0,1,0,0,1},
                        new int[]{1,1,1,1,1},
                        new int[]{1,0,0,0,1},
                        new int[]{1,1,1,0,1},
                }
        ));
    }

    @Test
    public void shouldFindNoRegion(){
            assertEquals(0, new RegionInBinaryMatrix().solve(
                    new int[][]{
                            new int[]{0,0,0,0},
                            new int[]{0,0,0,0},
                            new int[]{0,0,0,0},
                            new int[]{0,0,0,0},
                    }
            ));
    }
}