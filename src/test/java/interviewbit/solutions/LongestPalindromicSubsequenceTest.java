package interviewbit.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestPalindromicSubsequenceTest {

    private final String[][] testCases= new String[][]{
        new String[]{"4", "bebeeed"},
        new String[]{"5", "bebexeed"},
        new String[]{"1", "a"},
        new String[]{"9", "malayalam"},
        new String[]{"1", "ab"},
        new String[]{"1", "abc"},
        new String[]{"3", "aba"}
    };

    @Test
    public void shouldExecuteTestCases(){
        for (int i=0;i<testCases.length;i++){
            assertEquals(String.format("Test case %d failed", i+1),Integer.parseInt(testCases[i][0]),
                    new LongestPalindromicSubsequence().solve(testCases[i][1]));
        }
    }


}