package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KthLargestTest {

    @Test
    public void testCase1() {
        KthLargest kthLargest = new KthLargest(3, new int[]{1, 2, 3, 4, 5});
        assertEquals(3, kthLargest.add(2));
        assertEquals(3, kthLargest.add(1));
        assertEquals(3, kthLargest.add(3));
        assertEquals(4, kthLargest.add(6));
    }

    @Test
    public void testCase2() {
        KthLargest kthLargest = new KthLargest(3, new int[]{1, 2, 3});
        assertEquals(2, kthLargest.add(2));
        assertEquals(2, kthLargest.add(4));
        assertEquals(3, kthLargest.add(4));
        assertEquals(4, kthLargest.add(4));
        assertEquals(4, kthLargest.add(5));
    }

    @Test
    public void testCase3() {
        KthLargest kthLargest = new KthLargest(1, new int[]{});
        assertEquals(2, kthLargest.add(2));
        assertEquals(4, kthLargest.add(4));
        assertEquals(4, kthLargest.add(4));
        assertEquals(4, kthLargest.add(4));
        assertEquals(5, kthLargest.add(5));
    }

}