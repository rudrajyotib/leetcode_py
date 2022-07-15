package leet.solutions;

import ds.util.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class PartitionListTest {


    @Test
    public void shouldPartitionFromMidway()
    {
        ListNode listNode = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5,
                                                new ListNode(2, new ListNode(6)))))));

        PartitionList partitionList = new PartitionList();
        ListNode result = partitionList.solve(listNode, 4);
        assertEquals(1, result.val);
        assertEquals(2, result.next.val);
        assertEquals(3, result.next.next.val);
        assertEquals(2, result.next.next.next.val);
        assertEquals(4, result.next.next.next.next.val);
        assertEquals(5, result.next.next.next.next.next.val);
        assertEquals(6, result.next.next.next.next.next.next.val);
        assertNull(result.next.next.next.next.next.next.next);
    }

    @Test
    public void shouldPartitionFromHead()
    {
        ListNode listNode = new ListNode(4,
                new ListNode(5,
                        new ListNode(5,
                                new ListNode(6,
                                        new ListNode(2,
                                                new ListNode(6,
                                                    new ListNode(3)))))));
        PartitionList partitionList = new PartitionList();
        ListNode result = partitionList.solve(listNode, 4);
        assertEquals(2, result.val);
        assertEquals(3, result.next.val);
        assertEquals(4, result.next.next.val);
        assertEquals(5, result.next.next.next.val);
        assertEquals(5, result.next.next.next.next.val);
        assertEquals(6, result.next.next.next.next.next.val);
        assertEquals(6, result.next.next.next.next.next.next.val);
        assertNull( result.next.next.next.next.next.next.next);
    }

    @Test
    public void shouldNotPartitionWhenNoElementIsBelowThreshold()
    {
        ListNode listNode = new ListNode(4,
                new ListNode(5,
                        new ListNode(6,
                                new ListNode(7,
                                        new ListNode(8,
                                                new ListNode(9))))));
        PartitionList partitionList = new PartitionList();
        ListNode result = partitionList.solve(listNode, 4);
        assertEquals(4, result.val);
    }

    @Test
    public void shouldNotPartitionWhichIsAlreadyInOrder()
    {
        ListNode listNode = new ListNode(1,
                new ListNode(2,
                        new ListNode(3)));
        PartitionList partitionList = new PartitionList();
        ListNode result = partitionList.solve(listNode, 3);
        assertEquals(1, result.val);
        assertEquals(2, result.next.val);
        assertEquals(3, result.next.next.val);
        assertNull( result.next.next.next);

    }
}