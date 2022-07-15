package interviewbit.solutions;

import ds.util.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class MergeTwoSortedLinkedListsTest {

    @Test
    public void shouldMergeTwoIntertwinedList(){
        assertArrayEquals(new Integer[]{1,2,3,4,5,6},
                new MergeTwoSortedLinkedLists().solve(
                        new ListNode(1,
                                new ListNode(3,
                                        new ListNode(5))),
                        new ListNode(2,
                                new ListNode(4,
                                        new ListNode(6)))
                ).toList().toArray(new Integer[0]));
    }

    @Test
    public void shouldMergeTwoIntertwinedListWithDuplicates(){
        assertArrayEquals(new Integer[]{1,2,3,4,5,5,6},
                new MergeTwoSortedLinkedLists().solve(
                        new ListNode(1,
                                new ListNode(3,
                                        new ListNode(5))),
                        new ListNode(2,
                                new ListNode(4,
                                        new ListNode(5,
                                                new ListNode(6))))
                ).toList().toArray(new Integer[0]));
    }

    @Test
    public void shouldMergeTwoListsWhichDoNotOverlap(){
        assertArrayEquals(new Integer[]{1,2,3,4,5,6},
                new MergeTwoSortedLinkedLists().solve(
                        new ListNode(1,
                                new ListNode(2,
                                        new ListNode(3))),
                        new ListNode(4,
                                new ListNode(5,
                                        new ListNode(6)))
                ).toList().toArray(new Integer[0]));
    }

    @Test
    public void shouldHandleNullList(){
        assertArrayEquals(new Integer[]{1,2,3},
                new MergeTwoSortedLinkedLists().solve(
                        new ListNode(1,
                                new ListNode(2,
                                        new ListNode(3))),
                        null
                ).toList().toArray(new Integer[0]));
        assertArrayEquals(new Integer[]{1,2,3},
                new MergeTwoSortedLinkedLists().solve(
                        null,
                        new ListNode(1,
                                new ListNode(2,
                                        new ListNode(3)))
                ).toList().toArray(new Integer[0]));
    }

}