package leet.solutions;

import ds.util.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryTreeMaximumPathTest {

    @Test
    public void shouldFindMaxPath() {
        BinaryTreeMaximumPath binaryTreeMaximumPath = new BinaryTreeMaximumPath();

        assertEquals(0, binaryTreeMaximumPath.solve(
                new TreeNode(0,
                        new  TreeNode(-1,
                                null,
                                new  TreeNode(-3)),
                        new  TreeNode(-2,
                                null,
                                new  TreeNode(-4)))
        ));

        assertEquals(6, binaryTreeMaximumPath.solve(
                new  TreeNode(0,
                        new  TreeNode(-1,
                                null,
                                new  TreeNode(-3)),
                        new  TreeNode(2,
                                null,
                                new  TreeNode(4)))
        ));

    }


}