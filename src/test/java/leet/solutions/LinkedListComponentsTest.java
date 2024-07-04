package leet.solutions;

import ds.util.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListComponentsTest {


    @Test
    public void testCase1(){
        assertEquals(1, new LinkedListComponents().solve(
                new ListNode(0,
                        new ListNode(1,
                                new ListNode(2,
                                        new ListNode(3)))),
                new int[]{0,1,5,2,6,3}
        ));
    }

    @Test
    public void testCase2(){
        assertEquals(2, new LinkedListComponents().solve(
                new ListNode(0,
                        new ListNode(1,
                                new ListNode(2,
                                        new ListNode(3)))),
                new int[]{0,1,3}
        ));
    }

    @Test
    public void testCase3(){
        assertEquals(2, new LinkedListComponents().solve(
                new ListNode(0,
                        new ListNode(1,
                                new ListNode(2,
                                        new ListNode(3,
                                                new ListNode(4))))),
                new int[]{0,3,1,4}
        ));
    }

}