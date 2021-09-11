package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class SpiralMatrix2Test {

    @Test
    public void shouldCreateSpiralMatrixForOddCount()
    {
        SpiralMatrix2 spiralMatrix2 = new SpiralMatrix2();
        int[][] result = spiralMatrix2.solve(3);
        assertEquals(3, result.length);
        assertEquals(3,result[0].length);
        assertArrayEquals(new int[][]{{1,2,3}, {8,9,4}, {7,6,5}}, result);
    }

    @Test
    public void shouldCreateSpiralMatrixForEvenCount()
    {
        SpiralMatrix2 spiralMatrix2 = new SpiralMatrix2();
        int[][] result = spiralMatrix2.solve(4);
        assertEquals(4, result.length);
        assertEquals(4,result[0].length);
        assertArrayEquals(new int[][]{{1,2,3,4}, {12, 13, 14, 5}, {11, 16, 15, 6}, {10,9,8,7}}, result);
    }

    @Test
    public void shouldCreateSpiralFor1()
    {
        SpiralMatrix2 spiralMatrix2 = new SpiralMatrix2();
        int[][] result = spiralMatrix2.solve(1);
        assertEquals(1, result.length);
        assertEquals(1,result[0].length);
        assertArrayEquals(new int[][]{{1}}, result);
    }

}