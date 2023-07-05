package leet.solutions;

import ds.util.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class CountNodeEqualToAverageOfSubTreeTest {

    @Test
    public void set1(){
        assertEquals(5, new CountNodeEqualToAverageOfSubTree().solve(
                new TreeNode(4,
                        new TreeNode(8,
                                new TreeNode(0),
                                new TreeNode(1)),
                        new TreeNode(5,
                                null,
                                new TreeNode(6)))
        ));
    }

    @Test
    public void set2(){
        assertEquals(1, new CountNodeEqualToAverageOfSubTree().solve(new TreeNode(2)));
    }
}