from unittest import TestCase

from medium.tree.btree_find_bottom_left_node import TreeNode, Solution


class TestSolution(TestCase):
    def test_should_find_bottom_left_most_node_set1(self):
        level3_child1 = TreeNode(val=4)
        level2_child1 = TreeNode(val=6)
        level2_child2 = TreeNode(val=5, left=level3_child1)
        level1_child1 = TreeNode(val=8, left=level2_child1)
        level1_child2 = TreeNode(val=8, right=level2_child2)
        root = TreeNode(val=10, left=level1_child1, right=level1_child2)

        solution = Solution()

        self.assertEqual(4, solution.findBottomLeftValue(root=root), "Bottom left node not found")

    def test_should_find_bottom_left_most_node_set2(self):
        level3_child1 = TreeNode(val=4)
        level3_child2 = TreeNode(val=3)
        level2_child1 = TreeNode(val=6, right=level3_child2)
        level2_child2 = TreeNode(val=5, left=level3_child1)
        level1_child1 = TreeNode(val=8, left=level2_child1)
        level1_child2 = TreeNode(val=8, right=level2_child2)
        root = TreeNode(val=10, left=level1_child1, right=level1_child2)

        solution = Solution()

        self.assertEqual(3, solution.findBottomLeftValue(root=root), "Bottom left node not found")

    def test_should_find_bottom_left_of_root_node(self):
        solution = Solution()
        self.assertEqual(1, solution.findBottomLeftValue(TreeNode(val=1)), "single node tree not handled")

    def test_should_find_bottom_left_of_left_only_tree(self):
        level2_child1 = TreeNode(val=3)
        level1_child1 = TreeNode(val=2, left=level2_child1)
        root = TreeNode(val=1, left=level1_child1)

        solution = Solution()
        self.assertEqual(3, solution.findBottomLeftValue(root=root), "left aligned tree not handled")