package interviewbit.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class RepeatingSubsequenceTest {

    private final String[][] testCases = new String[][]{
            new String[]{"1", "abcdac"},
            new String[]{"0", "abc"},
            new String[]{"0","aa"},
            new String[]{"1","abcdabce"},
            new String[]{"0","a"},
    };

    @Test
    public void shouldExecuteTestCases(){
        for (int i=0;i<testCases.length;i++){
            assertEquals(String.format("Test case %d failed", i+ 1),
                    Integer.parseInt(testCases[i][0]),
                    new RepeatingSubsequence().solve(testCases[i][1]));
        }
    }


}