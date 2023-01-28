package gfg;

import gfg.util.tree.Node;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxGcdOfSiblingsOfBinaryTreeTest {

    @Test
    public void set1(){
        Node root = new Node(4);
        root.left = new Node(5);
        root.right = new Node(2);
        root.right.left = new Node(3);
        root.right.right = new Node(1);
        root.right.left.left = new Node(6);
        root.right.left.right = new Node(12);

        assertEquals(3, new MaxGcdOfSiblingsOfBinaryTree().maxGcd(root));
    }


}