from unittest import TestCase

from medium.tree.btree_count_complete_tree_nodes import TreeNode, Solution


class TestSolution(TestCase):
    def test_should_count_all_nodes(self):
        level2_child1 = TreeNode(val=1)
        level2_child2 = TreeNode(val=3)
        level2_child3 = TreeNode(val=5)
        level2_child4 = TreeNode(val=7)

        level1_child1 = TreeNode(val=2, left=level2_child1, right=level2_child2)
        level1_child2 = TreeNode(val=6, left=level2_child3, right=level2_child4)

        root = TreeNode(val=4, left=level1_child1, right=level1_child2)

        solution = Solution()

        self.assertEqual(7, solution.countNodes(root), "Not all nodes counted")

    def test_should_count_single_node_tree(self):
        solution = Solution()
        self.assertEqual(1, solution.countNodes(TreeNode(val=1)), "single node tree count failed")

    def test_should_count_empty_node_tree(self):
        solution = Solution()
        # noinspection PyTypeChecker
        self.assertEqual(0, solution.countNodes(root=None), "Empty nodes not handled")

    def test_should_count_right_heavy_tree(self):
        level2_child1 = TreeNode(val=1)
        level2_child2 = TreeNode(val=2)

        level1_child1 = TreeNode(val=3, left=level2_child1, right=level2_child2)

        root = TreeNode(4, right=level1_child1)

        solution = Solution()
        self.assertEqual(4, solution.countNodes(root), "Right heavy tree nodes count failed")

    def test_should_count_left_heavy_tree(self):
        level2_child1 = TreeNode(val=1)
        level2_child2 = TreeNode(val=2)

        level1_child1 = TreeNode(val=3, left=level2_child1, right=level2_child2)

        root = TreeNode(4, left=level1_child1)

        solution = Solution()
        self.assertEqual(4, solution.countNodes(root), "Left heavy tree nodes count failed")
