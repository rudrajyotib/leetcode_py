package leet.solutions;

import ds.util.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryTreeFromInorderPostorderTest {

    @Test
    public void shouldCreateBalancedBinaryTree()
    {
        BinaryTreeFromInorderPostorder binaryTreeFromInorderPostorder
                = new BinaryTreeFromInorderPostorder();
         TreeNode head = binaryTreeFromInorderPostorder.solve(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        assertEquals(3, head.val);
        assertEquals(9, head.left.val);
        assertEquals(20, head.right.val);
        assertEquals(15, head.right.left.val);
        assertEquals(7, head.right.right.val);
        assertNull(head.left.left);
        assertNull(head.left.right);
        assertNull(head.right.left.left);
        assertNull(head.right.left.right);
        assertNull(head.right.right.left);
        assertNull(head.right.right.right);
    }


    @Test
    public void shouldCreateLeftAlignedBinaryTree()
    {
        BinaryTreeFromInorderPostorder binaryTreeFromInorderPostorder
                = new BinaryTreeFromInorderPostorder();
         TreeNode head = binaryTreeFromInorderPostorder
                .solve(new int[]{4, 3, 2, 1},
                        new int[]{4, 3, 2, 1});
        assertEquals(1, head.val);
        assertEquals(2, head.left.val);
        assertEquals(3, head.left.left.val);
        assertEquals(4, head.left.left.left.val);
    }

}