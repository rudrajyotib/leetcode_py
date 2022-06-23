package interviewbit.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class GreatestCommonDivisorTest {



    public int[][] testCases = new int[][]{
            new int[]{21, 56, 7},
            new int[]{21, 58, 1},
            new int[]{0, 57, 57},
            new int[]{1, 0, 1},
    };

    @Test
    public void shouldFindGcd()
    {
        for (int i=0;i<testCases.length;i++){
            assertEquals(String.format("Test case %d failed",i+1)
                    , testCases[i][2],
                    new GreatestCommonDivisor().solve(testCases[i][0], testCases[i][1]));
        }
    }

}