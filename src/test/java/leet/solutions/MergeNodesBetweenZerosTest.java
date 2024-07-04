package leet.solutions;

import ds.util.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class MergeNodesBetweenZerosTest {

    @Test
    public void testCase1() {
        assertArrayEquals(new Integer[]{6, 8, 10},
                new MergeNodesBetweenZeros().solve(
                        new ListNode(0,
                                new ListNode(1,
                                        new ListNode(2,
                                                new ListNode(3,
                                                        new ListNode(0,
                                                                new ListNode(8,
                                                                        new ListNode(0,
                                                                                new ListNode(5,
                                                                                        new ListNode(5,
                                                                                                new ListNode(
                                                                                                        0))))))))))
                ).toList().toArray(new Integer[1]));

        assertArrayEquals(new Integer[]{0, 8, 10},
                new MergeNodesBetweenZeros().solve(
                        new ListNode(0,
                                new ListNode(1,
                                        new ListNode(-1,
                                                        new ListNode(0,
                                                                new ListNode(8,
                                                                        new ListNode(0,
                                                                                new ListNode(5,
                                                                                        new ListNode(5,
                                                                                                new ListNode(
                                                                                                        0)))))))))
                ).toList().toArray(new Integer[1]));
    }

}