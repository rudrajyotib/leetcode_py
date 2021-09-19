package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class KthLargestElementInArrayTest {

    @Test
    public void shouldFindKthLargestFromDistinctElements()
    {
        KthLargestElementInArray kthLargestElementInArray = new KthLargestElementInArray();
        assertEquals(3, kthLargestElementInArray.solve(new int[]{1,2,3,4,5}, 3));
    }

    @Test
    public void shouldFindKthLargestFromArrayWithDuplicateElements()
    {
        KthLargestElementInArray kthLargestElementInArray = new KthLargestElementInArray();
        assertEquals(4, kthLargestElementInArray.solve(new int[]{1,2,3,4,4,4,5}, 3));
    }

    @Test
    public void shouldFindFirstLargestElement()
    {
        KthLargestElementInArray kthLargestElementInArray = new KthLargestElementInArray();
        assertEquals(5, kthLargestElementInArray.solve(new int[]{1,2,3,4,5}, 1));
    }


}
