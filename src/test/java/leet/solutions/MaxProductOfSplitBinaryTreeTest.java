package leet.solutions;

import ds.util.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxProductOfSplitBinaryTreeTest {

    @Test
    public void shouldCalculateMaxProductOfSingleChildTree()
    {
        MaxProductOfSplitBinaryTree maxProductOfSplitBinaryTree = new MaxProductOfSplitBinaryTree();
         TreeNode root =
                new  TreeNode(1,
                        new  TreeNode(2), null);
        assertEquals(2, maxProductOfSplitBinaryTree.solve(root));
    }

    @Test
    public void shouldCalculateMaxProductOfCompleteTree()
    {
        MaxProductOfSplitBinaryTree maxProductOfSplitBinaryTree = new MaxProductOfSplitBinaryTree();
         TreeNode root =
                new  TreeNode(1,
                        new  TreeNode(2,
                                new  TreeNode(4),
                                new  TreeNode(5)),
                        new  TreeNode(3,
                                new  TreeNode(6),
                                new  TreeNode(7)));
        assertEquals(192, maxProductOfSplitBinaryTree.solve(root));
    }

    @Test
    public void shouldCalculateMaxProductOfLeftAlignedTree()
    {
        MaxProductOfSplitBinaryTree maxProductOfSplitBinaryTree = new MaxProductOfSplitBinaryTree();
         TreeNode root
                = new  TreeNode(1,
                        new  TreeNode(2,
                                new  TreeNode(3,
                                        new  TreeNode(4), null), null), null);
        assertEquals(24, maxProductOfSplitBinaryTree.solve(root));
    }


}