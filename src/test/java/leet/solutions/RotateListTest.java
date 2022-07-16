package leet.solutions;

import ds.util.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class RotateListTest {

    @Test
    public void shouldShiftLessThanSizeTimes()
    {
        RotateList rotateList = new RotateList();
        ListNode node0 = new ListNode(0,
                new ListNode(1,
                        new ListNode(2,
                            new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5))))));
        ListNode updatedNode = rotateList.solve(node0, 2);
        assertEquals(4, updatedNode.val);
        assertEquals(3, updatedNode.next.next.next.next.next.val);
        assertNull( updatedNode.next.next.next.next.next.next);
        assertArrayEquals(new Integer[]{4,5,0,1,2,3}, updatedNode.toList().toArray(new Integer[0]));
    }

    @Test
    public void shouldShiftGreaterThanSizeTimes()
    {
        RotateList rotateList = new RotateList();
        ListNode node0 = new ListNode(0,
                new ListNode(1,
                        new ListNode(2,
                            new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5))))));
        ListNode updatedNode = rotateList.solve(node0, 38);
        assertEquals(4, updatedNode.val);
        assertEquals(3, updatedNode.next.next.next.next.next.val);
        assertNull( updatedNode.next.next.next.next.next.next);
    }

    @Test
    public void shouldNotMoveWhenShiftIsDivisibleBySize()
    {
        RotateList rotateList = new RotateList();
        ListNode node0 = new ListNode(0,
                new ListNode(1,
                        new ListNode(2,
                            new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5))))));
        ListNode updatedNode = rotateList.solve(node0, 36);
        assertEquals(0, updatedNode.val);
        assertEquals(5, updatedNode.next.next.next.next.next.val);
        assertNull( updatedNode.next.next.next.next.next.next);
        assertSame(node0, updatedNode);
    }

    @Test
    public void shouldHandleNull()
    {
        RotateList rotateList = new RotateList();
        assertNull(rotateList.solve(null, 10));
    }

    @Test
    public void shouldHandleSingleNodeRotate()
    {
        RotateList rotateList = new RotateList();
        ListNode node0 = new ListNode(0);
        ListNode updated = rotateList.solve(node0, 10000);
        assertSame(node0, updated);
    }

}