package interviewbit.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class BalanceBinaryTreeCheckTest {

    @Test
    public void shouldValidateAllLevelBalancedBinaryTree() {
        assertEquals(1, new BalanceBinaryTreeCheck().solve(
                new BalanceBinaryTreeCheck.TreeNode(1,
                        new BalanceBinaryTreeCheck.TreeNode(2,
                                new BalanceBinaryTreeCheck.TreeNode(4),
                                new BalanceBinaryTreeCheck.TreeNode(5)),
                        new BalanceBinaryTreeCheck.TreeNode(3,
                                new BalanceBinaryTreeCheck.TreeNode(6),
                                new BalanceBinaryTreeCheck.TreeNode(7)))
        ));
    }

    @Test
    public void shouldValidateBalanceWithTolerance() {
        assertEquals(1, new BalanceBinaryTreeCheck().solve(
                new BalanceBinaryTreeCheck.TreeNode(1,
                        new BalanceBinaryTreeCheck.TreeNode(2,
                                new BalanceBinaryTreeCheck.TreeNode(4),
                                new BalanceBinaryTreeCheck.TreeNode(5)),
                        new BalanceBinaryTreeCheck.TreeNode(3,
                                new BalanceBinaryTreeCheck.TreeNode(6),
                                new BalanceBinaryTreeCheck.TreeNode(7,
                                        new BalanceBinaryTreeCheck.TreeNode(8),
                                        null)))
        ));
    }

    @Test
    public void shouldNotValidateLeftAlignedBinaryTree() {

        assertEquals(0, new BalanceBinaryTreeCheck().solve(
                new BalanceBinaryTreeCheck.TreeNode(1,
                        new BalanceBinaryTreeCheck.TreeNode(2,
                                new BalanceBinaryTreeCheck.TreeNode(3,
                                        new BalanceBinaryTreeCheck.TreeNode(4),
                                        null),
                                null),
                        null)
        ));

    }

    @Test
    public void shouldNotValidateRightAlignedBinaryTree() {
        assertEquals(0, new BalanceBinaryTreeCheck().solve(new BalanceBinaryTreeCheck.TreeNode(1,
                null,
                new BalanceBinaryTreeCheck.TreeNode(2,
                        null,
                        new BalanceBinaryTreeCheck.TreeNode(3)))));
    }

    @Test
    public void shouldNotValidateImbalanceAtChildNode() {

        assertEquals(0, new BalanceBinaryTreeCheck().solve(
                new BalanceBinaryTreeCheck.TreeNode(1,
                        new BalanceBinaryTreeCheck.TreeNode(2,
                                new BalanceBinaryTreeCheck.TreeNode(4),
                                new BalanceBinaryTreeCheck.TreeNode(5,
                                        new BalanceBinaryTreeCheck.TreeNode(6),
                                        new BalanceBinaryTreeCheck.TreeNode(7))),
                        new BalanceBinaryTreeCheck.TreeNode(3))
        ));
    }

    @Test
    public void shouldValidateSingleNodeTree(){
        assertEquals(1, new BalanceBinaryTreeCheck().solve(
                new BalanceBinaryTreeCheck.TreeNode(1)
        ));
    }



}