package interviewbit.solutions;

import ds.util.ListNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KthNodeFromMiddleTest {

    @Test
    public void set1() {

        assertEquals(2, new KthNodeFromMiddle().solve(
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(3,
                                        new ListNode(4,
                                                new ListNode(5,
                                                        new ListNode(6,
                                                                new ListNode(7))))))),
                2
        ));

    }

    @Test
    public void set2() {

        assertEquals(3, new KthNodeFromMiddle().solve(
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(3,
                                        new ListNode(4,
                                                new ListNode(5,
                                                        new ListNode(6,
                                                                new ListNode(7,
                                                                        new ListNode(8)))))))),
                2
        ));

    }

    @Test
    public void set3() {

        assertEquals(-1, new KthNodeFromMiddle().solve(
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(3,
                                        new ListNode(4,
                                                new ListNode(5,
                                                        new ListNode(6,
                                                                new ListNode(7))))))),
                6
        ));

    }

    @Test
    public void set4() {

        assertEquals(1, new KthNodeFromMiddle().solve(
                new ListNode(1,
                        new ListNode(2)),
                1
        ));

    }

    @Test
    public void set5() {

        assertEquals(-1, new KthNodeFromMiddle().solve(
                new ListNode(1),
                1
        ));

    }


}