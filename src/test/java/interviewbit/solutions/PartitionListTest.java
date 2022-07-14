package interviewbit.solutions;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PartitionListTest {

    @Test
    public void shouldCreatePartition(){
        PartitionList.ListNode listNode = new PartitionList.ListNode(1);
        listNode.next = new PartitionList.ListNode(2);
        listNode.next.next = new PartitionList.ListNode(20);
        listNode.next.next.next = new PartitionList.ListNode(50);
        listNode.next.next.next.next = new PartitionList.ListNode(10);

        PartitionList.ListNode sortedList = new PartitionList().solve(listNode, 11);

        assertSame(sortedList, listNode);

        PartitionList.ListNode pointer = sortedList;

        List<Integer> list = new ArrayList<>();

        while (pointer != null){
            list.add(pointer.val);
            pointer = pointer.next;
        }

        assertArrayEquals(new Integer[]{1,2,10,20,50},
                list.toArray(new Integer[1]));
    }


}