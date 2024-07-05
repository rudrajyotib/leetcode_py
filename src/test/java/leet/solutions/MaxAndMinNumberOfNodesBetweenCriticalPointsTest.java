package leet.solutions;

import ds.util.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxAndMinNumberOfNodesBetweenCriticalPointsTest {

    @Test
    public void testCase1(){
        assertArrayEquals(new int[]{1,3},
                new MaxAndMinNumberOfNodesBetweenCriticalPoints().solve(
                        new ListNode(5,
                                new ListNode(3,
                                        new ListNode(1,
                                                new ListNode(2,
                                                        new ListNode(5,
                                                                new ListNode(1,
                                                                        new ListNode(2)))))))
                ));
    }

    @Test
    public void testCase2(){
        assertArrayEquals(new int[]{3,3},
                new MaxAndMinNumberOfNodesBetweenCriticalPoints().solve(
                        new ListNode(1,
                                new ListNode(3,
                                        new ListNode(2,
                                                new ListNode(2,
                                                        new ListNode(3,
                                                                new ListNode(2,
                                                                        new ListNode(2,
                                                                                new ListNode(2,
                                                                                        new ListNode(7)))))))))
                ));
    }

    @Test
    public void testCase3(){
        assertArrayEquals(new int[]{-1, -1},
                new MaxAndMinNumberOfNodesBetweenCriticalPoints().solve(
                        new ListNode(2,
                                new ListNode(2))
                ));
    }

}