package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class Search2dMatrixTest {

    @Test
    public void shouldFindElement()
    {
        int[][] matrix = new int[][]{{10, 13, 16}, {19, 20, 39}, {44, 46, 48}, {51, 53, 57}, {60, 61, 62}};
        Search2dMatrix search2dMatrix = new Search2dMatrix();
        assertTrue( search2dMatrix.solve(matrix, 20));
    }

    @Test
    public void shouldNotFindElementInGapOfRows()
    {
        int[][] matrix = new int[][]{{10, 13, 16}, {19, 20, 39}, {44, 46, 48}, {51, 53, 57}, {60, 61, 62}};
        Search2dMatrix search2dMatrix = new Search2dMatrix();
        assertFalse( search2dMatrix.solve(matrix, 18));
    }

    @Test
    public void shouldNotFindElementInGapOfColumns()
    {
        int[][] matrix = new int[][]{{10, 13, 16}, {19, 20, 39}, {44, 46, 48}, {51, 53, 57}, {60, 61, 62}};
        Search2dMatrix search2dMatrix = new Search2dMatrix();
        assertFalse( search2dMatrix.solve(matrix, 28));
    }


}