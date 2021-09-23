package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidateBinarySearchTreeTest {

    @Test
    public void shouldValidateSingleNodeTree()
    {
        ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();
        assertTrue(validateBinarySearchTree.solve(new ValidateBinarySearchTree.TreeNode(10)));
    }

    @Test
    public void shouldNotValidateNullTree()
    {
        ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();
        assertFalse(validateBinarySearchTree.solve(null));
    }

    @Test
    public void shouldValidateCompleteValidBst()
    {
        ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();
        ValidateBinarySearchTree.TreeNode rootNode
                = new ValidateBinarySearchTree.TreeNode(10,
                new ValidateBinarySearchTree.TreeNode(5,
                        new ValidateBinarySearchTree.TreeNode(3),
                        new ValidateBinarySearchTree.TreeNode(8)),
                new ValidateBinarySearchTree.TreeNode(15,
                        new ValidateBinarySearchTree.TreeNode(12),
                        new ValidateBinarySearchTree.TreeNode(20)));
        assertTrue(validateBinarySearchTree.solve(rootNode));
    }

    @Test
    public void shouldNotValidateCompleteInvalidBst()
    {
        ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();
        ValidateBinarySearchTree.TreeNode rootNode
                = new ValidateBinarySearchTree.TreeNode(10,
                new ValidateBinarySearchTree.TreeNode(5,
                        new ValidateBinarySearchTree.TreeNode(3),
                        new ValidateBinarySearchTree.TreeNode(8)),
                new ValidateBinarySearchTree.TreeNode(15,
                        new ValidateBinarySearchTree.TreeNode(12),
                        new ValidateBinarySearchTree.TreeNode(2)));
        assertFalse(validateBinarySearchTree.solve(rootNode));
    }

    @Test
    public void shouldNotValidateCompleteBstWhereNodesHaveSameValues()
    {
        ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();
        ValidateBinarySearchTree.TreeNode rootNode
                = new ValidateBinarySearchTree.TreeNode(10,
                new ValidateBinarySearchTree.TreeNode(5,
                        new ValidateBinarySearchTree.TreeNode(3),
                        new ValidateBinarySearchTree.TreeNode(8)),
                new ValidateBinarySearchTree.TreeNode(15,
                        new ValidateBinarySearchTree.TreeNode(12),
                        new ValidateBinarySearchTree.TreeNode(15)));
        assertFalse(validateBinarySearchTree.solve(rootNode));
    }

}