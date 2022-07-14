package interviewbit.solutions;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RemoveDuplicateFromSortedLinkedListTest {

    @Test
    public void shouldHandleDuplicateInTwoNodeList(){
        RemoveDuplicateFromSortedLinkedList.ListNode root = new RemoveDuplicateFromSortedLinkedList.ListNode(10);
        root.next = new RemoveDuplicateFromSortedLinkedList.ListNode(10);

        RemoveDuplicateFromSortedLinkedList.ListNode result =
                new RemoveDuplicateFromSortedLinkedList().solve(root);

        assertNotNull(result);
        assertEquals(10, result.val);
        assertNull(result.next);
    }

    @Test
    public void shouldHandleDuplicateAtHead(){
        RemoveDuplicateFromSortedLinkedList.ListNode root = new RemoveDuplicateFromSortedLinkedList.ListNode(10);
        root.next = new RemoveDuplicateFromSortedLinkedList.ListNode(10);
        root.next.next = new RemoveDuplicateFromSortedLinkedList.ListNode(20);
        root.next.next.next = new RemoveDuplicateFromSortedLinkedList.ListNode(30);

        RemoveDuplicateFromSortedLinkedList.ListNode result =
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
        RemoveDuplicateFromSortedLinkedList.ListNode root = new RemoveDuplicateFromSortedLinkedList.ListNode(10);
        root.next = new RemoveDuplicateFromSortedLinkedList.ListNode(15);
        root.next.next = new RemoveDuplicateFromSortedLinkedList.ListNode(20);
        root.next.next.next = new RemoveDuplicateFromSortedLinkedList.ListNode(30);
        root.next.next.next.next = new RemoveDuplicateFromSortedLinkedList.ListNode(30);
        root.next.next.next.next.next = new RemoveDuplicateFromSortedLinkedList.ListNode(30);

        RemoveDuplicateFromSortedLinkedList.ListNode result =
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