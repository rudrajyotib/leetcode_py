package leet.solutions;

import ds.util.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListCycleTest {

    @Test
    public void shouldDetectCycleSet1()
    {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        head.next = node1;
        ListNode node2 = new ListNode(3);
        node1.next = node2;
        ListNode node3 = new ListNode(4);
        node2.next = node3;
        node3.next = node1;
        LinkedListCycle linkedListCycle = new LinkedListCycle();
        assertTrue(linkedListCycle.solve(head));
    }

    @Test
    public void shouldDetectCycleSet2()
    {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        head.next = node1;
        ListNode node2 = new ListNode(3);
        node1.next = node2;
        ListNode node3 = new ListNode(4);
        node2.next = node3;
        node3.next = new ListNode(5);
        LinkedListCycle linkedListCycle = new LinkedListCycle();
        assertFalse(linkedListCycle.solve(head));
    }


}