package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseLinkedListTest {

    @Test
    public void shouldReverseLinkedListSet1()
    {
        ReverseLinkedList.ListNode head = new ReverseLinkedList.ListNode(1,
                new ReverseLinkedList.ListNode(2,
                        new ReverseLinkedList.ListNode(3,
                                new ReverseLinkedList.ListNode(4,
                                        new ReverseLinkedList.ListNode(5)))));
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ReverseLinkedList.ListNode reversed = reverseLinkedList.solve(head);
        assertEquals(5, reversed.val);
        assertEquals(4, reversed.next.val);
        assertEquals(3, reversed.next.next.val);
        assertEquals(2, reversed.next.next.next.val);
        assertEquals(1, reversed.next.next.next.next.val);
        assertNull( reversed.next.next.next.next.next);

    }

    @Test
    public void shouldReverseLinkedListSet2()
    {
        ReverseLinkedList.ListNode head = new ReverseLinkedList.ListNode(1);
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ReverseLinkedList.ListNode reversed = reverseLinkedList.solve(head);
        assertEquals(1, reversed.val);
        assertNull( reversed.next);
    }


}