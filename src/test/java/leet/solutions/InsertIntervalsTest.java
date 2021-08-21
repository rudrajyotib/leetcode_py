package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class InsertIntervalsTest {

    @Test
    public void shouldInsertNewInterval()
    {
        InsertIntervals insertIntervals = new InsertIntervals();
        assertArrayEquals(new int[][]{{1,2}, {3,4}, {5,6}}, insertIntervals.solve(new int[][]{{1,2}, {3,4}}, new int[]{5,6}));
        assertArrayEquals(new int[][]{{1, 4}, {5,6}}, insertIntervals.solve(new int[][]{{1,2}, {5,6}}, new int[]{2,4}));
        assertArrayEquals(new int[][]{{1, 2}, {10,15}, {50,60}}, insertIntervals.solve(new int[][]{{1,2}, {50,60}}, new int[]{10, 15}));
        assertArrayEquals(new int[][]{{1, 2}, {10,60}}, insertIntervals.solve(new int[][]{{1,2}, {50,60}}, new int[]{10, 55}));
        assertArrayEquals(new int[][]{{1, 2}, {10,60}}, insertIntervals.solve(new int[][]{{10, 60}}, new int[]{1,2}));
        assertArrayEquals(new int[][]{{1, 60}}, insertIntervals.solve(new int[][]{{1, 60}}, new int[]{2,3}));
        assertArrayEquals(new int[][]{{1, 60}}, insertIntervals.solve(new int[][]{{1, 60}}, new int[]{1,3}));
        assertArrayEquals(new int[][]{{1, 60}}, insertIntervals.solve(new int[][]{{1, 60}}, new int[]{59,60}));
        assertArrayEquals(new int[][]{{1, 63}}, insertIntervals.solve(new int[][]{{1, 60}}, new int[]{59,63}));
        assertArrayEquals(new int[][]{{1, 63}}, insertIntervals.solve(new int[][]{{3, 60}}, new int[]{1,63}));
        assertArrayEquals(new int[][]{{1, 10}, {15, 30}}, insertIntervals.solve(new int[][]{{1, 10}, {20, 25}}, new int[]{15,30}));
    }


}