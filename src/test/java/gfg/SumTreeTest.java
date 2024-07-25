/*
https://www.geeksforgeeks.org/problems/sum-tree/
 */

package gfg;

import gfg.util.tree.Node;
import org.junit.Test;

import static org.junit.Assert.*;

public class SumTreeTest {

    @Test
    public void testCase1(){
        assertTrue(new SumTree().isSumTree(
                new Node(3,
                        new Node(1),
                        new Node(2))
        ));
    }

    @Test
    public void testCase2(){
        assertTrue(new SumTree().isSumTree(
                new Node(170,
                        new Node(70,
                                new Node(10),
                                new Node(30,
                                        new Node(10),
                                        new Node(20))
                                ),
                        new Node(30))
        ));
    }

    @Test
    public void testCase3(){
        assertFalse(new SumTree().isSumTree(
                new Node(171,
                        new Node(70,
                                new Node(10),
                                new Node(31,
                                        new Node(10),
                                        new Node(20))
                                ),
                        new Node(30))
        ));
    }

}