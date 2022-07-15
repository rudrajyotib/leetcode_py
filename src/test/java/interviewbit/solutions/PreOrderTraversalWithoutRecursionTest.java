package interviewbit.solutions;

import ds.util.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class PreOrderTraversalWithoutRecursionTest {

    @Test
    public void shouldCreatePreorderTraversalOfDistributedTreeSet1(){
        assertArrayEquals(new Integer[]{1,2,4,5,3,6,7},
                new PreOrderTraversalWithoutRecursion().solve(
                        new TreeNode(1,
                                new  TreeNode(2,
                                        new  TreeNode(4),
                                        new  TreeNode(5)),
                                new  TreeNode(3,
                                        new  TreeNode(6),
                                        new  TreeNode(7)))
                ).toArray(new Integer[1]));
    }

    @Test
    public void shouldCreatePreorderTraversalOfDistributedTreeSet2(){
        assertArrayEquals(new Integer[]{1,2,4,5,3,6,7,8},
                new PreOrderTraversalWithoutRecursion().solve(
                        new  TreeNode(1,
                                new  TreeNode(2,
                                        new  TreeNode(4),
                                        new  TreeNode(5)),
                                new  TreeNode(3,
                                        new  TreeNode(6,
                                                new  TreeNode(7),
                                                null),
                                        new  TreeNode(8)))
                ).toArray(new Integer[1]));
    }


    @Test
    public void shouldCreatePreOrderTraversalForSingleNodeTree(){
        assertArrayEquals(new Integer[]{1},
                new PreOrderTraversalWithoutRecursion().solve(
                        new  TreeNode(1)
                ).toArray(new Integer[1]));
    }

    @Test
    public void shouldCreatePreOrderTraversalForLeftAlignedTree(){
        assertArrayEquals(new Integer[]{1,2,3},
                new PreOrderTraversalWithoutRecursion().solve(
                        new  TreeNode(1,
                                new  TreeNode(2,
                                        new  TreeNode(3),
                                        null),
                                null)
                ).toArray(new Integer[1]));
    }

    @Test
    public void shouldCreatePreOrderTraversalForRightAlignedTree(){
        assertArrayEquals(new Integer[]{1,2,3},
                new PreOrderTraversalWithoutRecursion().solve(
                        new  TreeNode(1,
                                null,
                                new  TreeNode(2,
                                        null,
                                        new  TreeNode(3)))
                ).toArray(new Integer[1]));
    }

    @Test
    public void shouldHandleNullTree(){
        assertTrue(new PreOrderTraversalWithoutRecursion().solve(null).isEmpty());
    }

}