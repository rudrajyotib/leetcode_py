package gfg;

import gfg.util.link.Node;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class RotateLeftShiftLinkedListTest {


    @Test
    public void testCase1() {
        assertArrayEquals(new Integer[]{7, 8, 9, 2, 4}, new RotateLeftShiftLinkedList().rotate(
                Node.createLinkedList(new Integer[]{2, 4, 7, 8, 9}), 2
        ).toArray());
    }

    @Test
    public void testCase2() {
        assertArrayEquals(new Integer[]{2, 4, 7, 8, 9}, new RotateLeftShiftLinkedList().rotate(
                Node.createLinkedList(new Integer[]{2, 4, 7, 8, 9}), 0
        ).toArray());
    }

    @Test
    public void testCase3() {
        assertArrayEquals(new Integer[]{2, 4, 7, 8, 9}, new RotateLeftShiftLinkedList().rotate(
                Node.createLinkedList(new Integer[]{2, 4, 7, 8, 9}), 5
        ).toArray());
    }

    @Test
    public void testCase4() {
        assertArrayEquals(new Integer[]{9, 2, 4, 7, 8}, new RotateLeftShiftLinkedList().rotate(
                Node.createLinkedList(new Integer[]{2, 4, 7, 8, 9}), 4
        ).toArray());
    }

    @Test
    public void testCase5() {
        assertArrayEquals(new Integer[]{9}, new RotateLeftShiftLinkedList().rotate(
                Node.createLinkedList(new Integer[]{9}), 1
        ).toArray());
    }

}