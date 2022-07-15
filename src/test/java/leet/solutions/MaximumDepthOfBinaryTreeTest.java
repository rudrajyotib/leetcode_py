package leet.solutions;

import ds.util.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaximumDepthOfBinaryTreeTest {


    @Test
    public void shouldFindMaxDepth()
    {
        MaximumDepthOfBinaryTree maximumDepthOfBinaryTree = new MaximumDepthOfBinaryTree();
        assertEquals(0, maximumDepthOfBinaryTree.solve(null));
        assertEquals(1, maximumDepthOfBinaryTree.solve(new TreeNode(1)));
        assertEquals(3, maximumDepthOfBinaryTree.solve(new  TreeNode(1,
                null,
                new  TreeNode(2, null, new  TreeNode(3)))));
    }

}