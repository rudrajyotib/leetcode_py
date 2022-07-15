package interviewbit.solutions;

import ds.util.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecoverBinarySearchTreeTest {

    @Test
    public void shouldFindAnomalyAtRightSideOfTree(){
        assertArrayEquals(new int[]{25, 27},
                new RecoverBinarySearchTree().solve(
                        new TreeNode(15,
                                new  TreeNode(8,
                                        new  TreeNode(6,
                                                null,
                                                new  TreeNode(7)),
                                        new  TreeNode(12)),
                                new  TreeNode(27,
                                        new  TreeNode(20,
                                                new  TreeNode(18),
                                                null),
                                        new  TreeNode(30,
                                                new  TreeNode(25),
                                                null)))
                ));
    }

    @Test
    public void shouldFindAnomalyAtRootAndRightSideOfTree(){
        assertArrayEquals(new int[]{15, 27},
                new RecoverBinarySearchTree().solve(
                        new  TreeNode(27,
                                new  TreeNode(8,
                                        new  TreeNode(6,
                                                null,
                                                new  TreeNode(7)),
                                        new  TreeNode(12)),
                                new  TreeNode(25,
                                        new  TreeNode(20,
                                                new  TreeNode(18),
                                                null),
                                        new  TreeNode(30,
                                                new  TreeNode(15),
                                                null)))
                ));
    }

    @Test
    public void shouldFindAnomalyAtRootAndLeftSideOfTree(){
        assertArrayEquals(new int[]{6,15},
                new RecoverBinarySearchTree().solve(
                        new  TreeNode(6,
                                new  TreeNode(8,
                                        new  TreeNode(15,
                                                null,
                                                new  TreeNode(7)),
                                        new  TreeNode(12)),
                                new  TreeNode(25,
                                        new  TreeNode(20,
                                                new  TreeNode(18),
                                                null),
                                        new  TreeNode(30,
                                                new  TreeNode(27),
                                                null)))
                ));
    }

    @Test
    public void shouldFindAnomalyAtLeftSideOfTree(){
        assertArrayEquals(new int[]{8,12},
                new RecoverBinarySearchTree().solve(
                        new  TreeNode(15,
                                new  TreeNode(12,
                                        new  TreeNode(6,
                                                null,
                                                new  TreeNode(7)),
                                        new  TreeNode(8)),
                                new  TreeNode(25,
                                        new  TreeNode(20,
                                                new  TreeNode(18),
                                                null),
                                        new  TreeNode(30,
                                                new  TreeNode(27),
                                                null)))
                ));
    }

    @Test
    public void shouldNotFindAnomaly(){
        assertArrayEquals(new int[]{0, 0 },
                new RecoverBinarySearchTree().solve(
                        new  TreeNode(15,
                                new  TreeNode(8,
                                        new  TreeNode(6,
                                                null,
                                                new  TreeNode(7)),
                                        new  TreeNode(12)),
                                new  TreeNode(25,
                                        new  TreeNode(20,
                                                new  TreeNode(18),
                                                null),
                                        new  TreeNode(30,
                                                new  TreeNode(27),
                                                null)))
                ));
    }




}