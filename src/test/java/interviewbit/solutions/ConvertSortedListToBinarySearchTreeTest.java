package interviewbit.solutions;

import ds.util.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConvertSortedListToBinarySearchTreeTest {


    @Test
    public void shouldCreateBstFromOddSizeListSet1(){
        assertEquals("12345",
                new ConvertSortedListToBinarySearchTree().solve(
                        new ListNode(1,
                                new ListNode(2,
                                        new ListNode(3,
                                                new ListNode(4,
                                                        new ListNode(5)))))
                ).inOrder());
    }

    @Test
    public void shouldCreateBstFromEvenSizeListSet1(){
        assertEquals("123456",
                new ConvertSortedListToBinarySearchTree().solve(
                        new ListNode(1,
                                new ListNode(2,
                                        new ListNode(3,
                                                new ListNode(4,
                                                        new ListNode(5,
                                                                new ListNode(6))))))
                ).inOrder());
    }

    @Test
    public void shouldCreateBstFromOddSizeListSet3(){
        ConvertSortedListToBinarySearchTree.TreeNode treeNode = new ConvertSortedListToBinarySearchTree().solve(
                new ListNode(1,
                        new ListNode(4,
                                new ListNode(5,
                                        new ListNode(7,
                                                new ListNode(8,
                                                        new ListNode(10,
                                                                new ListNode(12)))))))
        );
        assertEquals(7, treeNode.val);
        assertEquals(4, treeNode.left.val);
        assertEquals(1, treeNode.left.left.val);
        assertEquals(5, treeNode.left.right.val);
        assertNull(treeNode.left.left.left);
        assertNull(treeNode.left.left.right);
        assertNull(treeNode.left.right.left);
        assertNull(treeNode.left.right.right);
        assertEquals(10, treeNode.right.val);
        assertEquals(8, treeNode.right.left.val);
        assertEquals(12, treeNode.right.right.val);
        assertNull(treeNode.right.left.left);
        assertNull(treeNode.right.left.right);
        assertNull(treeNode.right.right.left);
        assertNull(treeNode.right.right.right);
    }

    @Test
    public void shouldCreateSingleNodeTree(){
        ConvertSortedListToBinarySearchTree.TreeNode treeNode = new ConvertSortedListToBinarySearchTree().solve(
                new ListNode(1));
        assertEquals(1, treeNode.val);
        assertNull(treeNode.left);
        assertNull(treeNode.right);
    }

    @Test
    public void shouldHandleNullList(){
        assertNull(new ConvertSortedListToBinarySearchTree().solve(null));
    }


}