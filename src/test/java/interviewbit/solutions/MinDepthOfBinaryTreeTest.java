package interviewbit.solutions;

import ds.util.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class MinDepthOfBinaryTreeTest {

    @Test
    public void shouldDeriveMinDepthSet1(){
        assertEquals(2, new MinDepthOfBinaryTree().solve(
                new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(4),
                                new TreeNode(5,
                                        new TreeNode(6),
                                        new TreeNode(7))),
                        new TreeNode(3))
        ));
    }

    @Test
    public void shouldDeriveMinDepthSet2(){
        assertEquals(3, new MinDepthOfBinaryTree().solve(
                new TreeNode(1,
                        new TreeNode(2,
                                null,
                                new TreeNode(3)),
                        null)
        ));
    }

    @Test
    public void shouldDeriveMinDepthSet3(){
        assertEquals(3, new MinDepthOfBinaryTree().solve(
                new TreeNode(9,
                        new TreeNode(11,
                                new TreeNode(7),
                                new TreeNode(5,
                                        new TreeNode(8),
                                        new TreeNode(11))),
                        new TreeNode(10,
                                null,
                                new TreeNode(12,
                                        null,
                                        new TreeNode(6,
                                                new TreeNode(2,
                                                        null,
                                                        new TreeNode(3,
                                                                new TreeNode(4),
                                                                null)),
                                                null))))
        ));
    }

}