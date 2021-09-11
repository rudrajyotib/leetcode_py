package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class RotateListTest {

    @Test
    public void shouldShiftLessThanSizeTimes()
    {
        RotateList rotateList = new RotateList();
        RotateList.ListNode node0 = new RotateList.ListNode(0,
                new RotateList.ListNode(1,
                        new RotateList.ListNode(2,
                            new RotateList.ListNode(3,
                                new RotateList.ListNode(4,
                                        new RotateList.ListNode(5))))));
        RotateList.ListNode updatedNode = rotateList.solve(node0, 2);
        assertEquals(4, updatedNode.val);
        assertEquals(3, updatedNode.next.next.next.next.next.val);
        assertNull( updatedNode.next.next.next.next.next.next);
    }

    @Test
    public void shouldShiftGreaterThanSizeTimes()
    {
        RotateList rotateList = new RotateList();
        RotateList.ListNode node0 = new RotateList.ListNode(0,
                new RotateList.ListNode(1,
                        new RotateList.ListNode(2,
                            new RotateList.ListNode(3,
                                new RotateList.ListNode(4,
                                        new RotateList.ListNode(5))))));
        RotateList.ListNode updatedNode = rotateList.solve(node0, 38);
        assertEquals(4, updatedNode.val);
        assertEquals(3, updatedNode.next.next.next.next.next.val);
        assertNull( updatedNode.next.next.next.next.next.next);
    }

    @Test
    public void shouldNotMoveWhenShiftIsDivisibleBySize()
    {
        RotateList rotateList = new RotateList();
        RotateList.ListNode node0 = new RotateList.ListNode(0,
                new RotateList.ListNode(1,
                        new RotateList.ListNode(2,
                            new RotateList.ListNode(3,
                                new RotateList.ListNode(4,
                                        new RotateList.ListNode(5))))));
        RotateList.ListNode updatedNode = rotateList.solve(node0, 36);
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
        RotateList.ListNode node0 = new RotateList.ListNode(0);
        RotateList.ListNode updated = rotateList.solve(node0, 10000);
        assertSame(node0, updated);
    }

}