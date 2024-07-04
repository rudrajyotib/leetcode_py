package interviewbit.solutions;

import ds.util.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class MergeKSortedListsTest {

    @Test
    public void shouldMergeLists() {
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 6, 8, 12, 20, 25, 30, 40, 100, 500, 1001, 2000},
                new MergeKSortedLists().solvePriorityQueue(
                        new ArrayList<>(
                                List.of(new ListNode(1,
                                                new ListNode(4,
                                                        new ListNode(100))),
                                        new ListNode(2,
                                                new ListNode(40,
                                                        new ListNode(1001))),
                                        new ListNode(3,
                                                new ListNode(12,
                                                        new ListNode(500))),
                                        new ListNode(6,
                                                new ListNode(8,
                                                        new ListNode(20))),
                                        new ListNode(25,
                                                new ListNode(30,
                                                        new ListNode(2000))))
                        )).toList().toArray(new Integer[0]));

        assertArrayEquals(new Integer[]{1, 2, 3, 4, 6, 8, 12, 20, 25, 30, 40, 100, 500, 1001, 2000},
                new MergeKSortedLists().solveHeap(
                        new ArrayList<>(
                                List.of(new ListNode(1,
                                                new ListNode(4,
                                                        new ListNode(100))),
                                        new ListNode(2,
                                                new ListNode(40,
                                                        new ListNode(1001))),
                                        new ListNode(3,
                                                new ListNode(12,
                                                        new ListNode(500))),
                                        new ListNode(6,
                                                new ListNode(8,
                                                        new ListNode(20))),
                                        new ListNode(25,
                                                new ListNode(30,
                                                        new ListNode(2000))))
                        )).toList().toArray(new Integer[0]));
    }

    @Test
    public void shouldMergeListOfSingleNodes(){
        assertArrayEquals(new Integer[]{1,2,3,5},
                new MergeKSortedLists().solveHeap(
                        new ArrayList<>(
                                List.of(new ListNode(1),
                                        new ListNode(2),
                                        new ListNode(5),
                                        new ListNode(3))
                        )
                ).toList().toArray(new Integer[0]));
        assertArrayEquals(new Integer[]{1,2,3,5},
                new MergeKSortedLists().solvePriorityQueue(
                        new ArrayList<>(
                                List.of(new ListNode(1),
                                        new ListNode(2),
                                        new ListNode(5),
                                        new ListNode(3))
                        )
                ).toList().toArray(new Integer[0]));
    }


}