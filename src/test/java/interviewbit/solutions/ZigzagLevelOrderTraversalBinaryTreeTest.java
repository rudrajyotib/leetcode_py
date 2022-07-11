package interviewbit.solutions;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ZigzagLevelOrderTraversalBinaryTreeTest {

    @Test
    public void shouldTraverseZigzagSet1(){
        ArrayList<ArrayList<Integer>> result =
                new ZigzagLevelOrderTraversalBinaryTree().solve(
                        new ZigzagLevelOrderTraversalBinaryTree.TreeNode(1,
                                new ZigzagLevelOrderTraversalBinaryTree.TreeNode(2,
                                        new ZigzagLevelOrderTraversalBinaryTree.TreeNode(4),
                                        null),
                                new ZigzagLevelOrderTraversalBinaryTree.TreeNode(3,
                                        null,
                                        new ZigzagLevelOrderTraversalBinaryTree.TreeNode(6,
                                                new ZigzagLevelOrderTraversalBinaryTree.TreeNode(7),
                                                null)))
                );

        assertEquals(4, result.size());
        assertArrayEquals(new Integer[]{1}, result.get(0).toArray(new Integer[1]));
        assertArrayEquals(new Integer[]{3,2}, result.get(1).toArray(new Integer[1]));
        assertArrayEquals(new Integer[]{4,6}, result.get(2).toArray(new Integer[1]));
        assertArrayEquals(new Integer[]{7}, result.get(3).toArray(new Integer[1]));
    }

}