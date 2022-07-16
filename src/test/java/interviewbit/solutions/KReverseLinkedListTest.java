package interviewbit.solutions;

import ds.util.ListNode;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class KReverseLinkedListTest {

    @Test
    public void shouldReverseInBatches() {
        assertArrayEquals(new Integer[]{2, 1, 4, 3, 6, 5},
                new KReverseLinkedList().solve(
                        new ListNode(1,
                                new ListNode(2,
                                        new ListNode(3,
                                                new ListNode(4,
                                                        new ListNode(5,
                                                                new ListNode(6)))))), 2
                ).toList().toArray(new Integer[0]));
    }

    @Test
    public void shouldReverseEntireList() {
        assertArrayEquals(new Integer[]{6, 5, 4, 3, 2, 1},
                new KReverseLinkedList().solve(
                        new ListNode(1,
                                new ListNode(2,
                                        new ListNode(3,
                                                new ListNode(4,
                                                        new ListNode(5,
                                                                new ListNode(6)))))), 6
                ).toList().toArray(new Integer[0]));
    }

    @Test
    public void shouldNotReverse() {
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 6},
                new KReverseLinkedList().solve(
                        new ListNode(1,
                                new ListNode(2,
                                        new ListNode(3,
                                                new ListNode(4,
                                                        new ListNode(5,
                                                                new ListNode(6)))))), 1
                ).toList().toArray(new Integer[0]));
    }


}