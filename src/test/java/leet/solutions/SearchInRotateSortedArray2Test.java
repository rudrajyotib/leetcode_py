package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class SearchInRotateSortedArray2Test {


    @Test
    public void shouldSearchInRotatedArray()
    {
        SearchInRotateSortedArray2 searchInRotateSortedArray2 = new SearchInRotateSortedArray2();
        assertTrue(searchInRotateSortedArray2.solve(new int[]{5, 5, 7, 10, 12, 1, 2, 3, 4, 4, 4, 5}, 10));
        assertTrue(searchInRotateSortedArray2.solve(new int[]{ 1, 2, 3, 4, 4, 4, 5, 5, 5, 7, 10, 12}, 10));
        assertTrue(searchInRotateSortedArray2.solve(new int[]{12, 1, 2, 3, 4, 4, 4, 5, 5, 5, 7, 10}, 10));
        assertTrue(searchInRotateSortedArray2.solve(new int[]{12, 1, 2, 3, 4, 4, 4, 5, 5, 5, 7, 10}, 4));
        assertFalse(searchInRotateSortedArray2.solve(new int[]{12, 1, 2, 3, 4, 4, 4, 5, 5, 5, 7, 10}, 14));
        assertTrue(searchInRotateSortedArray2.solve(new int[]{1}, 1));
        assertFalse(searchInRotateSortedArray2.solve(new int[]{1}, 0));
        assertTrue(searchInRotateSortedArray2.solve(new int[]{1, 0, 1,1,1}, 0));
    }

}