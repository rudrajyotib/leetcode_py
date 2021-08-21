package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class SameTreeTest {

    @Test
    public void shouldMatchTrees() {
        SameTree sameTree = new SameTree();
        assertTrue(sameTree.solve(new SameTree.TreeNode(1, new SameTree.TreeNode(2), new SameTree.TreeNode(3)),
                new SameTree.TreeNode(1, new SameTree.TreeNode(2), new SameTree.TreeNode(3))));

        assertFalse(sameTree.solve(new SameTree.TreeNode(1, new SameTree.TreeNode(2), new SameTree.TreeNode(3)),
                new SameTree.TreeNode(1, new SameTree.TreeNode(2), new SameTree.TreeNode(3, null, new SameTree.TreeNode(4)))));

        assertTrue(sameTree.solve(null, null));
    }

}