package leet.solutions;

import ds.util.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class DistributeCoinsInBinaryTreeTest {

    @Test
    public void testCase1(){
        assertEquals(5, new DistributeCoinsInBinaryTree().solve(
                new TreeNode(2,
                        new TreeNode(2,
                                new TreeNode(0),
                                new TreeNode(0)),
                        new TreeNode(0,
                                new TreeNode(0,
                                        new TreeNode(2),
                                        new TreeNode(1)),
                                new TreeNode(2)))
        ));
    }

}