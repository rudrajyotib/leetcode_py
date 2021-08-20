package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class SpiralMatrixTest {

    @Test
    public void shouldPrintSpiral()
    {
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        assertArrayEquals(new Integer[]{1,2,3,6,9,8,7,4,5}, spiralMatrix.solve(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
        assertArrayEquals(new Integer[]{1,2,3}, spiralMatrix.solve(new int[][]{{1},{2},{3}}));
        assertArrayEquals(new Integer[]{1}, spiralMatrix.solve(new int[][]{{1}}));
    }

}