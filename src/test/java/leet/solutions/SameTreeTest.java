package leet.solutions;

import ds.util.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class SameTreeTest {

    @Test
    public void shouldMatchTrees() {
        SameTree sameTree = new SameTree();
        assertTrue(sameTree.solve(new TreeNode(1, new TreeNode(2), new TreeNode(3)),
                new TreeNode(1, new TreeNode(2), new TreeNode(3))));

        assertFalse(sameTree.solve(new TreeNode(1, new TreeNode(2), new TreeNode(3)),
                new TreeNode(1, new TreeNode(2), new TreeNode(3, null, new TreeNode(4)))));

        assertTrue(sameTree.solve(null, null));
    }

}