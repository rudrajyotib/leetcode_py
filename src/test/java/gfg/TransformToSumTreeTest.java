package gfg;

import gfg.util.tree.Node;
import org.junit.Test;

import static org.junit.Assert.*;

public class TransformToSumTreeTest {

    @Test
    public void set1(){
        Node root = new Node(10,
                new Node(-2,
                        new Node(8),
                        new Node(-4)),
                new Node(6,
                        new Node(7),
                        new Node(5)));
        new TransformToSumTree().solve(root);
        assertArrayEquals(new Integer[]{0,4,0,20,0,12,0},root.inOrder().toArray(new Integer[1]));
    }


}