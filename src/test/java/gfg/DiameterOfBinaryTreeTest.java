package gfg;

import gfg.util.tree.Node;
import org.junit.Test;

import static org.junit.Assert.*;

public class DiameterOfBinaryTreeTest {

    @Test
    public void testCase1(){
        assertEquals(6, new DiameterOfBinaryTree().solve(
                new Node(1,
                        new Node(2,
                                new Node(4),
                                new Node(5,
                                        new Node(8),
                                        null)),
                        new Node(3,
                                new Node(6),
                                new Node(7)))
        ));
    }

}