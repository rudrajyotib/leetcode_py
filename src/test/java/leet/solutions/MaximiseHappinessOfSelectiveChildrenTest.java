package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaximiseHappinessOfSelectiveChildrenTest {

    @Test
    public void testCase1(){
        assertEquals(4, new MaximiseHappinessOfSelectiveChildren().solve(
                new int[]{1,2,3}, 2
        ));
        assertEquals(4, new MaximiseHappinessOfSelectiveChildren().solve(
                new int[]{1,1,2,3}, 3
        ));
    }

}