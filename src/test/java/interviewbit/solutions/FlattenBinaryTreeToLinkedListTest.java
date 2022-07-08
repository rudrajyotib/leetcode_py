package interviewbit.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class FlattenBinaryTreeToLinkedListTest {

    @Test
    public void shouldHandleTreeWithSingleNode(){
        FlattenBinaryTreeToLinkedList.TreeNode flatNode = new FlattenBinaryTreeToLinkedList().solve(new FlattenBinaryTreeToLinkedList.TreeNode(1));
        assertNotNull(flatNode);
        assertEquals(1, flatNode.val);
        assertNull(flatNode.left);
        assertNull(flatNode.right);
    }

    @Test
    public void shouldHandleLeftJustifiedTree(){
        FlattenBinaryTreeToLinkedList.TreeNode originalRoot=
               new FlattenBinaryTreeToLinkedList.TreeNode(1,
                       new FlattenBinaryTreeToLinkedList.TreeNode(2,
                               new FlattenBinaryTreeToLinkedList.TreeNode(3),
                               null),
                       null);
        FlattenBinaryTreeToLinkedList.TreeNode flatNode = new FlattenBinaryTreeToLinkedList().solve(originalRoot);
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
        FlattenBinaryTreeToLinkedList.TreeNode treeNode =
                new FlattenBinaryTreeToLinkedList.TreeNode(1,
                        null,
                        new FlattenBinaryTreeToLinkedList.TreeNode(2,
                                null,
                                new FlattenBinaryTreeToLinkedList.TreeNode(3)));
        FlattenBinaryTreeToLinkedList.TreeNode flatNode = new FlattenBinaryTreeToLinkedList().solve(treeNode);
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
        FlattenBinaryTreeToLinkedList.TreeNode originalRoot =
                new FlattenBinaryTreeToLinkedList.TreeNode(1,
                        new FlattenBinaryTreeToLinkedList.TreeNode(2,
                                new FlattenBinaryTreeToLinkedList.TreeNode(3),
                                new FlattenBinaryTreeToLinkedList.TreeNode(4)),
                        new FlattenBinaryTreeToLinkedList.TreeNode(5,
                                new FlattenBinaryTreeToLinkedList.TreeNode(6),
                                new FlattenBinaryTreeToLinkedList.TreeNode(7)));

        FlattenBinaryTreeToLinkedList.TreeNode flatNode = new FlattenBinaryTreeToLinkedList().solve(originalRoot);
        assertSame(flatNode, originalRoot);
        for (int i=1;i<=7;i++){
            assertEquals(i, flatNode.val);
            assertNull(flatNode.left);
            flatNode = flatNode.right;
        }
        assertNull(flatNode);
    }

}