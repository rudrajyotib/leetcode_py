package interviewbit.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class RecoverBinarySearchTreeTest {

    @Test
    public void shouldFindAnomalyAtRightSideOfTree(){
        assertArrayEquals(new int[]{25, 27},
                new RecoverBinarySearchTree().solve(
                        new RecoverBinarySearchTree.TreeNode(15,
                                new RecoverBinarySearchTree.TreeNode(8,
                                        new RecoverBinarySearchTree.TreeNode(6,
                                                null,
                                                new RecoverBinarySearchTree.TreeNode(7)),
                                        new RecoverBinarySearchTree.TreeNode(12)),
                                new RecoverBinarySearchTree.TreeNode(27,
                                        new RecoverBinarySearchTree.TreeNode(20,
                                                new RecoverBinarySearchTree.TreeNode(18),
                                                null),
                                        new RecoverBinarySearchTree.TreeNode(30,
                                                new RecoverBinarySearchTree.TreeNode(25),
                                                null)))
                ));
    }

    @Test
    public void shouldFindAnomalyAtRootAndRightSideOfTree(){
        assertArrayEquals(new int[]{15, 27},
                new RecoverBinarySearchTree().solve(
                        new RecoverBinarySearchTree.TreeNode(27,
                                new RecoverBinarySearchTree.TreeNode(8,
                                        new RecoverBinarySearchTree.TreeNode(6,
                                                null,
                                                new RecoverBinarySearchTree.TreeNode(7)),
                                        new RecoverBinarySearchTree.TreeNode(12)),
                                new RecoverBinarySearchTree.TreeNode(25,
                                        new RecoverBinarySearchTree.TreeNode(20,
                                                new RecoverBinarySearchTree.TreeNode(18),
                                                null),
                                        new RecoverBinarySearchTree.TreeNode(30,
                                                new RecoverBinarySearchTree.TreeNode(15),
                                                null)))
                ));
    }

    @Test
    public void shouldFindAnomalyAtRootAndLeftSideOfTree(){
        assertArrayEquals(new int[]{6,15},
                new RecoverBinarySearchTree().solve(
                        new RecoverBinarySearchTree.TreeNode(6,
                                new RecoverBinarySearchTree.TreeNode(8,
                                        new RecoverBinarySearchTree.TreeNode(15,
                                                null,
                                                new RecoverBinarySearchTree.TreeNode(7)),
                                        new RecoverBinarySearchTree.TreeNode(12)),
                                new RecoverBinarySearchTree.TreeNode(25,
                                        new RecoverBinarySearchTree.TreeNode(20,
                                                new RecoverBinarySearchTree.TreeNode(18),
                                                null),
                                        new RecoverBinarySearchTree.TreeNode(30,
                                                new RecoverBinarySearchTree.TreeNode(27),
                                                null)))
                ));
    }

    @Test
    public void shouldFindAnomalyAtLeftSideOfTree(){
        assertArrayEquals(new int[]{8,12},
                new RecoverBinarySearchTree().solve(
                        new RecoverBinarySearchTree.TreeNode(15,
                                new RecoverBinarySearchTree.TreeNode(12,
                                        new RecoverBinarySearchTree.TreeNode(6,
                                                null,
                                                new RecoverBinarySearchTree.TreeNode(7)),
                                        new RecoverBinarySearchTree.TreeNode(8)),
                                new RecoverBinarySearchTree.TreeNode(25,
                                        new RecoverBinarySearchTree.TreeNode(20,
                                                new RecoverBinarySearchTree.TreeNode(18),
                                                null),
                                        new RecoverBinarySearchTree.TreeNode(30,
                                                new RecoverBinarySearchTree.TreeNode(27),
                                                null)))
                ));
    }

    @Test
    public void shouldNotFindAnomaly(){
        assertArrayEquals(new int[]{0, 0 },
                new RecoverBinarySearchTree().solve(
                        new RecoverBinarySearchTree.TreeNode(15,
                                new RecoverBinarySearchTree.TreeNode(8,
                                        new RecoverBinarySearchTree.TreeNode(6,
                                                null,
                                                new RecoverBinarySearchTree.TreeNode(7)),
                                        new RecoverBinarySearchTree.TreeNode(12)),
                                new RecoverBinarySearchTree.TreeNode(25,
                                        new RecoverBinarySearchTree.TreeNode(20,
                                                new RecoverBinarySearchTree.TreeNode(18),
                                                null),
                                        new RecoverBinarySearchTree.TreeNode(30,
                                                new RecoverBinarySearchTree.TreeNode(27),
                                                null)))
                ));
    }




}