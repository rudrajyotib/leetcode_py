package interviewbit.solutions;

import ds.util.ListNode;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

public class SortListTest {

    @Test
    public void shouldSortRandomLinkedList() {
        ListNode sortedList =
                new SortList().solve(new ListNode(10,
                        new ListNode(20,
                                new ListNode(4,
                                        new ListNode(2,
                                                new ListNode(14,
                                                        new ListNode(1,
                                                                new ListNode(100))))))));

        assertArrayEquals(new Integer[]{1, 2, 4, 10, 14, 20, 100},
                sortedList.toList().toArray(new Integer[1]));

    }

    @Test
    public void shouldSortReverseSortedLinkedList() {
        ListNode sortedList = new SortList().solve(
                new ListNode(20,
                        new ListNode(19,
                                new ListNode(18,
                                        new ListNode(17,
                                                new ListNode(16,
                                                        new ListNode(15,
                                                                new ListNode(14)))))))
        );

        assertArrayEquals(new Integer[]{14, 15, 16, 17, 18, 19, 20},
                sortedList.toList().toArray(new Integer[1]));
    }

    @Test
    public void shouldSortAlreadySortedList() {
        ListNode sortedList = new SortList().solve(
               new ListNode(14,
                       new ListNode(15,
                               new ListNode(16,
                                       new ListNode(17,
                                               new ListNode(18,
                                                       new ListNode(19,
                                                               new ListNode(20)))))))
        );

        assertArrayEquals(new Integer[]{14, 15, 16, 17, 18, 19, 20},
                sortedList.toList().toArray(new Integer[1]));
    }

    @Test
    public void shouldHandleSingleNode() {
        ListNode sortedList = new SortList().solve(
               new ListNode(14)
        );

        assertArrayEquals(new Integer[]{14},
                sortedList.toList().toArray(new Integer[1]));
    }

    @Test
    public void shouldHandleNull(){
        assertNull(new SortList().solve(null));
    }


}