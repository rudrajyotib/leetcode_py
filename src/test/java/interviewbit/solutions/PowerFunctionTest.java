package interviewbit.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class PowerFunctionTest {

    int[][] testCases = new int[][]{
      new int[]{6, 6, 25, 6},
      new int[]{6, 6, 42, 36},
      new int[]{-2, 5, 25, 18},
      new int[]{-2, 6, 25, 14},
      new int[]{71045970,41535484,64735492, 20805472}
    };

    @Test
    public void execute(){
        for (int[] testCase : testCases) {
            assertEquals(testCase[3],
                    new PowerFunction().solve(testCase[0], testCase[1], testCase[2]));
        }
    }

}