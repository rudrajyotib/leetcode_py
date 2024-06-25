package leet.solutions;

import ds.util.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class BstGreaterSumTreeTest {

    @Test
    public void testCase1(){
        assertEquals("36363533302621158",
                new BstGreaterSumTree().solve(new TreeNode(4,
                        new TreeNode(1,
                                new TreeNode(0),
                                new TreeNode(2,
                                        null,
                                        new TreeNode(3))),
                        new TreeNode(6,
                                new TreeNode(5),
                                new TreeNode(7,
                                        null, new TreeNode(8))))).inOrder());
    }


}