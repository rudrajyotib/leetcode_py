package leet.solutions;

import ds.util.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class BalanceBinarySearchTreeTest {

    @Test
    public void testCase1(){
        TreeNode input = new TreeNode(10,
                null, new TreeNode(12,
                null, new TreeNode(14,
                null, new TreeNode(16,
                null, new TreeNode(18)))));
        assertFalse(input.isBalanced());
        TreeNode balanced = new BalanceBinarySearchTree().solve(input);
        assertTrue(balanced.isBalanced());
    }




}