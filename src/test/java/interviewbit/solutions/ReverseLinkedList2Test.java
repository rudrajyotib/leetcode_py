package interviewbit.solutions;

import ds.util.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseLinkedList2Test {

    @Test
    public void shouldReverseNodesNotFallingOnBoundary(){
        assertArrayEquals(new Integer[]{1,2,5,4,3,6,7},
                new ReverseLinkedList2().solve(
                        new ListNode(1,
                                new ListNode(2,
                                        new ListNode(3,
                                                new ListNode(4,
                                                        new ListNode(5,
                                                                new ListNode(6,
                                                                        new ListNode(7))))))),
                        3,5
                ).toList().toArray(new Integer[0]));
    }


    @Test
    public void shouldReverseNodeStartingFromHead(){
        assertArrayEquals(new Integer[]{3,2,1,4,5,6},
                new ReverseLinkedList2().solve(
                        new ListNode(1,
                                new ListNode(2,
                                        new ListNode(3,
                                                new ListNode(4,
                                                        new ListNode(5,
                                                                new ListNode(6)))))),
                        1, 3
                ).toList().toArray(new Integer[0]));
    }

    @Test
    public void shouldReversNodeEndingAtTail(){
        assertArrayEquals(new Integer[]{1,2,3,6,5,4},
                new ReverseLinkedList2().solve(
                        new ListNode(1,
                                new ListNode(2,
                                        new ListNode(3,
                                                new ListNode(4,
                                                        new ListNode(5,
                                                                new ListNode(6)))))),
                        4,6
                ).toList().toArray(new Integer[0]));
    }

    @Test
    public void shouldReverseTheEntireList(){
        assertArrayEquals(new Integer[]{5,4,3,2,1},
                new ReverseLinkedList2().solve(
                        new ListNode(1,
                                new ListNode(2,
                                        new ListNode(3,
                                                new ListNode(4,
                                                        new ListNode(5))))),
                        1,5
                ).toList().toArray(new Integer[0]));
    }


    @Test
    public void shouldSupportReversalOfSingleNode(){
        assertArrayEquals(new Integer[]{1,2,3,4},
                new ReverseLinkedList2().solve(
                        new ListNode(1,
                                new ListNode(2,
                                        new ListNode(3,
                                                new ListNode(4)))),
                        3,3
                ).toList().toArray(new Integer[0]));
    }

}