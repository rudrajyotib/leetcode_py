package interviewbit.solutions;

import ds.util.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseAlternateKNodesTest {

    @Test
    public void shouldAlternateNodesMoreThanOnceAndEndsWithRotation(){
        assertArrayEquals(new Integer[]{3,2,1,4,5,6,9,8,7},
                new ReverseAlternateKNodes().solve(
                        new ListNode(1,
                                new ListNode(2,
                                        new ListNode(3,
                                                new ListNode(4,
                                                        new ListNode(5,
                                                                new ListNode(6,
                                                                        new ListNode(7,
                                                                                new ListNode(8,
                                                                                        new ListNode(9)))))))))
                ,3).toList().toArray(new Integer[0]));
    }

    @Test
    public void shouldAlternateNodesMoreThanOnceAndEndsWithoutRotation(){
        assertArrayEquals(new Integer[]{3,2,1,4,5,6,9,8,7,10,11,12},
                new ReverseAlternateKNodes().solve(
                        new ListNode(1,
                                new ListNode(2,
                                        new ListNode(3,
                                                new ListNode(4,
                                                        new ListNode(5,
                                                                new ListNode(6,
                                                                        new ListNode(7,
                                                                                new ListNode(8,
                                                                                        new ListNode(9,
                                                                                                new ListNode(10,
                                                                                                        new ListNode(11,
                                                                                                                new ListNode(12))))))))))))
                        ,3).toList().toArray(new Integer[0]));
    }


    @Test
    public void shouldReverseOnceAndKeepIntactOnce(){
        assertArrayEquals(new Integer[]{2,1,3,4},
                new ReverseAlternateKNodes().solve(
                        new ListNode(1,
                                new ListNode(2,
                                        new ListNode(3,
                                                new ListNode(4)))), 2
                ).toList().toArray(new Integer[0]));
    }

    @Test
    public void shouldReverseEntireList(){
        assertArrayEquals(new Integer[]{5,4,3,2,1},
                new ReverseAlternateKNodes().solve(
                        new ListNode(1,
                                new ListNode(2,
                                        new ListNode(3,
                                                new ListNode(4,
                                                        new ListNode(5))))), 5
                ).toList().toArray(new Integer[0]));
    }

    @Test
    public void shouldNotRotate(){
        assertArrayEquals(new Integer[]{1,2,3,4},
                new ReverseAlternateKNodes().solve(
                        new ListNode(1,
                                new ListNode(2,
                                        new ListNode(3,
                                                new ListNode(4)))), 1
                ).toList().toArray(new Integer[0]));
    }


}