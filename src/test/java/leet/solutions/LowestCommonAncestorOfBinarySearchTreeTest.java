package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class LowestCommonAncestorOfBinarySearchTreeTest {


    private static LowestCommonAncestorOfBinarySearchTree.TreeNode treeNode;

    static {
        treeNode
                = new LowestCommonAncestorOfBinarySearchTree.TreeNode(15);
        treeNode.left = new LowestCommonAncestorOfBinarySearchTree.TreeNode(10);
        treeNode.right = new LowestCommonAncestorOfBinarySearchTree.TreeNode(20);
        treeNode.left.left = new LowestCommonAncestorOfBinarySearchTree.TreeNode(7);
        treeNode.left.right = new LowestCommonAncestorOfBinarySearchTree.TreeNode(12);
        treeNode.left.left.left = new LowestCommonAncestorOfBinarySearchTree.TreeNode(5);
        treeNode.left.left.right = new LowestCommonAncestorOfBinarySearchTree.TreeNode(9);
        treeNode.left.left.right.left = new LowestCommonAncestorOfBinarySearchTree.TreeNode(8);
        treeNode.right.left = new LowestCommonAncestorOfBinarySearchTree.TreeNode(17);
        treeNode.right.right = new LowestCommonAncestorOfBinarySearchTree.TreeNode(25);
        treeNode.right.right.left = new LowestCommonAncestorOfBinarySearchTree.TreeNode(22);
        treeNode.right.right.right = new LowestCommonAncestorOfBinarySearchTree.TreeNode(30);
        treeNode.right.right.right.left = new LowestCommonAncestorOfBinarySearchTree.TreeNode(27);
        treeNode.right.right.right.right = new LowestCommonAncestorOfBinarySearchTree.TreeNode(35);
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