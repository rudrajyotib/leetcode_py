package leet.solutions;

import ds.util.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class DoubleNumberAsLinkedListTest {


    @Test
    public void testCase1(){
        assertArrayEquals(new Integer[]{3,7,8},
                new DoubleNumberAsLinkedList().solve(
                        new ListNode(1, new ListNode(8, new ListNode(9)))
                ).toList().toArray(new Integer[0]));
        assertArrayEquals(new Integer[]{1,1,7,8},
                new DoubleNumberAsLinkedList().solve(
                        new ListNode(5, new ListNode(8, new ListNode(9)))
                ).toList().toArray(new Integer[0]));
        assertArrayEquals(new Integer[]{1,0,0,6},
                new DoubleNumberAsLinkedList().solve(
                        new ListNode(5, new ListNode(0, new ListNode(3)))
                ).toList().toArray(new Integer[0]));
    }

}