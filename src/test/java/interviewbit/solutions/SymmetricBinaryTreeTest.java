package interviewbit.solutions;

import ds.util.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class SymmetricBinaryTreeTest {

    @Test
    public void shouldFindSymmetric(){
        assertEquals(1, new SymmetricBinaryTree().solve(
            new TreeNode(1,
                    new  TreeNode(2,
                            new  TreeNode(3,
                                    null,
                                    new  TreeNode(5)),
                            new  TreeNode(4)),
                    new  TreeNode(2,
                            new  TreeNode(4),
                            new  TreeNode(3,
                                    new  TreeNode(5),
                                    null)))
        ));
    }

    @Test
    public void shouldFindSingleNodeTreeSymmetric(){
        assertEquals(1, new SymmetricBinaryTree().solve(
                new  TreeNode(1)
        ));
    }

    @Test
    public void shouldReportTreeAsymmetric(){
        assertEquals(0, new SymmetricBinaryTree().solve(
                new  TreeNode(1,
                        new  TreeNode(2,
                                new  TreeNode(3),
                                new  TreeNode(4)),
                        new  TreeNode(2,
                                new  TreeNode(4,
                                        new  TreeNode(5),
                                        null),
                                new  TreeNode(3)))
        ));
    }


}