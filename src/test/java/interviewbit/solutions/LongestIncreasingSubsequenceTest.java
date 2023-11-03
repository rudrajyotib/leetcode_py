package interviewbit.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestIncreasingSubsequenceTest {

    @Test
    public void set1(){
        assertEquals(3, new LongestIncreasingSubsequence().solve(new int[]{1,2,1,5}));
        assertEquals(6, new LongestIncreasingSubsequence().solve(new int[]{0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15}));
        assertEquals(1, new LongestIncreasingSubsequence().solve(new int[]{5,4,3,2,1}));
    }

    @Test
    public void set2(){
        assertEquals(15, new LongestIncreasingSubsequence().solve(new int[]{69, 54, 19, 51, 16, 54, 64, 89, 72, 40, 31, 43, 1, 11, 82, 65, 75, 67, 25, 98, 31, 77, 55, 88, 85, 76, 35, 101, 44, 74, 29, 94, 72, 39, 20, 24, 23, 66, 16, 95, 5, 17, 54, 89, 93, 10, 7, 88, 68, 10, 11, 22, 25, 50, 18, 59, 79, 87, 7, 49, 26, 96, 27, 19, 67, 35, 50, 10, 6, 48, 38, 28, 66, 94, 60, 27, 76, 4, 43, 66, 14, 8, 78, 72, 21, 56, 34, 90, 89 }));
    }


}