from unittest import TestCase

from medium.tree.btree_recover_bst import TreeNode, Solution


class TestSolution(TestCase):
    def test_recover_tree(self):
        level4_child1 = TreeNode(val=15)
        level3_child1 = TreeNode(val=7)
        level3_child2 = TreeNode(val=4, right=level4_child1)
        level2_child1 = TreeNode(val=2)
        level2_child2 = TreeNode(val=8, left=level3_child1, right=level3_child2)
        level1_child1 = TreeNode(val=3, left=level2_child1)
        level1_child2 = TreeNode(val=6, right=level2_child2)
        root = TreeNode(val=10, left=level1_child1, right=level1_child2)

        solution = Solution()
        solution.recoverTree(root)
        self.assertEqual(4, root.val, "root not swapped")
        self.assertEqual(10, level3_child2.val, "child not swapped")

    def test_should_recover_tree_when_right_most_node_and_root_is_swapped(self):
        level4_child1 = TreeNode(val=4)
        level3_child1 = TreeNode(val=7)
        level3_child2 = TreeNode(val=10, right=level4_child1)
        level2_child1 = TreeNode(val=2)
        level2_child2 = TreeNode(val=8, left=level3_child1, right=level3_child2)
        level1_child1 = TreeNode(val=3, left=level2_child1)
        level1_child2 = TreeNode(val=6, right=level2_child2)
        root = TreeNode(val=15, left=level1_child1, right=level1_child2)

        solution = Solution()
        solution.recoverTree(root)

        self.assertEqual(4, root.val, "Root not swapped")
        self.assertEqual(15, level4_child1.val, "Right most node not swapped")
        self.assertEqual(8, level2_child2.val, "Correct node affected")

    def test_should_recover_tree_when_left_most_node_and_parent_is_swapped(self):
        level4_child1 = TreeNode(val=15)
        level3_child1 = TreeNode(val=7)
        level3_child2 = TreeNode(val=10, right=level4_child1)
        level2_child1 = TreeNode(val=3)
        level2_child2 = TreeNode(val=8, left=level3_child1, right=level3_child2)
        level1_child1 = TreeNode(val=2, left=level2_child1)
        level1_child2 = TreeNode(val=6, right=level2_child2)
        root = TreeNode(val=4, left=level1_child1, right=level1_child2)

        solution = Solution()
        solution.recoverTree(root)

        self.assertEqual(4, root.val, "Root swapped")
        self.assertEqual(15, level4_child1.val, "Right most node swapped")
        self.assertEqual(3, level1_child1.val, "Node not swapped")
        self.assertEqual(2, level2_child1.val, "Node not swapped")

    def test_should_recover_tree_when_right_most_node_and_parent_is_swapped(self):
        level4_child1 = TreeNode(val=10)
        level3_child1 = TreeNode(val=7)
        level3_child2 = TreeNode(val=15, right=level4_child1)
        level2_child1 = TreeNode(val=2)
        level2_child2 = TreeNode(val=8, left=level3_child1, right=level3_child2)
        level1_child1 = TreeNode(val=3, left=level2_child1)
        level1_child2 = TreeNode(val=6, right=level2_child2)
        root = TreeNode(val=4, left=level1_child1, right=level1_child2)

        solution = Solution()
        solution.recoverTree(root)

        self.assertEqual(4, root.val, "Root swapped")
        self.assertEqual(15, level4_child1.val, "Right most node swapped")
        self.assertEqual(3, level1_child1.val, "Node not swapped")
        self.assertEqual(2, level2_child1.val, "Node not swapped")

    def test_should_recover_tree_when_lef_and_right_subtree_node_is_swapped(self):
        level4_child1 = TreeNode(val=15)
        level3_child1 = TreeNode(val=7)
        level3_child2 = TreeNode(val=10, right=level4_child1)
        level2_child1 = TreeNode(val=2)
        level2_child2 = TreeNode(val=3, left=level3_child1, right=level3_child2)
        level1_child1 = TreeNode(val=8, left=level2_child1)
        level1_child2 = TreeNode(val=6, right=level2_child2)
        root = TreeNode(val=4, left=level1_child1, right=level1_child2)

        solution = Solution()
        solution.recoverTree(root)

        self.assertEqual(4, root.val, "Root swapped")
        self.assertEqual(15, level4_child1.val, "Right most node swapped")
        self.assertEqual(2, level2_child1.val, "Left most node swapped")
        self.assertEqual(3, level1_child1.val, "Node not swapped")
        self.assertEqual(8, level2_child2.val, "Node not swapped")
