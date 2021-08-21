package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaximumDepthOfBinaryTreeTest {


    @Test
    public void shouldFindMaxDepth()
    {
        MaximumDepthOfBinaryTree maximumDepthOfBinaryTree = new MaximumDepthOfBinaryTree();
        assertEquals(0, maximumDepthOfBinaryTree.solve(null));
        assertEquals(1, maximumDepthOfBinaryTree.solve(new MaximumDepthOfBinaryTree.TreeNode(1)));
        assertEquals(3, maximumDepthOfBinaryTree.solve(new MaximumDepthOfBinaryTree.TreeNode(1,
                null,
                new MaximumDepthOfBinaryTree.TreeNode(2, null, new MaximumDepthOfBinaryTree.TreeNode(3)))));
    }

}