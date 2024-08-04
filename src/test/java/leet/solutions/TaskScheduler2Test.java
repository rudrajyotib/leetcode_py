package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class TaskScheduler2Test {

    @Test
    public void testCase1(){
        assertEquals(9, new TaskScheduler2().solve(
                new int[]{1,2,1,2,3,1},
                3
        ));

        assertEquals(6, new TaskScheduler2().solve(
                new int[]{5,8,8,5},
                2
        ));
    }

}