package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class RecoverBinarySearchTreeTest {

    @Test
    public void test_recover_tree() {
        RecoverBinarySearchTree.TreeNode level4_child1 = new RecoverBinarySearchTree.TreeNode( 15);
        RecoverBinarySearchTree.TreeNode level3_child1 = new RecoverBinarySearchTree.TreeNode( 7);
        RecoverBinarySearchTree.TreeNode level3_child2 = new RecoverBinarySearchTree.TreeNode( 4, null, level4_child1);
        RecoverBinarySearchTree.TreeNode level2_child1 = new RecoverBinarySearchTree.TreeNode( 2);
        RecoverBinarySearchTree.TreeNode level2_child2 = new RecoverBinarySearchTree.TreeNode( 8, level3_child1,  level3_child2);
        RecoverBinarySearchTree.TreeNode level1_child1 = new RecoverBinarySearchTree.TreeNode( 3, level2_child1, null);
        RecoverBinarySearchTree.TreeNode level1_child2 = new RecoverBinarySearchTree.TreeNode( 6, null, level2_child2);
        RecoverBinarySearchTree.TreeNode root = new RecoverBinarySearchTree.TreeNode( 10,  level1_child1, level1_child2);

        RecoverBinarySearchTree solution =new RecoverBinarySearchTree();
        solution.solve(root);
        assertEquals(4, root.val);
        assertEquals(10, level3_child2.val);
    }

    @Test
    public void test_should_recover_tree_when_right_most_node_and_root_is_swapped(){
        RecoverBinarySearchTree.TreeNode level4_child1 = new RecoverBinarySearchTree.TreeNode(4);
        RecoverBinarySearchTree.TreeNode level3_child1 = new RecoverBinarySearchTree.TreeNode(7);
        RecoverBinarySearchTree.TreeNode level3_child2 = new RecoverBinarySearchTree.TreeNode(10, null, level4_child1);
        RecoverBinarySearchTree.TreeNode level2_child1 = new RecoverBinarySearchTree.TreeNode(2);
        RecoverBinarySearchTree.TreeNode level2_child2 = new RecoverBinarySearchTree.TreeNode(8, level3_child1, level3_child2);
        RecoverBinarySearchTree.TreeNode level1_child1 = new RecoverBinarySearchTree.TreeNode(3, level2_child1, null);
        RecoverBinarySearchTree.TreeNode level1_child2 = new RecoverBinarySearchTree.TreeNode(6, null, level2_child2);
        RecoverBinarySearchTree.TreeNode root = new RecoverBinarySearchTree.TreeNode(15, level1_child1, level1_child2);

        RecoverBinarySearchTree solution =new RecoverBinarySearchTree();
        solution.solve(root);

        assertEquals(4, root.val);
        assertEquals(15, level4_child1.val);
        assertEquals(8, level2_child2.val);
    }

    @Test
    public void test_should_recover_tree_when_right_most_node_and_parent_is_swapped(){
        RecoverBinarySearchTree.TreeNode level4_child1 = new RecoverBinarySearchTree.TreeNode(10);
        RecoverBinarySearchTree.TreeNode level3_child1 = new RecoverBinarySearchTree.TreeNode(7);
        RecoverBinarySearchTree.TreeNode level3_child2 = new RecoverBinarySearchTree.TreeNode(15, null, level4_child1);
        RecoverBinarySearchTree.TreeNode level2_child1 = new RecoverBinarySearchTree.TreeNode(2);
        RecoverBinarySearchTree.TreeNode level2_child2 = new RecoverBinarySearchTree.TreeNode(8, level3_child1, level3_child2);
        RecoverBinarySearchTree.TreeNode level1_child1 = new RecoverBinarySearchTree.TreeNode(3, level2_child1, null);
        RecoverBinarySearchTree.TreeNode level1_child2 = new RecoverBinarySearchTree.TreeNode(6, null, level2_child2);
        RecoverBinarySearchTree.TreeNode root = new RecoverBinarySearchTree.TreeNode(4, level1_child1, level1_child2);

        RecoverBinarySearchTree solution =new RecoverBinarySearchTree();
        solution.solve(root);

        assertEquals(4, root.val);
        assertEquals(15, level4_child1.val);
        assertEquals(10, level3_child2.val);
        assertEquals(3, level1_child1.val);
        assertEquals(2, level2_child1.val);
    }
}