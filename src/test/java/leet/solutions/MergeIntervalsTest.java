package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class MergeIntervalsTest {


    @Test
    public void shouldMerge()
    {
        MergeIntervals mergeIntervals = new MergeIntervals();
        assertArrayEquals(new int[][]{{0,4}, {8, 12}}, mergeIntervals.solve(new int[][]{{1,2},{2,4},{8,12},{0,1}}));
        assertArrayEquals(new int[][]{{0,9}, {10, 12}}, mergeIntervals.solve(new int[][]{{1,2},{3,9},{1,3},{1,4},{0,5},{2,7}, {10,12}}));
        assertArrayEquals(new int[][]{{0,4}, {8, 12}}, mergeIntervals.solve(new int[][]{{1,2},{2,4},{8,12},{0,1}}));
        assertArrayEquals(new int[][]{{1, 12}}, mergeIntervals.solve(new int[][]{{1,2},{2,4},{4,8},{8,12}}));
        assertArrayEquals(new int[][]{{1, 12}}, mergeIntervals.solve(new int[][]{{1,12}}));
    }

}