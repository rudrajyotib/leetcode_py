package interviewbit.solutions;

import ds.util.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class BalanceBinaryTreeCheckTest {

    @Test
    public void shouldValidateAllLevelBalancedBinaryTree() {
        assertEquals(1, new BalanceBinaryTreeCheck().solve(
                new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(4),
                                new TreeNode(5)),
                        new TreeNode(3,
                                new TreeNode(6),
                                new TreeNode(7)))
        ));
    }

    @Test
    public void shouldValidateBalanceWithTolerance() {
        assertEquals(1, new BalanceBinaryTreeCheck().solve(
                new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(4),
                                new TreeNode(5)),
                        new TreeNode(3,
                                new TreeNode(6),
                                new TreeNode(7,
                                        new TreeNode(8),
                                        null)))
        ));
    }

    @Test
    public void shouldNotValidateLeftAlignedBinaryTree() {

        assertEquals(0, new BalanceBinaryTreeCheck().solve(
                new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(3,
                                        new TreeNode(4),
                                        null),
                                null),
                        null)
        ));

    }

    @Test
    public void shouldNotValidateRightAlignedBinaryTree() {
        assertEquals(0, new BalanceBinaryTreeCheck().solve(new TreeNode(1,
                null,
                new TreeNode(2,
                        null,
                        new TreeNode(3)))));
    }

    @Test
    public void shouldNotValidateImbalanceAtChildNode() {

        assertEquals(0, new BalanceBinaryTreeCheck().solve(
                new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(4),
                                new TreeNode(5,
                                        new TreeNode(6),
                                        new TreeNode(7))),
                        new TreeNode(3))
        ));
    }

    @Test
    public void shouldValidateSingleNodeTree(){
        assertEquals(1, new BalanceBinaryTreeCheck().solve(
                new TreeNode(1)
        ));
    }



}