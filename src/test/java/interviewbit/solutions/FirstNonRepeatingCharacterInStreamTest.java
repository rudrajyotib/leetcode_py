package interviewbit.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class FirstNonRepeatingCharacterInStreamTest {

    private final String[][] testCases = new String[][]{
            new String[]{"abadbc","aabbdd"},
            new String[]{"abcabc","aaabc#"},
            new String[]{"aaaaa","a####"},
            new String[]{"abcbcadef","aaaaa#ddd"}
    };

    @Test
    public void shouldExecuteTestCases(){
        for (int i=0;i<testCases.length;i++){
            assertEquals(String.format("Test case %d failed", i+1),
                    testCases[i][1],
                    new FirstNonRepeatingCharacterInStream().solve(testCases[i][0]));
        }
    }


}