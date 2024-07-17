package leet.solutions;

import ds.util.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

public class DeleteNodesAndReturnForestTest {

    public TreeNode getTree() {
        return new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5)),
                new TreeNode(3,
                        new TreeNode(6),
                        new TreeNode(7)));
    }

    @Test
    public void testCase1() {
        assertArrayEquals(new Integer[]{1, 6, 7},
                new DeleteNodesAndReturnForest().solve(
                        getTree(),
                        new int[]{3, 5}
                ).stream().map(node -> node.val).sorted().toArray());
    }

    @Test
    public void testCase2() {
        TreeNode treeNode = getTree();
        assertArrayEquals(new Integer[]{2, 3},
                new DeleteNodesAndReturnForest().solve(
                        treeNode,
                        new int[]{1, 7}
                ).stream().map(node -> node.val).sorted().toArray());
        assertNull(treeNode.left);
        assertNull(treeNode.right);
    }

}