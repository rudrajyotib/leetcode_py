package gfg;

import gfg.util.tree.Node;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class LeftVIewOfBinaryTreeTest {

    @Test
    public void testCase1() {
        assertArrayEquals(new Integer[]{1},
                new LeftVIewOfBinaryTree().leftView(new Node(1)).toArray(new Integer[1]));
    }

    @Test
    public void testCase2() {
        assertArrayEquals(new Integer[]{1, 2, 4, 7, 10},
                new LeftVIewOfBinaryTree().leftView(new Node(1,
                        new Node(2,
                                new Node(4),
                                new Node(5,
                                        new Node(7),
                                        new Node(8))),
                        new Node(3,
                                null,
                                new Node(6,
                                        null,
                                        new Node(9,
                                                null,
                                                new Node(10)))))).toArray(new Integer[1]));
    }

}