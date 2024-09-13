package gfg;

import gfg.util.tree.Node;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

public class AncestorsInBinaryTreeTest {

    @Test
    public void testCase1() {
        assertArrayEquals(new Integer[]{4, 2, 1},
                new AncestorsInBinaryTree().Ancestors(
                        new Node(1,
                                new Node(2,
                                        new Node(4,
                                                new Node(7),
                                                null),
                                        new Node(5)),
                                new Node(3,
                                        new Node(6),
                                        new Node(8))),
                        7).toArray(new Integer[1]));
    }

    @Test
    public void testCase2() {
        assertTrue(
                new AncestorsInBinaryTree().Ancestors(
                        new Node(1,
                                new Node(2,
                                        new Node(4,
                                                new Node(7),
                                                null),
                                        new Node(5)),
                                new Node(3,
                                        new Node(6),
                                        new Node(8))),
                        10).isEmpty());
    }

}