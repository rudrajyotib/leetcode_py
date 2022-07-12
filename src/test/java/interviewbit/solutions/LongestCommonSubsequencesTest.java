package interviewbit.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestCommonSubsequencesTest {

    private final String[][] testCases = new String[][]{
        new String[]{"3","race","ace"},
        new String[]{"5","pineapple", "apple"},
        new String[]{"1","abcd", "dcrf"},
        new String[]{"1","abcd", "dcba"},
        new String[]{"1","air", "balloon"},
        new String[]{"0","air", "job"},
        new String[]{"3","aaa", "aaaa"},
        new String[]{"1","a", "a"},
        new String[]{"0","a", "b"}
    };

    @Test
    public void shouldExecuteTestCases(){
        for (int i=0;i<testCases.length;i++){
            assertEquals(String.format("Test case %d failed", i+1),
                    Integer.parseInt(testCases[i][0]),
                    new LongestCommonSubsequences().solve(testCases[i][1], testCases[i][2]));
        }
    }

}