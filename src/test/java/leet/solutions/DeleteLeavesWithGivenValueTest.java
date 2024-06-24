package leet.solutions;

import ds.util.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeleteLeavesWithGivenValueTest {

    @Test
    public void testCase1(){
        TreeNode root = new TreeNode(1,
                new TreeNode(3,
                        new TreeNode(3),
                        new TreeNode(2)), new TreeNode(3));

        assertEquals("321", new DeleteLeavesWithGivenValue().solve(root, 3).inOrder());
    }

    @Test
    public void testCase2(){
        TreeNode root = new TreeNode(1,
                new TreeNode(1,
                        new TreeNode(1),
                        new TreeNode(1)), new TreeNode(1));

        assertNull(new DeleteLeavesWithGivenValue().solve(root, 1));
    }

}