package leet.solutions;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BinaryTreeInorderTraversalTest {


    @Test
    public void shouldTraverseInOrderOnSingleNode()
    {
        BinaryTreeInorderTraversal binaryTreeInorderTraversal = new BinaryTreeInorderTraversal();
        List<Integer> result = binaryTreeInorderTraversal.solve(new BinaryTreeInorderTraversal.TreeNode(1));
        assertArrayEquals(new Integer[]{1}, result.toArray(new Integer[1]));
    }

    @Test
    public void shouldTraverseInOrderOnCompleteBinaryTree()
    {
        BinaryTreeInorderTraversal binaryTreeInorderTraversal = new BinaryTreeInorderTraversal();
        List<Integer> result = binaryTreeInorderTraversal.solve(
                new BinaryTreeInorderTraversal.TreeNode(1,
                        new BinaryTreeInorderTraversal.TreeNode(2,
                                new BinaryTreeInorderTraversal.TreeNode(4),
                                new BinaryTreeInorderTraversal.TreeNode(5)),
                        new BinaryTreeInorderTraversal.TreeNode(3,
                                new BinaryTreeInorderTraversal.TreeNode(6),
                                new BinaryTreeInorderTraversal.TreeNode(7))));
        assertArrayEquals(new Integer[]{4, 2, 5, 1, 6, 3, 7}, result.toArray(new Integer[1]));
    }

    @Test
    public void shouldTraverseInOrderOnLeftOnlyBinaryTree()
    {
        BinaryTreeInorderTraversal binaryTreeInorderTraversal = new BinaryTreeInorderTraversal();
        List<Integer> result = binaryTreeInorderTraversal.solve(
                new BinaryTreeInorderTraversal.TreeNode(1,
                        new BinaryTreeInorderTraversal.TreeNode(2,
                                new BinaryTreeInorderTraversal.TreeNode(4),
                                null),
                        null));
        assertArrayEquals(new Integer[]{4, 2,  1}, result.toArray(new Integer[1]));
    }




}