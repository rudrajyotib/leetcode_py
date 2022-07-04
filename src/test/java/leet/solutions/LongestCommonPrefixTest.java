package leet.solutions;

import leet.solutions.LongestCommonPrefix;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LongestCommonPrefixTest {


    private final List<List<String>> testCases = Arrays.asList(
            Arrays.asList(
                    "app","apple","application","appointment"
            ),
            Arrays.asList(
                    "","apple","application","appointment","book"
            ),
            Arrays.asList(
                    "apple","apple","apple","apple","apple"
            ),
            Arrays.asList(
                    "apple","applet","applex","applem","appley"
            )
    );

    @Test
    public void shouldExecuteTestCases(){
        for (int i=0;i<testCases.size();i++){
            assertEquals(String.format("test case %d failed", i+1),
                    testCases.get(i).get(0), new LongestCommonPrefix().solve(new ArrayList<>(testCases.get(i).subList(1, testCases.get(i).size()))));
        }
    }

}