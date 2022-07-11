package interviewbit.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class IdenticalBinaryTreesTest {

    @Test
    public void shouldConfirmIdentitySet1(){
        assertEquals(1, new IdenticalBinaryTrees().solve(
                new IdenticalBinaryTrees.TreeNode(1,
                        new IdenticalBinaryTrees.TreeNode(2,
                                new IdenticalBinaryTrees.TreeNode(4),
                                new IdenticalBinaryTrees.TreeNode(5)),
                        new IdenticalBinaryTrees.TreeNode(3,
                                null,
                                new IdenticalBinaryTrees.TreeNode(6,
                                        null,
                                        new IdenticalBinaryTrees.TreeNode(7)))),
                new IdenticalBinaryTrees.TreeNode(1,
                        new IdenticalBinaryTrees.TreeNode(2,
                                new IdenticalBinaryTrees.TreeNode(4),
                                new IdenticalBinaryTrees.TreeNode(5)),
                        new IdenticalBinaryTrees.TreeNode(3,
                                null,
                                new IdenticalBinaryTrees.TreeNode(6,
                                        null,
                                        new IdenticalBinaryTrees.TreeNode(7))))
        ));
    }

    @Test
    public void shouldConfirmIdentitySet2(){
        assertEquals(1, new IdenticalBinaryTrees().solve(
                new IdenticalBinaryTrees.TreeNode(1),
                new IdenticalBinaryTrees.TreeNode(1)
        ));
    }

    @Test
    public void shouldNotConfirmIdentitySet1(){
        assertEquals(0, new IdenticalBinaryTrees().solve(
                new IdenticalBinaryTrees.TreeNode(1,
                        new IdenticalBinaryTrees.TreeNode(2,
                                new IdenticalBinaryTrees.TreeNode(4),
                                new IdenticalBinaryTrees.TreeNode(5)),
                        new IdenticalBinaryTrees.TreeNode(3,
                                null,
                                new IdenticalBinaryTrees.TreeNode(6,
                                        null,
                                        new IdenticalBinaryTrees.TreeNode(7)))),
                new IdenticalBinaryTrees.TreeNode(1,
                        new IdenticalBinaryTrees.TreeNode(2,
                                new IdenticalBinaryTrees.TreeNode(4),
                                new IdenticalBinaryTrees.TreeNode(5)),
                        new IdenticalBinaryTrees.TreeNode(3,
                                null,
                                new IdenticalBinaryTrees.TreeNode(6,
                                        null,
                                        new IdenticalBinaryTrees.TreeNode(7,
                                                new IdenticalBinaryTrees.TreeNode(8),
                                                null))))
        ));
    }


}