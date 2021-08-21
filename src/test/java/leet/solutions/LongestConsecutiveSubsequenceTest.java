package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestConsecutiveSubsequenceTest {


    @Test
    public void shouldCountMaxConsecutive()
    {
        LongestConsecutiveSubsequence longestConsecutiveSubsequence = new LongestConsecutiveSubsequence();
        assertEquals(1, longestConsecutiveSubsequence.solve(new int[]{1, 3, 5, 7}));
        assertEquals(3, longestConsecutiveSubsequence.solve(new int[]{1, 3, 5, 7, 2}));
        assertEquals(7, longestConsecutiveSubsequence.solve(new int[]{1, 3, 5, 7, 2, 4, 6}));
        assertEquals(11, longestConsecutiveSubsequence.solve(new int[]{1, 3, 5, 7, 2, 4, 6, -3, -1, -2, 0}));
        assertEquals(16, longestConsecutiveSubsequence.solve(new int[]{1, 3, 5, 7, 2, 4, 6, -3, -1, -2, 0, 4, 4, 9, 10, 11, 12, 8 }));
        assertEquals(3, longestConsecutiveSubsequence.solve(new int[]{-4, -6, -8, -7 }));
        assertEquals(7, longestConsecutiveSubsequence.solve(new int[]{-4, -6, -8, -7, -2, -3, -5 }));
        assertEquals(3, longestConsecutiveSubsequence.solve(new int[]{11, 12, 10 }));
        assertEquals(6, longestConsecutiveSubsequence.solve(new int[]{4,8,7,12,11,10,9 }));
        assertEquals(13, longestConsecutiveSubsequence.solve(new int[]{-5,0,2,-3,7,-4,6,-2,1,4,3,-1,5 }));
        assertEquals(7, longestConsecutiveSubsequence.solve(new int[]{3,4,5,7,8,9,6,6,6,6 }));
    }

}