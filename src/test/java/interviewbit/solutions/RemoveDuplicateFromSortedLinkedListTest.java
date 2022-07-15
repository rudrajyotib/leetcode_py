package interviewbit.solutions;

import ds.util.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RemoveDuplicateFromSortedLinkedListTest {

    @Test
    public void shouldHandleDuplicateInTwoNodeList(){
        ListNode root = new ListNode(10);
        root.next = new ListNode(10);

        ListNode result =
                new RemoveDuplicateFromSortedLinkedList().solve(root);

        assertNotNull(result);
        assertEquals(10, result.val);
        assertNull(result.next);
    }

    @Test
    public void shouldHandleDuplicateAtHead(){
        ListNode root = new ListNode(10);
        root.next = new ListNode(10);
        root.next.next = new ListNode(20);
        root.next.next.next = new ListNode(30);

        ListNode result =
                new RemoveDuplicateFromSortedLinkedList().solve(root);

        assertNotNull(result);

        List<Integer> list = new ArrayList<>();

        while (result != null){
            list.add(result.val);
            result = result.next;
        }

        assertArrayEquals(new Integer[]{10, 20, 30},
                list.toArray(new Integer[1]));
    }

    @Test
    public void shouldHandleDuplicateAtTail(){
        ListNode root = new ListNode(10);
        root.next = new ListNode(15);
        root.next.next = new ListNode(20);
        root.next.next.next = new ListNode(30);
        root.next.next.next.next = new ListNode(30);
        root.next.next.next.next.next = new ListNode(30);

        ListNode result =
                new RemoveDuplicateFromSortedLinkedList().solve(root);

        assertNotNull(result);

        List<Integer> list = new ArrayList<>();

        while (result != null){
            list.add(result.val);
            result = result.next;
        }

        assertArrayEquals(new Integer[]{10, 15, 20, 30},
                list.toArray(new Integer[1]));
    }

}