package leet.solutions;

import ds.util.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class LowestCommonAncestorOfBinarySearchTreeTest {


    private static final TreeNode treeNode;

    static {
        treeNode
                = new  TreeNode(15);
        treeNode.left = new  TreeNode(10);
        treeNode.right = new  TreeNode(20);
        treeNode.left.left = new  TreeNode(7);
        treeNode.left.right = new  TreeNode(12);
        treeNode.left.left.left = new  TreeNode(5);
        treeNode.left.left.right = new  TreeNode(9);
        treeNode.left.left.right.left = new  TreeNode(8);
        treeNode.right.left = new  TreeNode(17);
        treeNode.right.right = new  TreeNode(25);
        treeNode.right.right.left = new  TreeNode(22);
        treeNode.right.right.right = new  TreeNode(30);
        treeNode.right.right.right.left = new  TreeNode(27);
        treeNode.right.right.right.right = new  TreeNode(35);
    }


    @Test
    public void shouldFindLowestCommonAncestors() {
        LowestCommonAncestorOfBinarySearchTree lowestCommonAncestorOfBinarySearchTree = new LowestCommonAncestorOfBinarySearchTree();
        assertEquals(7, lowestCommonAncestorOfBinarySearchTree.solve(treeNode,
                treeNode.left.left.left,
                treeNode.left.left.right.left).val);

        assertEquals(15, lowestCommonAncestorOfBinarySearchTree.solve(treeNode,
                treeNode.left,
                treeNode.right).val);

        assertEquals(20, lowestCommonAncestorOfBinarySearchTree.solve(treeNode,
                treeNode.right,
                treeNode.right.right).val);
    }


}