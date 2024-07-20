package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindValidMatrixGivenRowAndColumnSumsTest {

    @Test
    public void testCase1(){
        int[][] result = new FindValidMatrixGivenRowAndColumnSums().solve(
                new int[]{5,7,10},
                new int[]{8,6,8}
        );
        int[] rows = new int[3];
        int[] cols = new int[3];
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                rows[i] += result[i][j];
                cols[j] += result[i][j];
            }
        }
        assertArrayEquals(new int[]{5,7,10}, rows);
        assertArrayEquals(new int[]{8,6,8}, cols);
    }


}