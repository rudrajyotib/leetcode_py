package interviewbit.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class PathSumTest {

    private PathSum.TreeNode createTree(){
        return new PathSum.TreeNode(2,
                new PathSum.TreeNode(4,
                        null,
                        new PathSum.TreeNode(3,
                                new PathSum.TreeNode(5),
                                null)),
                new PathSum.TreeNode(6,
                        new PathSum.TreeNode(8),
                        new PathSum.TreeNode(7)));
    }


    @Test
    public void shouldAddUpToSumSet1(){
        assertEquals(1, new PathSum().solve(createTree(), 14));
    }

    @Test
    public void shouldAddUpToSumSet2(){
        assertEquals(1, new PathSum().solve(createTree(), 16));
    }

    @Test
    public void shouldNotAddUpToSum(){
        assertEquals(0, new PathSum().solve(createTree(), 200));
    }

}