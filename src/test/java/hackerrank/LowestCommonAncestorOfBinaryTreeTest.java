package hackerrank;

import org.junit.Test;

import static hackerrank.LowestCommonAncestorOfBinaryTree.*;
import static org.junit.Assert.*;

public class LowestCommonAncestorOfBinaryTreeTest {

    @Test
    public void testCase1(){
        assertEquals(3,
                lca(
                new Node(2,
                        new Node(1),
                        new Node(3,
                                new Node(4),
                                new Node(5,
                                        null,
                                        new Node(6)))),
                4, 6
        ).data);
    }

}