package interviewbit.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinDepthOfBinaryTreeTest {

    @Test
    public void shouldDeriveMinDepthSet1(){
        assertEquals(2, new MinDepthOfBinaryTree().solve(
                new MinDepthOfBinaryTree.TreeNode(1,
                        new MinDepthOfBinaryTree.TreeNode(2,
                                new MinDepthOfBinaryTree.TreeNode(4),
                                new MinDepthOfBinaryTree.TreeNode(5,
                                        new MinDepthOfBinaryTree.TreeNode(6),
                                        new MinDepthOfBinaryTree.TreeNode(7))),
                        new MinDepthOfBinaryTree.TreeNode(3))
        ));
    }

    @Test
    public void shouldDeriveMinDepthSet2(){
        assertEquals(3, new MinDepthOfBinaryTree().solve(
                new MinDepthOfBinaryTree.TreeNode(1,
                        new MinDepthOfBinaryTree.TreeNode(2,
                                null,
                                new MinDepthOfBinaryTree.TreeNode(3)),
                        null)
        ));
    }

    @Test
    public void shouldDeriveMinDepthSet3(){
        assertEquals(3, new MinDepthOfBinaryTree().solve(
                new MinDepthOfBinaryTree.TreeNode(9,
                        new MinDepthOfBinaryTree.TreeNode(11,
                                new MinDepthOfBinaryTree.TreeNode(7),
                                new MinDepthOfBinaryTree.TreeNode(5,
                                        new MinDepthOfBinaryTree.TreeNode(8),
                                        new MinDepthOfBinaryTree.TreeNode(11))),
                        new MinDepthOfBinaryTree.TreeNode(10,
                                null,
                                new MinDepthOfBinaryTree.TreeNode(12,
                                        null,
                                        new MinDepthOfBinaryTree.TreeNode(6,
                                                new MinDepthOfBinaryTree.TreeNode(2,
                                                        null,
                                                        new MinDepthOfBinaryTree.TreeNode(3,
                                                                new MinDepthOfBinaryTree.TreeNode(4),
                                                                null)),
                                                null))))
        ));
    }

}