package interviewbit.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class PostOrderTraversalWithoutRecursionTest {

    @Test
    public void shouldTraversePostOrder() {
        assertArrayEquals(new Integer[]{4, 6, 5, 2, 3, 1},
                new PostOrderTraversalWithoutRecursion().solve(
                        new PostOrderTraversalWithoutRecursion.TreeNode(1,
                                new PostOrderTraversalWithoutRecursion.TreeNode(2,
                                        new PostOrderTraversalWithoutRecursion.TreeNode(4),
                                        new PostOrderTraversalWithoutRecursion.TreeNode(5,
                                                new PostOrderTraversalWithoutRecursion.TreeNode(6),
                                                null)),
                                new PostOrderTraversalWithoutRecursion.TreeNode(3))
                ).toArray(new Integer[1]));
    }

    @Test
    public void shouldTraverseSingleNodeTree() {
        assertArrayEquals(new Integer[]{1},
                new PostOrderTraversalWithoutRecursion().solve(
                        new PostOrderTraversalWithoutRecursion.TreeNode(1)
                ).toArray(new Integer[1]));
    }

    @Test
    public void shouldTraverseLeftAlignedTree() {
        assertArrayEquals(new Integer[]{3, 2, 1},
                new PostOrderTraversalWithoutRecursion().solve(new PostOrderTraversalWithoutRecursion.TreeNode(1,
                                new PostOrderTraversalWithoutRecursion.TreeNode(2,
                                        new PostOrderTraversalWithoutRecursion.TreeNode(3), null),
                                null))
                        .toArray(new Integer[1])
        );
    }

    @Test
    public void shouldTraverseRightAlignedTree() {
        assertArrayEquals(new Integer[]{3, 2, 1}, new PostOrderTraversalWithoutRecursion().solve(
                new PostOrderTraversalWithoutRecursion.TreeNode(1,
                        null,
                        new PostOrderTraversalWithoutRecursion.TreeNode(2,
                                null,
                                new PostOrderTraversalWithoutRecursion.TreeNode(3)))
        ).toArray(new Integer[1]));
    }

}