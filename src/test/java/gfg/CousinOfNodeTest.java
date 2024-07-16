package gfg;

import gfg.util.tree.Node;
import org.junit.Test;

import static org.junit.Assert.*;

public class CousinOfNodeTest {

    @Test
    public void testCase1(){
        assertArrayEquals(new Integer[]{6,7},
                 CousinOfNode.printCousins(new Node(1,
                         new Node(2,
                                 new Node(4),
                                 new Node(5)),
                         new Node(3,
                                 new Node(6),
                                 new Node(7))),
                         new Node(5)).toArray());
    }

    @Test
    public void testCase2(){
        assertArrayEquals(new Integer[]{-1},
                 CousinOfNode.printCousins(new Node(1,
                         new Node(2,
                                 new Node(4),
                                 new Node(5)),
                         new Node(3,
                                 new Node(6,
                                         new Node(8),
                                         new Node(9)),
                                 new Node(7))),
                         new Node(8)).toArray());
    }

    @Test
    public void testCase3(){
        assertArrayEquals(new Integer[]{-1},
                 CousinOfNode.printCousins(new Node(1,
                         new Node(2,
                                 new Node(4),
                                 new Node(5)),
                         new Node(3,
                                 new Node(6,
                                         new Node(8),
                                         new Node(9)),
                                 new Node(7))),
                         new Node(10)).toArray());
    }


}