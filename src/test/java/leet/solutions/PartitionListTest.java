package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class PartitionListTest {


    @Test
    public void shouldPartitionFromMidway()
    {
        PartitionList.ListNode listNode = new PartitionList.ListNode(1,
                new PartitionList.ListNode(2,
                        new PartitionList.ListNode(3,
                                new PartitionList.ListNode(4,
                                        new PartitionList.ListNode(5,
                                                new PartitionList.ListNode(2, new PartitionList.ListNode(6)))))));

        PartitionList partitionList = new PartitionList();
        PartitionList.ListNode result = partitionList.solve(listNode, 4);
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
        PartitionList.ListNode listNode = new PartitionList.ListNode(4,
                new PartitionList.ListNode(5,
                        new PartitionList.ListNode(5,
                                new PartitionList.ListNode(6,
                                        new PartitionList.ListNode(2,
                                                new PartitionList.ListNode(6,
                                                    new PartitionList.ListNode(3)))))));
        PartitionList partitionList = new PartitionList();
        PartitionList.ListNode result = partitionList.solve(listNode, 4);
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
        PartitionList.ListNode listNode = new PartitionList.ListNode(4,
                new PartitionList.ListNode(5,
                        new PartitionList.ListNode(6,
                                new PartitionList.ListNode(7,
                                        new PartitionList.ListNode(8,
                                                new PartitionList.ListNode(9))))));
        PartitionList partitionList = new PartitionList();
        PartitionList.ListNode result = partitionList.solve(listNode, 4);
        assertEquals(4, result.val);
    }

    @Test
    public void shouldNotPartitionWhichIsAlreadyInOrder()
    {
        PartitionList.ListNode listNode = new PartitionList.ListNode(1,
                new PartitionList.ListNode(2,
                        new PartitionList.ListNode(3)));
        PartitionList partitionList = new PartitionList();
        PartitionList.ListNode result = partitionList.solve(listNode, 3);
        assertEquals(1, result.val);
        assertEquals(2, result.next.val);
        assertEquals(3, result.next.next.val);
        assertNull( result.next.next.next);

    }
}