package gfg;

import gfg.util.tree.Node;
import org.junit.Test;

import static org.junit.Assert.*;

public class CheckIfSubtreeTest {

    @Test
    public void testCase1(){
        assertTrue(CheckIfSubtree.isSubtree(
                new Node(1,
                        new Node(2),
                        new Node(3)),
                new Node(3)
        ));
    }

    @Test
    public void testCase2(){
        assertFalse(CheckIfSubtree.isSubtree(
                new Node(1,
                        new Node(2),
                        new Node(3)),
                new Node(4)
        ));
    }

    @Test
    public void testCase3(){
        assertTrue(CheckIfSubtree.isSubtree(
                new Node(1,
                        new Node(2),
                        new Node(3)),
                new Node(1,
                        new Node(2),
                        new Node(3))
        ));
    }

}