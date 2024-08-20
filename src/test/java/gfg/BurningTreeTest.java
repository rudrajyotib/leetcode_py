package gfg;

import gfg.util.tree.Node;
import org.junit.Test;

import static org.junit.Assert.*;

public class BurningTreeTest {

    @Test
    public void testCase1(){
        assertEquals(6, BurningTree.minTime(new Node(1,
                new Node(2,
                        new Node(4),
                        new Node(5,
                                new Node(11),
                                null)),
                new Node(3,
                        new Node(6,
                                new Node(8),
                                null),
                        new Node(7,
                                new Node(9),
                                new Node(10)))), 10));
    }

    @Test
    public void testCase2(){
        assertEquals(5, BurningTree.minTime(new Node(1,
                new Node(2,
                        new Node(4),
                        new Node(5,
                                new Node(11),
                                null)),
                new Node(3,
                        new Node(6,
                                new Node(8),
                                null),
                        new Node(7,
                                new Node(9),
                                new Node(10)))), 4));
    }

    @Test
    public void testCase3(){
        assertEquals(7, BurningTree.minTime(new Node(1,
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
                                        new Node(10))))), 8));
    }

    @Test
    public void testCase4(){
        assertEquals(5, BurningTree.minTime(new Node(1,
                new Node(2,
                        new Node(4,
                                new Node(8),
                                null),
                        new Node(5,
                                new Node(10),
                                null)),
                new Node(3,
                        null,
                        new Node(7))), 10));
    }

}