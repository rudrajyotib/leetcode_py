package leet.solutions;

import ds.util.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StepByStepDirectionFromBinaryTreeNodeToAnotherTest {

    @Test
    public void testCase() {
        assertEquals("LL", new StepByStepDirectionFromBinaryTreeNodeToAnother().solve(
                new TreeNode(5, new TreeNode(1,
                        new TreeNode(3), null),
                        new TreeNode(2, new TreeNode(6), new TreeNode(4))),
                5,
                3
        ));
        assertEquals("UU", new StepByStepDirectionFromBinaryTreeNodeToAnother().solve(
                new TreeNode(5, new TreeNode(1,
                        new TreeNode(3), null),
                        new TreeNode(2, new TreeNode(6), new TreeNode(4))),
                4,
                5
        ));
        assertEquals("UURL", new StepByStepDirectionFromBinaryTreeNodeToAnother().solve(
                new TreeNode(5, new TreeNode(1,
                        new TreeNode(3), null),
                        new TreeNode(2, new TreeNode(6), new TreeNode(4))),
                3,
                6
        ));
        assertEquals("UR", new StepByStepDirectionFromBinaryTreeNodeToAnother().solve(
                new TreeNode(5, new TreeNode(1,
                        new TreeNode(3), null),
                        new TreeNode(2, new TreeNode(6), new TreeNode(4))),
                6,
                4
        ));


    }

}