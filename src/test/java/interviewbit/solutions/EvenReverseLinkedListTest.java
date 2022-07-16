package interviewbit.solutions;

import ds.util.ListNode;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

public class EvenReverseLinkedListTest {

    @Test
    public void shouldReverseEvenSizedList() {
        assertArrayEquals(new Integer[]{1, 6, 3, 4, 5, 2},
                new EvenReverseLinkedList().solve(
                        new ListNode(1,
                                new ListNode(2,
                                        new ListNode(3,
                                                new ListNode(4,
                                                        new ListNode(5,
                                                                new ListNode(6))))))
                ).toList().toArray(new Integer[0]));
    }

    @Test
    public void shouldReverseOddSizedList() {
        assertArrayEquals(new Integer[]{1, 6, 3, 4, 5, 2, 7},
                new EvenReverseLinkedList().solve(
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
    public void shouldNotReverseSet1() {
        assertArrayEquals(new Integer[]{1, 2},
                new EvenReverseLinkedList().solve(
                        new ListNode(1,
                                new ListNode(2))
                ).toList().toArray(new Integer[0]));
    }

    @Test
    public void shouldNotReverseSet2() {
        assertArrayEquals(new Integer[]{1, 2, 3},
                new EvenReverseLinkedList().solve(
                        new ListNode(1,
                                new ListNode(2,
                                        new ListNode(3)))
                ).toList().toArray(new Integer[0]));
    }

    @Test
    public void shouldHandleSingleNode() {
        assertArrayEquals(new Integer[]{1},
                new EvenReverseLinkedList().solve(
                        new ListNode(1)
                ).toList().toArray(new Integer[0]));
    }

    @Test
    public void shouldHandleNull() {
        assertNull(new EvenReverseLinkedList().solve(null));
    }

}