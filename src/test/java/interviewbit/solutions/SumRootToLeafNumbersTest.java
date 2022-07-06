package interviewbit.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class SumRootToLeafNumbersTest {

    @Test
    public void shouldExecuteTestCaseSet1(){
        SumRootToLeafNumbers.TreeNode treeNode = new SumRootToLeafNumbers.TreeNode(3);
        treeNode.left = new SumRootToLeafNumbers.TreeNode(6);
        treeNode.right = new SumRootToLeafNumbers.TreeNode(7);
        treeNode.left.left = new SumRootToLeafNumbers.TreeNode(9);
        treeNode.left.right = new SumRootToLeafNumbers.TreeNode(8);

        assertEquals(774, new SumRootToLeafNumbers().solve(treeNode));
    }

    @Test
    public void shouldExecuteTestCaseSet2(){
        SumRootToLeafNumbers.TreeNode treeNode = new SumRootToLeafNumbers.TreeNode(3);
        treeNode.left = new SumRootToLeafNumbers.TreeNode(6);
        treeNode.right = new SumRootToLeafNumbers.TreeNode(7);
        treeNode.left.left = new SumRootToLeafNumbers.TreeNode(9);
        treeNode.left.right = new SumRootToLeafNumbers.TreeNode(8);
        treeNode.left.left.left = new SumRootToLeafNumbers.TreeNode(8);
        treeNode.left.left.right = new SumRootToLeafNumbers.TreeNode(6);
        treeNode.left.right.right = new SumRootToLeafNumbers.TreeNode(0);
        treeNode.right.right = new SumRootToLeafNumbers.TreeNode(0);


        assertEquals(411, new SumRootToLeafNumbers().solve(treeNode));
    }

    @Test
    public void shouldExecuteTestCaseSet3(){
        SumRootToLeafNumbers.TreeNode treeNode = new SumRootToLeafNumbers.TreeNode(3);


        assertEquals(3, new SumRootToLeafNumbers().solve(treeNode));
    }


}