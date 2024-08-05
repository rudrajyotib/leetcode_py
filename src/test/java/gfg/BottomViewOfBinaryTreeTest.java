package gfg;

import gfg.util.tree.Node;
import org.junit.Test;

import static org.junit.Assert.*;

public class BottomViewOfBinaryTreeTest {

    @Test
    public void testCase1(){
        assertArrayEquals(new Integer[]{5, 10, 4, 14, 25}, new BottomViewOfBinaryTree().bottomView(
                new Node(20,
                        new Node(8,
                                new Node(5),
                                new Node(3,
                                        new Node(10),
                                        new Node(14))),
                        new Node(22,
                                new Node(4),
                                new Node(25)))
        ).toArray(new Integer[0]));
    }

    @Test
    public void testCase2(){
        assertArrayEquals(new Integer[]{3, 1, 2}, new BottomViewOfBinaryTree().bottomView(
                new Node(1,
                        new Node(3),
                        new Node(2))
        ).toArray(new Integer[0]));
    }


}