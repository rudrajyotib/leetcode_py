package interviewbit.solutions;

import ds.util.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class RemoveNthNodeFromListEndTest {

    @Test
    public void shouldDeleteRequiredNode(){
        assertArrayEquals(new Integer[]{1,2,4,5},
                new RemoveNthNodeFromListEnd().solve(
                        new ListNode(1,
                                new ListNode(2,
                                        new ListNode(3,
                                                new ListNode(4,
                                                        new ListNode(5))))),
                        3
                ).toList().toArray(new Integer[0]));
    }

    @Test
    public void shouldDeleteHeadNode(){
        assertArrayEquals(new Integer[]{2,3,4,5},
                new RemoveNthNodeFromListEnd().solve(
                        new ListNode(1,
                                new ListNode(2,
                                         new ListNode(3,
                                                 new ListNode(4,
                                                         new ListNode(5))))),
                        5
                ).toList().toArray(new Integer[0]));
    }

    @Test
    public void shouldDeleteTailNode(){
        assertArrayEquals(new Integer[]{1,2,3,4},
                new RemoveNthNodeFromListEnd().solve(
                        new ListNode(1,
                                new ListNode(2,
                                         new ListNode(3,
                                                 new ListNode(4,
                                                         new ListNode(5))))),
                        1
                ).toList().toArray(new Integer[0]));
    }

    @Test
    public void shouldDeleteHeadWhenOvershoots(){
        assertArrayEquals(new Integer[]{2,3,4,5},
                new RemoveNthNodeFromListEnd().solve(
                        new ListNode(1,
                                new ListNode(2,
                                         new ListNode(3,
                                                 new ListNode(4,
                                                         new ListNode(5))))),
                        100
                ).toList().toArray(new Integer[0]));
    }

    @Test
    public void shouldHandleNull(){
        assertNull(new RemoveNthNodeFromListEnd().solve(null,10));
    }

}