package interviewbit.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class DistinctSubsequencesTest {

    private final String[][] testCases = new String[][]{
            new String[]{"3", "rabbbit", "rabbit"},
            new String[]{"1", "abcde", "ace"},
            new String[]{"0", "abcde", "fghij"},
            new String[]{"0", "aa", "aaa"},
            new String[]{"3", "aaa", "aa"},
    };

    @Test
    public void shouldExecuteTestCases(){
        for (int i=0;i<testCases.length;i++){
            assertEquals(String.format("Test case %d failed", i+1),
                    Integer.parseInt(testCases[i][0]),
                    new DistinctSubsequences().solve(testCases[i][1], testCases[i][2]));
        }
    }


}