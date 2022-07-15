package interviewbit.solutions;

import ds.util.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class InorderTraversalWithoutRecursionTest {


    @Test
    public void shouldHandleNullTree(){
        assertNull(new InorderTraversalWithoutRecursion().solve(null));
    }

    @Test
    public void shouldHandleSimpleTree(){
        assertArrayEquals(new Integer[]{1,2,3},
                new InorderTraversalWithoutRecursion().solve(
                        new TreeNode(2,
                                new  TreeNode(1),
                                new  TreeNode(3))
                ).toArray(new Integer[1]));
    }

    @Test
    public void shouldHandleWideTree(){
        assertArrayEquals(new Integer[]{1,3,4,5,6,8,10},
                new InorderTraversalWithoutRecursion().solve(
                        new  TreeNode(5,
                                new  TreeNode(3,
                                        new  TreeNode(1),
                                        new  TreeNode(4)),
                                new  TreeNode(8,
                                        new  TreeNode(6),
                                        new  TreeNode(10)))
                ).toArray(new Integer[1]));
    }


}