package interviewbit.solutions;

import ds.util.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class SumRootToLeafNumbersTest {

    @Test
    public void shouldExecuteTestCaseSet1(){
         TreeNode treeNode = new  TreeNode(3);
        treeNode.left = new  TreeNode(6);
        treeNode.right = new  TreeNode(7);
        treeNode.left.left = new  TreeNode(9);
        treeNode.left.right = new  TreeNode(8);

        assertEquals(774, new SumRootToLeafNumbers().solve(treeNode));
    }

    @Test
    public void shouldExecuteTestCaseSet2(){
         TreeNode treeNode = new  TreeNode(3);
        treeNode.left = new  TreeNode(6);
        treeNode.right = new  TreeNode(7);
        treeNode.left.left = new  TreeNode(9);
        treeNode.left.right = new  TreeNode(8);
        treeNode.left.left.left = new  TreeNode(8);
        treeNode.left.left.right = new  TreeNode(6);
        treeNode.left.right.right = new  TreeNode(0);
        treeNode.right.right = new  TreeNode(0);


        assertEquals(411, new SumRootToLeafNumbers().solve(treeNode));
    }

    @Test
    public void shouldExecuteTestCaseSet3(){
         TreeNode treeNode = new  TreeNode(3);


        assertEquals(3, new SumRootToLeafNumbers().solve(treeNode));
    }


}