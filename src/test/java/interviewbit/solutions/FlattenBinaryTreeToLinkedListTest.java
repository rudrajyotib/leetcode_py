package interviewbit.solutions;

import ds.util.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class FlattenBinaryTreeToLinkedListTest {

    @Test
    public void shouldHandleTreeWithSingleNode(){
        TreeNode flatNode = new FlattenBinaryTreeToLinkedList().solve(new TreeNode(1));
        assertNotNull(flatNode);
        assertEquals(1, flatNode.val);
        assertNull(flatNode.left);
        assertNull(flatNode.right);
    }

    @Test
    public void shouldHandleLeftJustifiedTree(){
        TreeNode originalRoot=
               new TreeNode(1,
                       new TreeNode(2,
                               new TreeNode(3),
                               null),
                       null);
        TreeNode flatNode = new FlattenBinaryTreeToLinkedList().solve(originalRoot);
        assertSame(originalRoot, flatNode);
        assertEquals(1, flatNode.val);
        assertEquals(2, flatNode.right.val);
        assertEquals(3, flatNode.right.right.val);
        assertNull(flatNode.left);
        assertNull(flatNode.right.left);
        assertNull(flatNode.right.right.left);

    }


    @Test
    public void shouldFlattenRightJustifiedTree(){
        TreeNode treeNode =
                new TreeNode(1,
                        null,
                        new TreeNode(2,
                                null,
                                new TreeNode(3)));
        TreeNode flatNode = new FlattenBinaryTreeToLinkedList().solve(treeNode);
        assertSame(flatNode, treeNode);
        assertEquals(1, flatNode.val);
        assertEquals(2, flatNode.right.val);
        assertEquals(3, flatNode.right.right.val);

        assertNull(treeNode.left);
        assertNull(treeNode.right.left);
        assertNull(treeNode.right.right.left);
    }

    @Test
    public void shouldFlattenDistributedBinaryTree()
    {
        TreeNode originalRoot =
                new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(3),
                                new TreeNode(4)),
                        new TreeNode(5,
                                new TreeNode(6),
                                new TreeNode(7)));

        TreeNode flatNode = new FlattenBinaryTreeToLinkedList().solve(originalRoot);
        assertSame(flatNode, originalRoot);
        for (int i=1;i<=7;i++){
            assertEquals(i, flatNode.val);
            assertNull(flatNode.left);
            flatNode = flatNode.right;
        }
        assertNull(flatNode);
    }

}