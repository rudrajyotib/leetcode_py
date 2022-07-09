package interviewbit.coderlift.july2022;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaximumPossibleScoreTest {

    @Test
    public void shouldMaximiseScoreSet1(){
        assertEquals(26, new MaximumPossibleScore.Solution().solve(new int[]{1,2,0,8,7,3,2},
                new int[]{2,3,4,3,0,6,3}));
    }

}