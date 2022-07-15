package leet.solutions;

import ds.util.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReorderListTest {

    @Test
    public void shouldReorderSet1()
    {
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))));

        ReorderList reorderList = new ReorderList();
        reorderList.solve(head);

        assertEquals(1, head.val);
        assertEquals(5, head.next.val);
        assertEquals(2, head.next.next.val);
        assertEquals(4, head.next.next.next.val);
        assertEquals(3, head.next.next.next.next.val);
        assertNull(head.next.next.next.next.next);

    }

    @Test
    public void shouldReorderSet2()
    {
        ListNode head = new ListNode(1,
                new ListNode(2));

        ReorderList reorderList = new ReorderList();
        reorderList.solve(head);

        assertEquals(1, head.val);
        assertEquals(2, head.next.val);
        assertNull(head.next.next);

    }


}