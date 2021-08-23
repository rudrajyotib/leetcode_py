package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class TopKFrquentElementsTest {

    @Test
    public void shouldFindFrequentedElements()
    {
        TopKFrquentElements topKFrquentElements = new TopKFrquentElements();
        assertArrayEquals(new int[]{2,1}, topKFrquentElements.solve(new int[]{1,1,1,2,2,3}, 2));
        assertArrayEquals(new int[]{2,1}, topKFrquentElements.solve(new int[]{1,1,1,2,2,3, 4, 5, 6, 7, 8}, 2));
    }


}