package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class SetMatrixZeroesTest {

    @Test
    public void shouldRestMatrix()
    {
        int[][] matrix = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        SetMatrixZeroes setMatrixZeroes = new SetMatrixZeroes();
        setMatrixZeroes.solve(matrix);
        assertArrayEquals(new int[][]{{0,0,0,0},{0,4,5,0},{0,3,1,0}}, matrix);
    }

    @Test
    public void shouldResetSingleElementMatrix()
    {
        int[][] matrix = new int[][]{{0}};
        SetMatrixZeroes setMatrixZeroes = new SetMatrixZeroes();
        setMatrixZeroes.solve(matrix);
        assertArrayEquals(new int[][]{{0}}, matrix);
    }


}