package interviewbit.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class ClimbingStairsTest {

    private final int[][] testCases = new int[][]{
            new int[]{1,1},
            new int[]{2,2},
            new int[]{3,3},
            new int[]{4,5},
            new int[]{6, 13},
            new int[]{7,21}
    };

    @Test
    public void executeTestCases(){
        for (int i=0;i<testCases.length;i++){
            assertEquals(String.format("Test case %d failed", i+1),
                    testCases[i][1],
                    new ClimbingStairs().solve(testCases[i][0]));
        }
    }


}