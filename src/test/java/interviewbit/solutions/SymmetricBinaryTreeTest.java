package interviewbit.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class SymmetricBinaryTreeTest {

    @Test
    public void shouldFindSymmetric(){
        assertEquals(1, new SymmetricBinaryTree().solve(
            new SymmetricBinaryTree.TreeNode(1,
                    new SymmetricBinaryTree.TreeNode(2,
                            new SymmetricBinaryTree.TreeNode(3,
                                    null,
                                    new SymmetricBinaryTree.TreeNode(5)),
                            new SymmetricBinaryTree.TreeNode(4)),
                    new SymmetricBinaryTree.TreeNode(2,
                            new SymmetricBinaryTree.TreeNode(4),
                            new SymmetricBinaryTree.TreeNode(3,
                                    new SymmetricBinaryTree.TreeNode(5),
                                    null)))
        ));
    }

    @Test
    public void shouldFindSingleNodeTreeSymmetric(){
        assertEquals(1, new SymmetricBinaryTree().solve(
                new SymmetricBinaryTree.TreeNode(1)
        ));
    }

    @Test
    public void shouldReportTreeAsymmetric(){
        assertEquals(0, new SymmetricBinaryTree().solve(
                new SymmetricBinaryTree.TreeNode(1,
                        new SymmetricBinaryTree.TreeNode(2,
                                new SymmetricBinaryTree.TreeNode(3),
                                new SymmetricBinaryTree.TreeNode(4)),
                        new SymmetricBinaryTree.TreeNode(2,
                                new SymmetricBinaryTree.TreeNode(4,
                                        new SymmetricBinaryTree.TreeNode(5),
                                        null),
                                new SymmetricBinaryTree.TreeNode(3)))
        ));
    }


}