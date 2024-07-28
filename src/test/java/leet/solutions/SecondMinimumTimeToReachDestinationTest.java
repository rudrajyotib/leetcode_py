package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class SecondMinimumTimeToReachDestinationTest {

    @Test
    public void testCase1(){
        assertEquals(13, new SecondMinimumTimeToReachDestination().solve(
                5,
                new int[][]{
                        new int[]{1,2},
                        new int[]{1,3},
                        new int[]{1,4},
                        new int[]{3,4},
                        new int[]{4,5},
                },
                3,
                5
        ));
    }


}