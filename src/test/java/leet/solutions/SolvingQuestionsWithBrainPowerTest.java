package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolvingQuestionsWithBrainPowerTest {

    @Test
    public void testCase1(){
        assertEquals(7, new SolvingQuestionsWithBrainPower().solve(
                new int[][]{
                        new int[]{1,1},
                        new int[]{2,2},
                        new int[]{3,3},
                        new int[]{4,4},
                        new int[]{5,5},
                }
        ));
    }

}