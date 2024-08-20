package gfg;

import gfg.util.tree.Node;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaximumDifferenceBetweenNodeAndAncestorTest {

    @Test
    public void testCase1(){
        assertEquals(4, new MaximumDifferenceBetweenNodeAndAncestor().maxDiff(
                new Node(5,
                        new Node(2),
                        new Node(1))
        ));
    }

    @Test
    public void testCase2(){
        assertEquals(17, new MaximumDifferenceBetweenNodeAndAncestor().maxDiff(
                new Node(15,
                        new Node(10,
                                new Node(1),
                                new Node(-2)),
                        new Node(11))
        ));
    }

}