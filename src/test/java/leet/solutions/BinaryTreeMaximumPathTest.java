package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryTreeMaximumPathTest {

    @Test
    public void shouldFindMaxPath() {
        BinaryTreeMaximumPath binaryTreeMaximumPath = new BinaryTreeMaximumPath();

        assertEquals(0, binaryTreeMaximumPath.solve(
                new BinaryTreeMaximumPath.TreeNode(0,
                        new BinaryTreeMaximumPath.TreeNode(-1,
                                null,
                                new BinaryTreeMaximumPath.TreeNode(-3)),
                        new BinaryTreeMaximumPath.TreeNode(-2,
                                null,
                                new BinaryTreeMaximumPath.TreeNode(-4)))
        ));

        assertEquals(6, binaryTreeMaximumPath.solve(
                new BinaryTreeMaximumPath.TreeNode(0,
                        new BinaryTreeMaximumPath.TreeNode(-1,
                                null,
                                new BinaryTreeMaximumPath.TreeNode(-3)),
                        new BinaryTreeMaximumPath.TreeNode(2,
                                null,
                                new BinaryTreeMaximumPath.TreeNode(4)))
        ));

    }


}