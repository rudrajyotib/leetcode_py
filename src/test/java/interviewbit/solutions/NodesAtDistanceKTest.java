package interviewbit.solutions;

import ds.util.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class NodesAtDistanceKTest {

    private final TreeNode treeNode = new TreeNode(8,
            new TreeNode(5,
                    new TreeNode(4,
                            new TreeNode(1),
                            new TreeNode(3,
                                    new TreeNode(10),
                                    new TreeNode(9))),
                    new TreeNode(2)),
            new TreeNode(13,
                    new TreeNode(11,
                            new TreeNode(20),
                            new TreeNode(22)),
                    new TreeNode(17,
                            new TreeNode(12),
                            new TreeNode(16))));


    @Test
    public void set1(){
        assertArrayEquals(new Integer[]{1,3,13},
                new NodesAtDistanceK().solve(treeNode, 5, 2).stream().sorted().toArray());
    }

    @Test
    public void set2(){
        assertArrayEquals(new Integer[]{2,4,11,17},
                new NodesAtDistanceK().solve(treeNode, 8, 2).stream().sorted().toArray());
    }

    @Test
    public void set3(){
        assertArrayEquals(new Integer[]{},
                new NodesAtDistanceK().solve(treeNode, 8, 200).stream().sorted().toArray());
    }


}