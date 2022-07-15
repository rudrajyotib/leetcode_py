package interviewbit.solutions;

import ds.util.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class IdenticalBinaryTreesTest {

    @Test
    public void shouldConfirmIdentitySet1(){
        assertEquals(1, new IdenticalBinaryTrees().solve(
                new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(4),
                                new TreeNode(5)),
                        new TreeNode(3,
                                null,
                                new TreeNode(6,
                                        null,
                                        new TreeNode(7)))),
                new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(4),
                                new TreeNode(5)),
                        new TreeNode(3,
                                null,
                                new TreeNode(6,
                                        null,
                                        new TreeNode(7))))
        ));
    }

    @Test
    public void shouldConfirmIdentitySet2(){
        assertEquals(1, new IdenticalBinaryTrees().solve(
                new TreeNode(1),
                new TreeNode(1)
        ));
    }

    @Test
    public void shouldNotConfirmIdentitySet1(){
        assertEquals(0, new IdenticalBinaryTrees().solve(
                new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(4),
                                new TreeNode(5)),
                        new TreeNode(3,
                                null,
                                new TreeNode(6,
                                        null,
                                        new TreeNode(7)))),
                new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(4),
                                new TreeNode(5)),
                        new TreeNode(3,
                                null,
                                new TreeNode(6,
                                        null,
                                        new TreeNode(7,
                                                new TreeNode(8),
                                                null))))
        ));
    }


}