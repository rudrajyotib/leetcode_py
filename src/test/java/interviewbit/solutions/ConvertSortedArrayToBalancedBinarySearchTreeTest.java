package interviewbit.solutions;

import ds.util.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConvertSortedArrayToBalancedBinarySearchTreeTest {

    @Test
    public void shouldCreateBalancedBinarySearchTree(){
        TreeNode treeNode = new ConvertSortedArrayToBalancedBinarySearchTree().solve(
                new int[]{1, 2, 3, 4, 5}
        );
        assertEquals(3, treeNode.val);
        assertEquals(1, treeNode.left.val);
        assertEquals(2, treeNode.left.right.val);
        assertEquals(4, treeNode.right.val);
        assertEquals(5, treeNode.right.right.val);
        assertNull(treeNode.left.left);
        assertNull(treeNode.left.right.left);
        assertNull(treeNode.left.right.right);
        assertNull(treeNode.right.left);
        assertNull(treeNode.right.right.left);
    }

    @Test
    public void shouldHandleNullArray(){
        assertNull(new ConvertSortedArrayToBalancedBinarySearchTree().solve(null));
    }

    @Test
    public void shouldHandleEmptyArray(){
        assertNull(new ConvertSortedArrayToBalancedBinarySearchTree().solve(new int[]{}));
    }

    @Test
    public void shouldHandleSingleSizeArray(){
        TreeNode node = new ConvertSortedArrayToBalancedBinarySearchTree().solve(new int[]{1});
        assertEquals(1, node.val);
        assertNull(node.right);
        assertNull(node.left);
    }

}