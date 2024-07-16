package gfg;

import gfg.util.tree.Node;
import org.junit.Test;

import static org.junit.Assert.*;

public class CountNodesKDistanceFromLeafTest {

    @Test
    public void testCase1(){
        assertEquals(2, new CountNodesKDistanceFromLeaf().printKDistantfromLeaf(
                new Node(1,
                        new Node(2,
                                new Node(4),
                                new Node(5)),
                        new Node(3,
                                new Node(6,
                                        null,
                                        new Node(8)),
                                new Node(7))),
                2
        ));
    }

}