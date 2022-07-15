package leet.solutions;

import ds.util.TreeNode;
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
        List<List<Integer>> result = binaryTreeLevelOrderTraversal.solve(new TreeNode(1));
        assertEquals(1, result.size());
        assertEquals(1, result.get(0).size());
        assertEquals(1, result.get(0).get(0).intValue());
    }


    @Test
    public void shouldLevelOrderTraverseCompleteTree()
    {
        BinaryTreeLevelOrderTraversal binaryTreeLevelOrderTraversal = new BinaryTreeLevelOrderTraversal();
        List<List<Integer>> result = binaryTreeLevelOrderTraversal.solve(
                new  TreeNode(1,
                        new  TreeNode(2,
                                new  TreeNode(4),
                                new  TreeNode(5)),
                        new  TreeNode(3,
                                new  TreeNode(6),
                                new  TreeNode(7))));
        assertEquals(3, result.size());
        assertEquals(1, result.get(0).size());
        assertEquals(1, result.get(0).get(0).intValue());
        assertEquals(2, result.get(1).size());
        assertArrayEquals(new Integer[]{2,3}, result.get(1).toArray(new Integer[1]));
        assertEquals(4, result.get(2).size());
        assertArrayEquals(new Integer[]{4,5,6,7}, result.get(2).toArray(new Integer[1]));
    }

}