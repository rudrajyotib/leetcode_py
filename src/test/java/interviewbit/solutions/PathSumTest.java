package interviewbit.solutions;

import ds.util.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class PathSumTest {

    private TreeNode createTree(){
        return new TreeNode(2,
                new TreeNode(4,
                        null,
                        new TreeNode(3,
                                new TreeNode(5),
                                null)),
                new TreeNode(6,
                        new TreeNode(8),
                        new TreeNode(7)));
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