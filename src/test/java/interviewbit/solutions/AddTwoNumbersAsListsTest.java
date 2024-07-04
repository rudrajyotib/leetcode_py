package interviewbit.solutions;

import ds.util.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddTwoNumbersAsListsTest {


    @Test
    public void testCase1(){
        assertArrayEquals(new Integer[]{7,0,8},
                new AddTwoNumbersAsLists().solve(
                        new ListNode(2,
                                new ListNode(4,
                                        new ListNode(3))),
                        new ListNode(5,
                                new ListNode(6,
                                         new ListNode(4)))
                ).toList().toArray(new Integer[1]));
    }

    @Test
    public void testCase2(){
        assertArrayEquals(new Integer[]{0,1,0,1},
                new AddTwoNumbersAsLists().solve(
                        new ListNode(4,
                                new ListNode(0,
                                        new ListNode(4))),
                        new ListNode(6,
                                new ListNode(0,
                                         new ListNode(6)))
                ).toList().toArray(new Integer[1]));
    }

    @Test
    public void testCase3(){
        assertArrayEquals(new Integer[]{0,1,0,7},
                new AddTwoNumbersAsLists().solve(
                        new ListNode(4,
                                new ListNode(0,
                                        new ListNode(4))),
                        new ListNode(6,
                                new ListNode(0,
                                         new ListNode(6,
                                                 new ListNode(6))))
                ).toList().toArray(new Integer[1]));
    }

    @Test
    public void testCase4(){
        assertArrayEquals(new Integer[]{1,0,0,0,1},
                new AddTwoNumbersAsLists().solve(
                        new ListNode(1),
                        new ListNode(0,
                                new ListNode(0,
                                        new ListNode(0,
                                                new ListNode(0,
                                                        new ListNode(1)))))
                ).toList().toArray(new Integer[1]));
    }

}