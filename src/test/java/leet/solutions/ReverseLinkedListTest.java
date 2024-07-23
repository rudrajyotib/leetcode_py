package leet.solutions;

import ds.util.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseLinkedListTest {

    @Test
    public void shouldReverseLinkedListSet1()
    {
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))));
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode reversed = reverseLinkedList.solve(head, false);
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
        ListNode head = new ListNode(1);
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode reversed = reverseLinkedList.solve(head,false);
        assertEquals(1, reversed.val);
        assertNull( reversed.next);
    }

    @Test
    public void shouldReverseLinkedListStackSet1()
    {
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))));
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode reversed = reverseLinkedList.solve(head, true);
        assertEquals(5, reversed.val);
        assertEquals(4, reversed.next.val);
        assertEquals(3, reversed.next.next.val);
        assertEquals(2, reversed.next.next.next.val);
        assertEquals(1, reversed.next.next.next.next.val);
        assertNull( reversed.next.next.next.next.next);

    }

    @Test
    public void shouldReverseLinkedListStackSet2()
    {
        ListNode head = new ListNode(1);
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode reversed = reverseLinkedList.solve(head, true);
        assertEquals(1, reversed.val);
        assertNull( reversed.next);
    }


}