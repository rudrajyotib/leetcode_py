package interviewbit.solutions;

import ds.util.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class InorderTraversalOfCartesianTreeTest {

    @Test
    public void shouldCreateDistributedCartesianTree(){
        TreeNode root = new InorderTraversalOfCartesianTree().solve(new int[]{10, 30, 7, 15, 5, 40, 19, 21, 35, 26, 17});
        assertNotNull(root);
        assertEquals(40, root.val);
        assertEquals(30, root.left.val);
        assertEquals(10, root.left.left.val);
        assertNull(root.left.left.left);
        assertNull(root.left.left.right);
        assertEquals(15, root.left.right.val);
        assertEquals(7, root.left.right.left.val);
        assertEquals(5, root.left.right.right.val);
        assertNull(root.left.right.left.left);
        assertNull(root.left.right.left.right);
        assertNull(root.left.right.right.left);
        assertNull(root.left.right.right.right);
        assertEquals(35, root.right.val);
        assertEquals(21, root.right.left.val);
        assertEquals(19, root.right.left.left.val);
        assertNull(root.right.left.left.left);
        assertNull(root.right.left.left.right);
        assertNull(root.right.left.right);
    }

    @Test
    public void shouldCreateLeftAlignedTree(){
         TreeNode root = new InorderTraversalOfCartesianTree().solve(new int[]{1,2,3});
        assertNotNull(root);
        assertEquals(3, root.val);
        assertEquals(2, root.left.val);
        assertEquals(1, root.left.left.val);
        assertNull(root.left.left.left);
        assertNull(root.left.left.right);
        assertNull(root.left.right);
        assertNull(root.right);

    }

    @Test
    public void shouldCreateRightAlignedTree(){
         TreeNode root = new InorderTraversalOfCartesianTree().solve(new int[]{3,2,1});
        assertNotNull(root);
        assertEquals(3, root.val);
        assertEquals(2, root.right.val);
        assertEquals(1, root.right.right.val);
        assertNull(root.right.right.left);
        assertNull(root.right.right.right);
        assertNull(root.right.left);
        assertNull(root.left);
    }


    @Test
    public void shouldCreateSingleNodeTree(){
         TreeNode root = new InorderTraversalOfCartesianTree().solve(new int[]{3});
        assertNotNull(root);
        assertEquals(3, root.val);
        assertNull(root.left);
        assertNull(root.right);
    }



}