package gfg;

import gfg.util.tree.Node;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxValueLevelOrderTest {

    @Test
    public void set1(){
        assertArrayEquals(new Integer[]{1,3,5},
                new MaxValueLevelOrder().solve(
                        new Node(1,
                                new Node(2,
                                        new Node(0),
                                        new Node(5)),
                                new Node(3,
                                        new Node(1),
                                        new Node(2))
                )).toArray(new Integer[1]));
    }


}