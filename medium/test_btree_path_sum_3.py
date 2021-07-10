from unittest import TestCase

from medium.btree_path_sum_3 import TreeNode, Solution


class TestSolution(TestCase):
    def test_should_find_paths_simple_tree(self):
        level1_child1 = TreeNode(val=2)
        level1_child2 = TreeNode(val=3)
        root = TreeNode(val=1, left=level1_child1, right=level1_child2)

        solution = Solution()
        possible_paths = solution.pathSum(root, 3)
        self.assertEqual(2, possible_paths, "not all paths found")

        impossible_paths = solution.pathSum(root, 100)
        self.assertEqual(0, impossible_paths, "impossible paths counted")

    def test_should_handle_none_root(self):
        solution = Solution()
        # noinspection PyTypeChecker
        self.assertEqual(0, solution.pathSum(root=None, targetSum=1), "None cannot be handled")
