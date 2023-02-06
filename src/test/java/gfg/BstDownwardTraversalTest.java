package gfg;

import gfg.util.tree.Node;
import org.junit.Test;

import static org.junit.Assert.*;

public class BstDownwardTraversalTest {

    @Test
    public void set1(){
        assertEquals(32, new BstDownwardTraversal().solve(
                new Node(25,
                        new Node(20,
                                new Node(15),
                                new Node(22)),
                        new Node(35,
                                new Node(30,
                                        null,
                                        new Node(32)),
                                new Node(45))),
                35
        ));
    }

     @Test
    public void set2(){
        assertEquals(-1, new BstDownwardTraversal().solve(
                new Node(25,
                        new Node(20,
                                new Node(15),
                                new Node(22)),
                        new Node(35,
                                new Node(30,
                                        null,
                                        new Node(32)),
                                new Node(45))),
                26
        ));
    }

    @Test
    public void set3(){
        assertEquals(52, new BstDownwardTraversal().solve(
                new Node(25,
                        new Node(20,
                                new Node(15),
                                new Node(22)),
                        new Node(35,
                                new Node(30,
                                        null,
                                        new Node(32)),
                                new Node(45))),
                25
        ));
    }


}