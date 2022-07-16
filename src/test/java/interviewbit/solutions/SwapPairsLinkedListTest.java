package interviewbit.solutions;

import ds.util.ListNode;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

public class SwapPairsLinkedListTest {

    @Test
    public void shouldSwapPairOfEvenSizedList() {
        assertArrayEquals(new Integer[]{2, 1, 4, 3, 6, 5},
                new SwapPairsLinkedList().solve(
                        new ListNode(1,
                                new ListNode(2,
                                        new ListNode(3,
                                                new ListNode(4,
                                                        new ListNode(5,
                                                                new ListNode(6))))))
                ).toList().toArray(new Integer[0]));
    }

    @Test
    public void shouldSwapPairOfOddSizedList() {
        assertArrayEquals(new Integer[]{2, 1, 4, 3, 6, 5, 7},
                new SwapPairsLinkedList().solve(
                        new ListNode(1,
                                new ListNode(2,
                                        new ListNode(3,
                                                new ListNode(4,
                                                        new ListNode(5,
                                                                new ListNode(6,
                                                                        new ListNode(7)))))))
                ).toList().toArray(new Integer[0]));
    }

    @Test
    public void shouldNotSwap() {
        assertArrayEquals(new Integer[]{1},
                new SwapPairsLinkedList().solve(
                        new ListNode(1)
                ).toList().toArray(new Integer[0]));
    }

    @Test
    public void shouldSwapOnlyOnce() {
        assertArrayEquals(new Integer[]{2, 1},
                new SwapPairsLinkedList().solve(
                        new ListNode(1,
                                new ListNode(2))
                ).toList().toArray(new Integer[0]));
    }

    @Test
    public void shouldHandleNull() {
        assertNull(new SwapPairsLinkedList().solve(null));
    }


}