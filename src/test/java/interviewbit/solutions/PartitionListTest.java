package interviewbit.solutions;

import ds.util.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PartitionListTest {

    @Test
    public void shouldCreatePartition(){
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(20);
        listNode.next.next.next = new ListNode(50);
        listNode.next.next.next.next = new ListNode(10);

        ListNode sortedList = new PartitionList().solve(listNode, 11);

        assertSame(sortedList, listNode);

        ListNode pointer = sortedList;

        List<Integer> list = new ArrayList<>();

        while (pointer != null){
            list.add(pointer.val);
            pointer = pointer.next;
        }

        assertArrayEquals(new Integer[]{1,2,10,20,50},
                list.toArray(new Integer[1]));
    }


}