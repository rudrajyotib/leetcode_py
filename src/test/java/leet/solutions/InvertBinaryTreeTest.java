package leet.solutions;

import ds.util.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class InvertBinaryTreeTest {

    @Test
    public void shouldInvertCompleteBinaryTree()
    {
        TreeNode treeNode =
                new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(4),
                                new TreeNode(5)),
                        new TreeNode(3,
                                new TreeNode(6),
                                new TreeNode(7)));

        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
        TreeNode invertedTree = invertBinaryTree.solve(treeNode);
        assertEquals(1, invertedTree.val);
        assertEquals(2, invertedTree.right.val);
        assertEquals(3, invertedTree.left.val);
        assertEquals(4, invertedTree.right.right.val);
        assertEquals(5, invertedTree.right.left.val);
        assertEquals(7, invertedTree.left.left.val);
        assertEquals(6, invertedTree.left.right.val);
    }

    @Test
    public void shouldInvertIncompleteBinaryTree()
    {
        TreeNode treeNode =
                new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(4),
                                new TreeNode(5)),
                        new TreeNode(3,
                                new TreeNode(6),
                                new TreeNode(7,
                                        new TreeNode(8),
                                        null)));

        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
        TreeNode invertedTree = invertBinaryTree.solve(treeNode);
        assertEquals(1, invertedTree.val);
        assertEquals(2, invertedTree.right.val);
        assertEquals(3, invertedTree.left.val);
        assertEquals(4, invertedTree.right.right.val);
        assertEquals(5, invertedTree.right.left.val);
        assertEquals(7, invertedTree.left.left.val);
        assertEquals(6, invertedTree.left.right.val);
        assertEquals(8, invertedTree.left.left.right.val);
        assertNull( invertedTree.left.left.left);
    }

    @Test
    public void shouldInvertSingleNodeBinaryTree()
    {
        TreeNode treeNode =
                new TreeNode(1);
        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
        TreeNode invertedTree = invertBinaryTree.solve(treeNode);
        assertEquals(1, invertedTree.val);
        assertNull(invertedTree.left);
        assertNull(invertedTree.right);
    }

}