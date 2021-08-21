package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListCycleTest {

    @Test
    public void shouldDetectCycleSet1()
    {
        LinkedListCycle.ListNode head = new LinkedListCycle.ListNode(1);
        LinkedListCycle.ListNode node1 = new LinkedListCycle.ListNode(2);
        head.next = node1;
        LinkedListCycle.ListNode node2 = new LinkedListCycle.ListNode(3);
        node1.next = node2;
        LinkedListCycle.ListNode node3 = new LinkedListCycle.ListNode(4);
        node2.next = node3;
        node3.next = node1;
        LinkedListCycle linkedListCycle = new LinkedListCycle();
        assertTrue(linkedListCycle.solve(head));
    }

    @Test
    public void shouldDetectCycleSet2()
    {
        LinkedListCycle.ListNode head = new LinkedListCycle.ListNode(1);
        LinkedListCycle.ListNode node1 = new LinkedListCycle.ListNode(2);
        head.next = node1;
        LinkedListCycle.ListNode node2 = new LinkedListCycle.ListNode(3);
        node1.next = node2;
        LinkedListCycle.ListNode node3 = new LinkedListCycle.ListNode(4);
        node2.next = node3;
        node3.next = new LinkedListCycle.ListNode(5);
        LinkedListCycle linkedListCycle = new LinkedListCycle();
        assertFalse(linkedListCycle.solve(head));
    }


}