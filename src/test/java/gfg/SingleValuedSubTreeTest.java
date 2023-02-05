package gfg;

import gfg.util.tree.Node;
import org.junit.Test;

import static org.junit.Assert.*;

public class SingleValuedSubTreeTest {


    @Test
    public void set1(){
        assertEquals(4, new SingleValuedSubTree().solve(

                new Node(5,
                        new Node(1,
                                new Node(5),
                                new Node(5)),
                        new Node(5,
                                null,
                                new Node(5)))

        ));
    }

    @Test
    public void set2(){
        assertEquals(5, new SingleValuedSubTree().solve(
                new Node(5,
                        new Node(4,
                                new Node(4),
                                new Node(4)),
                        new Node(5,
                                null,
                                new Node(5)))
        ));
    }

    @Test
    public void set3(){
        assertEquals(6, new SingleValuedSubTree().solve(
                new Node(5,
                        new Node(5,
                                new Node(5),
                                new Node(5)),
                        new Node(5,
                                null,
                                new Node(5)))
        ));
    }

}