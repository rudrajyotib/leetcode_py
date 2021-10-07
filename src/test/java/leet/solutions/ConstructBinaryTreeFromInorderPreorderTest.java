package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConstructBinaryTreeFromInorderPreorderTest {


    @Test
    public void shouldConstructCompleteBinaryTree()
    {
        ConstructBinaryTreeFromInorderPreorder constructBinaryTreeFromInorderPreorder
                = new ConstructBinaryTreeFromInorderPreorder();
        ConstructBinaryTreeFromInorderPreorder.TreeNode treeNode = constructBinaryTreeFromInorderPreorder.solve(new int[]{3, 9, 11, 12, 20, 15, 7},
                new int[]{11, 9, 12, 3, 15, 20, 7});
        assertNotNull(treeNode);
        assertEquals(3, treeNode.val);
        assertEquals(9, treeNode.left.val);
        assertEquals(20, treeNode.right.val);
        assertEquals(11, treeNode.left.left.val);
        assertEquals(12, treeNode.left.right.val);
        assertEquals(15, treeNode.right.left.val);
        assertEquals(7, treeNode.right.right.val);
    }

}