package leet.solutions;

import ds.util.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class GoodLeafNodePairsTest {

    @Test
    public void testCase1(){
        assertEquals(6, new GoodLeafNodePairs().solve(
                new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(5),
                                new TreeNode(4)),
                        new TreeNode(3,
                                new TreeNode(6),
                                new TreeNode(7,
                                        new TreeNode(8),
                                        new TreeNode(9)))),
                4
        ));
    }

    @Test
    public void testCase2(){
        assertEquals(0, new GoodLeafNodePairs().solve(
                new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(5),
                                new TreeNode(4)),
                        new TreeNode(3,
                                new TreeNode(6),
                                new TreeNode(7,
                                        new TreeNode(8),
                                        new TreeNode(9)))),
                1
        ));
    }

    @Test
    public void testCase3(){
        assertEquals(1, new GoodLeafNodePairs().solve(
                new TreeNode(1,
                        new TreeNode(2,
                                null,
                                new TreeNode(4)),
                        new TreeNode(3)),
                3
        ));
    }




}