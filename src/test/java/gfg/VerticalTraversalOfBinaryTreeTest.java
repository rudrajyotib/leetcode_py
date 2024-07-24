package gfg;

import gfg.util.tree.Node;
import org.junit.Test;

import static org.junit.Assert.*;

public class VerticalTraversalOfBinaryTreeTest {

    @Test
    public void  testCase1(){
        assertArrayEquals(new Integer[]{4,2,1,5,6,3,7},
                VerticalTraversalOfBinaryTree.verticalOrder(new Node(1,
                        new Node(2,
                                new Node(4),
                                new Node(5)),
                        new Node(3,
                                new Node(6),
                                new Node(7)))).toArray(new Integer[0]));
    }

    @Test
    public void  testCase2(){
        assertArrayEquals(new Integer[]{4,2,6,1,7,9,3,8,5},
                VerticalTraversalOfBinaryTree.verticalOrder(new Node(1,
                        new Node(2,
                                new Node(4,
                                        null,
                                        new Node(6,
                                                null,
                                                new Node(7))),
                                null),
                        new Node(3,
                                null,
                                new Node(5,
                                        new Node(8,
                                                new Node(9),
                                                null),
                                        null)))).toArray(new Integer[0]));
    }

}