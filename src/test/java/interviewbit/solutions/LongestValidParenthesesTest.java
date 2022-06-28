package interviewbit.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestValidParenthesesTest {


    String[][] testCases = new String[][]{
            new String[]{"()()","4"},
            new String[]{"((((())()","6"},
            new String[]{"(())))))))(((((()","4"},
            new String[]{")()))(())((())))))())()(((((())())((()())(())((((())))())((()()))(()(((()()(()((()()))(())()))(((","30"},
            new String[]{")))((()))((()()()((()(())()))()(())(()))()())((()(()))((())","42"}
    };

    @Test
    public void execute(){
        for (int i=0;i<testCases.length;i++) {
            assertEquals(String.format("Test case %d failed", (i+1)), Integer.parseInt(testCases[i][1]),
                    new LongestValidParentheses().solve(testCases[i][0]));
        }
    }

    @Test
    public void executeSingleTestCase(){
        int testCaseIndex = 3;
        assertEquals(Integer.parseInt(testCases[testCaseIndex][1]),
                new LongestValidParentheses().solve(testCases[testCaseIndex][0]));
    }
}