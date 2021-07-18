from unittest import TestCase

from medium.tree.btree_largest_value_in_each_row import Solution, TreeNode


class TestSolution(TestCase):
    def test_should_return_root_for_single_node_tree(self):
        solution = Solution()
        self.assertEqual([100], solution.largestValues(root=TreeNode(val=100)), "single node tree not handled")

    def test_should_handle_empty_tree(self):
        solution = Solution()
        # noinspection PyTypeChecker
        self.assertEqual([], solution.largestValues(root=None), "single node tree not handled")

    def test_should_return_largest_val_each_row_set1(self):
        level2_child1 = TreeNode(val=4)
        level2_child2 = TreeNode(val=5)

        level1_child1 = TreeNode(val=2)
        level1_child2 = TreeNode(val=3, left=level2_child1, right=level2_child2)

        root = TreeNode(val=1, left=level1_child1, right=level1_child2)

        solution = Solution()

        self.assertEqual([1,3,5], solution.largestValues(root=root), "Largest values in each row not counted")