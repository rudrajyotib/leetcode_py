package interviewbit.solutions;

import ds.util.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class RemoveDuplicatesFromSortedList2Test {

    @Test
    public void shouldDeleteDuplicateElementsFromHeadAndTailAndMidAndReturnDistinctElements(){
        assertArrayEquals(new Integer[]{10,11,12},
                new RemoveDuplicatesFromSortedList2().solve(
                        new ListNode(1,
                                new ListNode(1,
                                        new ListNode(2,
                                                new ListNode(2,
                                                        new ListNode(2,
                                                                new ListNode(10,
                                                                        new ListNode(11,
                                                                                new ListNode(12,
                                                                                        new ListNode(14,
                                                                                                new ListNode(14))))))))))
                ).toList().toArray(new Integer[0]));
    }

    @Test
    public void shouldDeleteDuplicateFromTail(){
        assertArrayEquals(new Integer[]{1,2,3},
                new RemoveDuplicatesFromSortedList2().solve(
                        new ListNode(1,
                                new ListNode(2,
                                        new ListNode(3,
                                                new ListNode(4,
                                                        new ListNode(4)))))
                ).toList().toArray(new Integer[0]));
    }

    @Test
    public void testCase1(){
        assertArrayEquals(new Integer[]{3},
                new RemoveDuplicatesFromSortedList2().solve(
                        new ListNode(1,
                                new ListNode(1,
                                        new ListNode(3,
                                                new ListNode(4,
                                                        new ListNode(4)))))
                ).toList().toArray(new Integer[0]));
    }

    @Test
    public void testCase2(){
        assertArrayEquals(new Integer[]{2},
                new RemoveDuplicatesFromSortedList2().solve(
                        new ListNode(1,
                                new ListNode(1,
                                        new ListNode(2)))
                ).toList().toArray(new Integer[0]));
    }


    @Test
    public void shouldDeleteDuplicateFromHead(){
        assertArrayEquals(new Integer[]{2,3,4},
                new RemoveDuplicatesFromSortedList2().solve(
                        new ListNode(1,
                                new ListNode(1,
                                        new ListNode(2,
                                                new ListNode(3,
                                                        new ListNode(4)))))
                ).toList().toArray(new Integer[0]));
    }

    @Test
    public void shouldDeleteDuplicatesAndReturnSingleElement(){
        assertArrayEquals(new Integer[]{3},
                new RemoveDuplicatesFromSortedList2().solve(
                        new ListNode(1,
                                new ListNode(1,
                                        new ListNode(3,
                                                new ListNode(4,
                                                        new ListNode(4)))))
                ).toList().toArray(new Integer[0]));
    }

    @Test
    public void shouldDeleteDuplicatesAndReturnEmptyList(){
        assertNull(new RemoveDuplicatesFromSortedList2().solve(
                new ListNode(1,
                        new ListNode(1,
                                new ListNode(2,
                                        new ListNode(2))))
        ));
    }

    @Test
    public void shouldDeleteDuplicatesFromListWhereSingleTypeOfElementIsPresent(){
        assertNull(new RemoveDuplicatesFromSortedList2().solve(
                new ListNode(1,
                        new ListNode(1,
                                new ListNode(1)))
        ));
    }

    @Test
    public void shouldHandleNull(){
        assertNull(new RemoveDuplicatesFromSortedList2().solve(null));
    }

    @Test
    public void shouldHandleUniSizeList(){
        assertArrayEquals(new Integer[]{1},new RemoveDuplicatesFromSortedList2().solve(
                new ListNode(1)
        ).toList().toArray(new Integer[0]));
    }
}