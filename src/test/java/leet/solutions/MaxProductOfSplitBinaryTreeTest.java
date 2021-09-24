package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxProductOfSplitBinaryTreeTest {

    @Test
    public void shouldCalculateMaxProductOfSingleChildTree()
    {
        MaxProductOfSplitBinaryTree maxProductOfSplitBinaryTree = new MaxProductOfSplitBinaryTree();
        MaxProductOfSplitBinaryTree.TreeNode root =
                new MaxProductOfSplitBinaryTree.TreeNode(1,
                        new MaxProductOfSplitBinaryTree.TreeNode(2), null);
        assertEquals(2, maxProductOfSplitBinaryTree.solve(root));
    }

    @Test
    public void shouldCalculateMaxProductOfCompleteTree()
    {
        MaxProductOfSplitBinaryTree maxProductOfSplitBinaryTree = new MaxProductOfSplitBinaryTree();
        MaxProductOfSplitBinaryTree.TreeNode root =
                new MaxProductOfSplitBinaryTree.TreeNode(1,
                        new MaxProductOfSplitBinaryTree.TreeNode(2,
                                new MaxProductOfSplitBinaryTree.TreeNode(4),
                                new MaxProductOfSplitBinaryTree.TreeNode(5)),
                        new MaxProductOfSplitBinaryTree.TreeNode(3,
                                new MaxProductOfSplitBinaryTree.TreeNode(6),
                                new MaxProductOfSplitBinaryTree.TreeNode(7)));
        assertEquals(192, maxProductOfSplitBinaryTree.solve(root));
    }

    @Test
    public void shouldCalculateMaxProductOfLeftAlignedTree()
    {
        MaxProductOfSplitBinaryTree maxProductOfSplitBinaryTree = new MaxProductOfSplitBinaryTree();
        MaxProductOfSplitBinaryTree.TreeNode root
                = new MaxProductOfSplitBinaryTree.TreeNode(1,
                        new MaxProductOfSplitBinaryTree.TreeNode(2,
                                new MaxProductOfSplitBinaryTree.TreeNode(3,
                                        new MaxProductOfSplitBinaryTree.TreeNode(4), null), null), null);
        assertEquals(24, maxProductOfSplitBinaryTree.solve(root));
    }


}