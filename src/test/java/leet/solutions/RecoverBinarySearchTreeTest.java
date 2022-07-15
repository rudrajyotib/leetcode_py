package leet.solutions;

import ds.util.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecoverBinarySearchTreeTest {

    @Test
    public void test_recover_tree() {
         TreeNode level4_child1 = new  TreeNode( 15);
         TreeNode level3_child1 = new  TreeNode( 7);
         TreeNode level3_child2 = new  TreeNode( 4, null, level4_child1);
         TreeNode level2_child1 = new  TreeNode( 2);
         TreeNode level2_child2 = new  TreeNode( 8, level3_child1,  level3_child2);
         TreeNode level1_child1 = new  TreeNode( 3, level2_child1, null);
         TreeNode level1_child2 = new  TreeNode( 6, null, level2_child2);
         TreeNode root = new  TreeNode( 10,  level1_child1, level1_child2);

        RecoverBinarySearchTree solution =new RecoverBinarySearchTree();
        solution.solve(root);
        assertEquals(4, root.val);
        assertEquals(10, level3_child2.val);
    }

    @Test
    public void test_should_recover_tree_when_right_most_node_and_root_is_swapped(){
         TreeNode level4_child1 = new  TreeNode(4);
         TreeNode level3_child1 = new  TreeNode(7);
         TreeNode level3_child2 = new  TreeNode(10, null, level4_child1);
         TreeNode level2_child1 = new  TreeNode(2);
         TreeNode level2_child2 = new  TreeNode(8, level3_child1, level3_child2);
         TreeNode level1_child1 = new  TreeNode(3, level2_child1, null);
         TreeNode level1_child2 = new  TreeNode(6, null, level2_child2);
         TreeNode root = new  TreeNode(15, level1_child1, level1_child2);

        RecoverBinarySearchTree solution =new RecoverBinarySearchTree();
        solution.solve(root);

        assertEquals(4, root.val);
        assertEquals(15, level4_child1.val);
        assertEquals(8, level2_child2.val);
    }

    @Test
    public void test_should_recover_tree_when_right_most_node_and_parent_is_swapped(){
         TreeNode level4_child1 = new  TreeNode(10);
         TreeNode level3_child1 = new  TreeNode(7);
         TreeNode level3_child2 = new  TreeNode(15, null, level4_child1);
         TreeNode level2_child1 = new  TreeNode(2);
         TreeNode level2_child2 = new  TreeNode(8, level3_child1, level3_child2);
         TreeNode level1_child1 = new  TreeNode(3, level2_child1, null);
         TreeNode level1_child2 = new  TreeNode(6, null, level2_child2);
         TreeNode root = new  TreeNode(4, level1_child1, level1_child2);

        RecoverBinarySearchTree solution =new RecoverBinarySearchTree();
        solution.solve(root);

        assertEquals(4, root.val);
        assertEquals(15, level4_child1.val);
        assertEquals(10, level3_child2.val);
        assertEquals(3, level1_child1.val);
        assertEquals(2, level2_child1.val);
    }
}