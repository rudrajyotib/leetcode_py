package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaximumScoreFromRemovingSubstringTest {

    @Test
    public void testCase1(){
        assertEquals(19, new MaximumScoreFromRemovingSubstring().solve("cdbcbbaaabab", 4, 5));
        assertEquals(20, new MaximumScoreFromRemovingSubstring().solve("cdbcbbaaabab", 5, 5));
    }

}