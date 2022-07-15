package leet.solutions;

import ds.util.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidateBinarySearchTreeTest {

    @Test
    public void shouldValidateSingleNodeTree()
    {
        ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();
        assertTrue(validateBinarySearchTree.solve(new TreeNode(10)));
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
         TreeNode rootNode
                = new  TreeNode(10,
                new  TreeNode(5,
                        new  TreeNode(3),
                        new  TreeNode(8)),
                new  TreeNode(15,
                        new  TreeNode(12),
                        new  TreeNode(20)));
        assertTrue(validateBinarySearchTree.solve(rootNode));
    }

    @Test
    public void shouldNotValidateCompleteInvalidBst()
    {
        ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();
         TreeNode rootNode
                = new  TreeNode(10,
                new  TreeNode(5,
                        new  TreeNode(3),
                        new  TreeNode(8)),
                new  TreeNode(15,
                        new  TreeNode(12),
                        new  TreeNode(2)));
        assertFalse(validateBinarySearchTree.solve(rootNode));
    }

    @Test
    public void shouldNotValidateCompleteBstWhereNodesHaveSameValues()
    {
        ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();
         TreeNode rootNode
                = new  TreeNode(10,
                new  TreeNode(5,
                        new  TreeNode(3),
                        new  TreeNode(8)),
                new  TreeNode(15,
                        new  TreeNode(12),
                        new  TreeNode(15)));
        assertFalse(validateBinarySearchTree.solve(rootNode));
    }

}