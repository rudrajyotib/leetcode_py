package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class AverageWaitingTimeTest {

    @Test
    public void testCase1(){
        assertEquals(5.0d, new AverageWaitingTime().solve(
                new int[][]{
                        new int[]{1,2},
                        new int[]{2,5},
                        new int[]{4,3}
                }
        ), 0.000001d);
    }

    @Test
    public void testCase2(){
        assertEquals(3.25d, new AverageWaitingTime().solve(
                new int[][]{
                        new int[]{5,2},
                        new int[]{5,4},
                        new int[]{10,3},
                        new int[]{20,1}
                }
        ), 0.000001d);
    }

}