package leet.solutions;

import ds.util.TreeNode;
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
        assertTrue(evenOddTree.solve(new TreeNode(11)));
    }

    @Test
    public void shouldNotValidateSingleNodeEvenRoot()
    {
        EvenOddTree evenOddTree = new EvenOddTree();
        assertFalse(evenOddTree.solve(new  TreeNode(12)));
    }

    @Test
    public void shouldValidateValidCompleteEvenOddTree()
    {
        EvenOddTree evenOddTree = new EvenOddTree();
         TreeNode treeNode = new  TreeNode(1,
                new  TreeNode(12,
                        new  TreeNode(3),
                        new  TreeNode(5)),
                new  TreeNode(4,
                        new  TreeNode(7),
                        new  TreeNode(9)));
        assertTrue(evenOddTree.solve(treeNode));
    }

    @Test
    public void shouldNotValidateCompleteEvenOddTreeWhereStrictOrderIsNotMaintainedInOddIndexRow()
    {
        EvenOddTree evenOddTree = new EvenOddTree();
         TreeNode treeNode = new  TreeNode(1,
                new  TreeNode(12,
                        new  TreeNode(3),
                        new  TreeNode(5)),
                new  TreeNode(4,
                        new  TreeNode(7),
                        new  TreeNode(1)));
        assertFalse(evenOddTree.solve(treeNode));
    }

    @Test
    public void shouldNotValidateCompleteEvenOddTreeWhereStrictOrderIsNotMaintainedInEvenIndexRow()
    {
        EvenOddTree evenOddTree = new EvenOddTree();
         TreeNode treeNode = new  TreeNode(1,
                new  TreeNode(2,
                        new  TreeNode(3),
                        new  TreeNode(5)),
                new  TreeNode(4,
                        new  TreeNode(7),
                        new  TreeNode(1)));
        assertFalse(evenOddTree.solve(treeNode));
    }

    @Test
    public void shouldNotValidateCompleteEvenOddTreeWhereEvenOddSequenceIsNotMaintained()
    {
        EvenOddTree evenOddTree = new EvenOddTree();
         TreeNode treeNode = new  TreeNode(1,
                new  TreeNode(12,
                        new  TreeNode(3),
                        new  TreeNode(5)),
                new  TreeNode(4,
                        new  TreeNode(7),
                        new  TreeNode(8)));
        assertFalse(evenOddTree.solve(treeNode));
    }

    @Test
    public void shouldNotValidateIncompleteEvenOddTreeWhereLastRowViolatesEvenOddSequence()
    {
        EvenOddTree evenOddTree = new EvenOddTree();
         TreeNode treeNode = new  TreeNode(1,
                new  TreeNode(2,
                        new  TreeNode(3),
                        new  TreeNode(5)),
                new  TreeNode(4,
                        new  TreeNode(7),
                        new  TreeNode(8,
                                new  TreeNode(10),
                                null)));
        assertFalse(evenOddTree.solve(treeNode));
    }





}