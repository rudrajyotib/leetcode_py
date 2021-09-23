package leet.solutions;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BinaryTreeLevelOrderTraversalTest {


    @Test
    public void shouldSupportEmptyTree()
    {
        BinaryTreeLevelOrderTraversal binaryTreeLevelOrderTraversal = new BinaryTreeLevelOrderTraversal();
        List<List<Integer>> solve = binaryTreeLevelOrderTraversal.solve(null);
        assertEquals(0, solve.size());
    }

    @Test
    public void shouldLevelOrderTraverseSingleNodeTree()
    {
        BinaryTreeLevelOrderTraversal binaryTreeLevelOrderTraversal = new BinaryTreeLevelOrderTraversal();
        List<List<Integer>> result = binaryTreeLevelOrderTraversal.solve(new BinaryTreeLevelOrderTraversal.TreeNode(1));
        assertEquals(1, result.size());
        assertEquals(1, result.get(0).size());
        assertEquals(1, result.get(0).get(0).intValue());
    }


    @Test
    public void shouldLevelOrderTraverseCompleteTree()
    {
        BinaryTreeLevelOrderTraversal binaryTreeLevelOrderTraversal = new BinaryTreeLevelOrderTraversal();
        List<List<Integer>> result = binaryTreeLevelOrderTraversal.solve(
                new BinaryTreeLevelOrderTraversal.TreeNode(1,
                        new BinaryTreeLevelOrderTraversal.TreeNode(2,
                                new BinaryTreeLevelOrderTraversal.TreeNode(4),
                                new BinaryTreeLevelOrderTraversal.TreeNode(5)),
                        new BinaryTreeLevelOrderTraversal.TreeNode(3,
                                new BinaryTreeLevelOrderTraversal.TreeNode(6),
                                new BinaryTreeLevelOrderTraversal.TreeNode(7))));
        assertEquals(3, result.size());
        assertEquals(1, result.get(0).size());
        assertEquals(1, result.get(0).get(0).intValue());
        assertEquals(2, result.get(1).size());
        assertArrayEquals(new Integer[]{2,3}, result.get(1).toArray(new Integer[1]));
        assertEquals(4, result.get(2).size());
        assertArrayEquals(new Integer[]{4,5,6,7}, result.get(2).toArray(new Integer[1]));
    }

}