package leet.solutions;

import ds.util.TreeNode;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BinaryTreeInorderTraversalTest {


    @Test
    public void shouldTraverseInOrderOnSingleNode()
    {
        BinaryTreeInorderTraversal binaryTreeInorderTraversal = new BinaryTreeInorderTraversal();
        List<Integer> result = binaryTreeInorderTraversal.solve(new TreeNode(1));
        assertArrayEquals(new Integer[]{1}, result.toArray(new Integer[1]));
    }

    @Test
    public void shouldTraverseInOrderOnCompleteBinaryTree()
    {
        BinaryTreeInorderTraversal binaryTreeInorderTraversal = new BinaryTreeInorderTraversal();
        List<Integer> result = binaryTreeInorderTraversal.solve(
                new  TreeNode(1,
                        new  TreeNode(2,
                                new  TreeNode(4),
                                new  TreeNode(5)),
                        new  TreeNode(3,
                                new  TreeNode(6),
                                new  TreeNode(7))));
        assertArrayEquals(new Integer[]{4, 2, 5, 1, 6, 3, 7}, result.toArray(new Integer[1]));
    }

    @Test
    public void shouldTraverseInOrderOnLeftOnlyBinaryTree()
    {
        BinaryTreeInorderTraversal binaryTreeInorderTraversal = new BinaryTreeInorderTraversal();
        List<Integer> result = binaryTreeInorderTraversal.solve(
                new  TreeNode(1,
                        new  TreeNode(2,
                                new  TreeNode(4),
                                null),
                        null));
        assertArrayEquals(new Integer[]{4, 2,  1}, result.toArray(new Integer[1]));
    }




}