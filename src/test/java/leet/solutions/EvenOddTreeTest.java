package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class EvenOddTreeTest {

    @Test
    public void shouldNotValidateNullRoot()
    {
        EvenOddTree evenOddTree = new EvenOddTree();
        assertFalse(evenOddTree.solve(null));
    }

    @Test
    public void shouldValidateSingleNodeOddRoot()
    {
        EvenOddTree evenOddTree = new EvenOddTree();
        assertTrue(evenOddTree.solve(new EvenOddTree.TreeNode(11)));
    }

    @Test
    public void shouldNotValidateSingleNodeEvenRoot()
    {
        EvenOddTree evenOddTree = new EvenOddTree();
        assertFalse(evenOddTree.solve(new EvenOddTree.TreeNode(12)));
    }

    @Test
    public void shouldValidateValidCompleteEvenOddTree()
    {
        EvenOddTree evenOddTree = new EvenOddTree();
        EvenOddTree.TreeNode treeNode = new EvenOddTree.TreeNode(1,
                new EvenOddTree.TreeNode(12,
                        new EvenOddTree.TreeNode(3),
                        new EvenOddTree.TreeNode(5)),
                new EvenOddTree.TreeNode(4,
                        new EvenOddTree.TreeNode(7),
                        new EvenOddTree.TreeNode(9)));
        assertTrue(evenOddTree.solve(treeNode));
    }

    @Test
    public void shouldNotValidateCompleteEvenOddTreeWhereStrictOrderIsNotMaintainedInOddIndexRow()
    {
        EvenOddTree evenOddTree = new EvenOddTree();
        EvenOddTree.TreeNode treeNode = new EvenOddTree.TreeNode(1,
                new EvenOddTree.TreeNode(12,
                        new EvenOddTree.TreeNode(3),
                        new EvenOddTree.TreeNode(5)),
                new EvenOddTree.TreeNode(4,
                        new EvenOddTree.TreeNode(7),
                        new EvenOddTree.TreeNode(1)));
        assertFalse(evenOddTree.solve(treeNode));
    }

    @Test
    public void shouldNotValidateCompleteEvenOddTreeWhereStrictOrderIsNotMaintainedInEvenIndexRow()
    {
        EvenOddTree evenOddTree = new EvenOddTree();
        EvenOddTree.TreeNode treeNode = new EvenOddTree.TreeNode(1,
                new EvenOddTree.TreeNode(2,
                        new EvenOddTree.TreeNode(3),
                        new EvenOddTree.TreeNode(5)),
                new EvenOddTree.TreeNode(4,
                        new EvenOddTree.TreeNode(7),
                        new EvenOddTree.TreeNode(1)));
        assertFalse(evenOddTree.solve(treeNode));
    }

    @Test
    public void shouldNotValidateCompleteEvenOddTreeWhereEvenOddSequenceIsNotMaintained()
    {
        EvenOddTree evenOddTree = new EvenOddTree();
        EvenOddTree.TreeNode treeNode = new EvenOddTree.TreeNode(1,
                new EvenOddTree.TreeNode(12,
                        new EvenOddTree.TreeNode(3),
                        new EvenOddTree.TreeNode(5)),
                new EvenOddTree.TreeNode(4,
                        new EvenOddTree.TreeNode(7),
                        new EvenOddTree.TreeNode(8)));
        assertFalse(evenOddTree.solve(treeNode));
    }

    @Test
    public void shouldNotValidateIncompleteEvenOddTreeWhereLastRowViolatesEvenOddSequence()
    {
        EvenOddTree evenOddTree = new EvenOddTree();
        EvenOddTree.TreeNode treeNode = new EvenOddTree.TreeNode(1,
                new EvenOddTree.TreeNode(2,
                        new EvenOddTree.TreeNode(3),
                        new EvenOddTree.TreeNode(5)),
                new EvenOddTree.TreeNode(4,
                        new EvenOddTree.TreeNode(7),
                        new EvenOddTree.TreeNode(8,
                                new EvenOddTree.TreeNode(10),
                                null)));
        assertFalse(evenOddTree.solve(treeNode));
    }





}