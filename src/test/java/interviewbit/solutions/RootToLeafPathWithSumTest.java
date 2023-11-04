package interviewbit.solutions;

import ds.util.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.function.Predicate;

import static org.junit.Assert.*;

public class RootToLeafPathWithSumTest {

    @Test
    public void set1(){
        ArrayList<ArrayList<Integer>> result = new RootToLeafPathWithSum().solve(new TreeNode(5,
                new TreeNode(4,
                        new TreeNode(11,
                                new TreeNode(7),
                                new TreeNode(2)),
                        null),
                new TreeNode(8,
                        new TreeNode(13),
                        new TreeNode(4,
                                new TreeNode(5),
                                new TreeNode(1)))), 22);

        assertEquals(2, result.size());
        assertArrayEquals(new Integer[]{5, 4, 11, 2}, result.get(0).toArray(new Integer[1]));
        assertArrayEquals(new Integer[]{5, 8, 4, 5}, result.get(1).toArray(new Integer[1]));
    }

    @Test
    public void set2(){
        ArrayList<ArrayList<Integer>> result = new RootToLeafPathWithSum().solve(new TreeNode(5,
                new TreeNode(4,
                        new TreeNode(11,
                                new TreeNode(7),
                                new TreeNode(2)),
                        null),
                new TreeNode(8,
                        new TreeNode(13),
                        new TreeNode(4,
                                new TreeNode(5),
                                new TreeNode(1)))), 222);

        assertEquals(0, result.size());
    }

}