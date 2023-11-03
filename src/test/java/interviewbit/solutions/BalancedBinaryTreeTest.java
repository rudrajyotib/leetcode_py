package interviewbit.solutions;

import ds.util.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class BalancedBinaryTreeTest {

    @Test
    public void set1(){
        assertEquals(1, new BalancedBinaryTree().solve(new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5)),
                new TreeNode(3,
                        new TreeNode(6),
                        new TreeNode(7)))));
    }

    @Test
    public void set2(){
        assertEquals(1, new BalancedBinaryTree().solve(new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5)),
                new TreeNode(3))));
    }

    @Test
    public void set3(){
        assertEquals(0, new BalancedBinaryTree().solve(new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5,
                                new TreeNode(6),
                                null)),
                new TreeNode(3))));
    }

}