package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class UniquePathsTest {


    int[][] testCases = new int[][]{
            new int[]{3, 7, 28},
            new int[]{7, 9, 3003},
            new int[]{1, 100, 1},
            new int[]{100, 1, 1}
    };

    @Test
    public void shouldExecuteAllTestCases(){

        for (int i=0; i<testCases.length; i++){
            assertEquals(String.format("Test case %d failed", i+1), testCases[i][2],
                    new UniquePaths().solve(testCases[i][0], testCases[i][1]));
        }
    }

}