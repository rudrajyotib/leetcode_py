package interviewbit.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class PreOrderTraversalWithoutRecursionTest {

    @Test
    public void shouldCreatePreorderTraversalOfDistributedTreeSet1(){
        assertArrayEquals(new Integer[]{1,2,4,5,3,6,7},
                new PreOrderTraversalWithoutRecursion().solve(
                        new PreOrderTraversalWithoutRecursion.TreeNode(1,
                                new PreOrderTraversalWithoutRecursion.TreeNode(2,
                                        new PreOrderTraversalWithoutRecursion.TreeNode(4),
                                        new PreOrderTraversalWithoutRecursion.TreeNode(5)),
                                new PreOrderTraversalWithoutRecursion.TreeNode(3,
                                        new PreOrderTraversalWithoutRecursion.TreeNode(6),
                                        new PreOrderTraversalWithoutRecursion.TreeNode(7)))
                ).toArray(new Integer[1]));
    }

    @Test
    public void shouldCreatePreorderTraversalOfDistributedTreeSet2(){
        assertArrayEquals(new Integer[]{1,2,4,5,3,6,7,8},
                new PreOrderTraversalWithoutRecursion().solve(
                        new PreOrderTraversalWithoutRecursion.TreeNode(1,
                                new PreOrderTraversalWithoutRecursion.TreeNode(2,
                                        new PreOrderTraversalWithoutRecursion.TreeNode(4),
                                        new PreOrderTraversalWithoutRecursion.TreeNode(5)),
                                new PreOrderTraversalWithoutRecursion.TreeNode(3,
                                        new PreOrderTraversalWithoutRecursion.TreeNode(6,
                                                new PreOrderTraversalWithoutRecursion.TreeNode(7),
                                                null),
                                        new PreOrderTraversalWithoutRecursion.TreeNode(8)))
                ).toArray(new Integer[1]));
    }


    @Test
    public void shouldCreatePreOrderTraversalForSingleNodeTree(){
        assertArrayEquals(new Integer[]{1},
                new PreOrderTraversalWithoutRecursion().solve(
                        new PreOrderTraversalWithoutRecursion.TreeNode(1)
                ).toArray(new Integer[1]));
    }

    @Test
    public void shouldCreatePreOrderTraversalForLeftAlignedTree(){
        assertArrayEquals(new Integer[]{1,2,3},
                new PreOrderTraversalWithoutRecursion().solve(
                        new PreOrderTraversalWithoutRecursion.TreeNode(1,
                                new PreOrderTraversalWithoutRecursion.TreeNode(2,
                                        new PreOrderTraversalWithoutRecursion.TreeNode(3),
                                        null),
                                null)
                ).toArray(new Integer[1]));
    }

    @Test
    public void shouldCreatePreOrderTraversalForRightAlignedTree(){
        assertArrayEquals(new Integer[]{1,2,3},
                new PreOrderTraversalWithoutRecursion().solve(
                        new PreOrderTraversalWithoutRecursion.TreeNode(1,
                                null,
                                new PreOrderTraversalWithoutRecursion.TreeNode(2,
                                        null,
                                        new PreOrderTraversalWithoutRecursion.TreeNode(3)))
                ).toArray(new Integer[1]));
    }

    @Test
    public void shouldHandleNullTree(){
        assertTrue(new PreOrderTraversalWithoutRecursion().solve(null).isEmpty());
    }

}