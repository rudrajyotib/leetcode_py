package interviewbit.solutions;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SortBinaryLinkedListTest {

    @Test
    public void shouldHandleAlreadySortedList(){
        SortBinaryLinkedList.ListNode root = new SortBinaryLinkedList.ListNode(0);
        root.next = new SortBinaryLinkedList.ListNode(0);
        root.next.next = new SortBinaryLinkedList.ListNode(0);
        root.next.next.next = new SortBinaryLinkedList.ListNode(1);
        root.next.next.next.next = new SortBinaryLinkedList.ListNode(1);

        SortBinaryLinkedList.ListNode sortedRoot = new SortBinaryLinkedList().solve(root);

        assertSame(root, sortedRoot);
        assertSame(root.next, sortedRoot.next);
        assertSame(root.next.next.next, sortedRoot.next.next.next);

        List<Integer> list = new ArrayList<>();

        while (root != null){
            list.add(root.val);
            root = root.next;
        }

        assertArrayEquals(new Integer[]{0,0,0,1,1},
                list.toArray(new Integer[1]));

    }

    @Test
    public void shouldHandleZeroOnlyList(){
        SortBinaryLinkedList.ListNode root = new SortBinaryLinkedList.ListNode(0);
        root.next = new SortBinaryLinkedList.ListNode(0);
        root.next.next = new SortBinaryLinkedList.ListNode(0);
        root.next.next.next = new SortBinaryLinkedList.ListNode(0);

        SortBinaryLinkedList.ListNode sortedRoot = new SortBinaryLinkedList().solve(root);

        assertSame(root, sortedRoot);
        assertSame(root.next, sortedRoot.next);
        assertSame(root.next.next.next, sortedRoot.next.next.next);

        List<Integer> list = new ArrayList<>();

        while (root != null){
            list.add(root.val);
            root = root.next;
        }

        assertArrayEquals(new Integer[]{0,0,0,0},
                list.toArray(new Integer[1]));

    }

    @Test
    public void shouldHandleOneOnlyList(){
        SortBinaryLinkedList.ListNode root = new SortBinaryLinkedList.ListNode(1);
        root.next = new SortBinaryLinkedList.ListNode(1);
        root.next.next = new SortBinaryLinkedList.ListNode(1);
        root.next.next.next = new SortBinaryLinkedList.ListNode(1);

        SortBinaryLinkedList.ListNode sortedRoot = new SortBinaryLinkedList().solve(root);

        assertSame(root, sortedRoot);
        assertSame(root.next, sortedRoot.next);
        assertSame(root.next.next.next, sortedRoot.next.next.next);

        List<Integer> list = new ArrayList<>();

        while (root != null){
            list.add(root.val);
            root = root.next;
        }

        assertArrayEquals(new Integer[]{1,1,1,1},
                list.toArray(new Integer[1]));

    }

    @Test
    public void shouldHandleUnsortedList(){
        SortBinaryLinkedList.ListNode root = new SortBinaryLinkedList.ListNode(1);
        root.next = new SortBinaryLinkedList.ListNode(1);
        root.next.next = new SortBinaryLinkedList.ListNode(0);
        root.next.next.next = new SortBinaryLinkedList.ListNode(0);
        root.next.next.next.next = new SortBinaryLinkedList.ListNode(1);

        SortBinaryLinkedList.ListNode sortedRoot = new SortBinaryLinkedList().solve(root);

        assertNotSame(root, sortedRoot);
        assertSame(root, sortedRoot.next.next);


        List<Integer> list = new ArrayList<>();

        while (sortedRoot != null){
            list.add(sortedRoot.val);
            sortedRoot = sortedRoot.next;
        }

        assertArrayEquals(new Integer[]{0,0,1,1,1},
                list.toArray(new Integer[1]));

    }


}