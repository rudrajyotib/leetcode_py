package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinimumInSortedRotatedArrayTest {

    @Test
    public void shouldFindMinimumInSortedRotatedArray()
    {
        MinimumInSortedRotatedArray minimumInSortedRotatedArray = new MinimumInSortedRotatedArray();
        assertEquals(0, minimumInSortedRotatedArray.solve(new int[]{0,1,2,3,4}));
        assertEquals(0, minimumInSortedRotatedArray.solve(new int[]{0,1}));
        assertEquals(0, minimumInSortedRotatedArray.solve(new int[]{1,0}));
        assertEquals(0, minimumInSortedRotatedArray.solve(new int[]{0}));
        assertEquals(0, minimumInSortedRotatedArray.solve(new int[]{4,5,6,7,0,1,2,3}));
        assertEquals(0, minimumInSortedRotatedArray.solve(new int[]{6,6,6,6,6,6,6,6,6,46,56,66,67,0,1,2,3,4,5}));
        assertEquals(0, minimumInSortedRotatedArray.solve(new int[]{2, 3, 0}));
    }


}