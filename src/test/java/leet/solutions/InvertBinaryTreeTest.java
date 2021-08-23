package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class InvertBinaryTreeTest {

    @Test
    public void shouldInvertCompleteBinaryTree()
    {
        InvertBinaryTree.TreeNode treeNode =
                new InvertBinaryTree.TreeNode(1,
                        new InvertBinaryTree.TreeNode(2,
                                new InvertBinaryTree.TreeNode(4),
                                new InvertBinaryTree.TreeNode(5)),
                        new InvertBinaryTree.TreeNode(3,
                                new InvertBinaryTree.TreeNode(6),
                                new InvertBinaryTree.TreeNode(7)));

        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
        InvertBinaryTree.TreeNode invertedTree = invertBinaryTree.solve(treeNode);
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
        InvertBinaryTree.TreeNode treeNode =
                new InvertBinaryTree.TreeNode(1,
                        new InvertBinaryTree.TreeNode(2,
                                new InvertBinaryTree.TreeNode(4),
                                new InvertBinaryTree.TreeNode(5)),
                        new InvertBinaryTree.TreeNode(3,
                                new InvertBinaryTree.TreeNode(6),
                                new InvertBinaryTree.TreeNode(7,
                                        new InvertBinaryTree.TreeNode(8),
                                        null)));

        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
        InvertBinaryTree.TreeNode invertedTree = invertBinaryTree.solve(treeNode);
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
        InvertBinaryTree.TreeNode treeNode =
                new InvertBinaryTree.TreeNode(1);
        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
        InvertBinaryTree.TreeNode invertedTree = invertBinaryTree.solve(treeNode);
        assertEquals(1, invertedTree.val);
        assertNull(invertedTree.left);
        assertNull(invertedTree.right);
    }

}