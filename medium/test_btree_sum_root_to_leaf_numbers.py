from unittest import TestCase

from medium.btree_sum_root_to_leaf_numbers import TreeNode, Solution


class TestTreeNode(TestCase):
    def test_should_sum_singleNode(self):
        root = TreeNode(val=1)
        solution = Solution()
        sum = solution.sumNumbers(root)
        self.assertEqual(1, sum, "Sum does not match")

    def test_should_sum_one_child_level(self):
        root = TreeNode(val=1)
        level1_child1 = TreeNode(val=1)
        level1_child2 = TreeNode(val=1)
        root.left = level1_child1
        root.right = level1_child2
        solution = Solution()
        sum = solution.sumNumbers(root)
        self.assertEqual(22, sum, "Sum does not match")

    def test_should_sum_mix_child_level(self):
        level3_child1 = TreeNode(val=6)
        level3_child2 = TreeNode(val=5)
        level2_child1 = TreeNode(val=4, left=level3_child1, right=level3_child2)
        level1_child2 = TreeNode(val=3, right=level2_child1)
        level1_child1 = TreeNode(val=2)
        root = TreeNode(val=1, left=level1_child1, right=level1_child2)
        solution = Solution()
        sum = solution.sumNumbers(root)
        self.assertEqual(2703, sum, "Sum does not match")

    def test_should_handle_none_root(self):
        solution = Solution()
        # noinspection PyTypeChecker
        self.assertEqual(0, solution.sumNumbers(root=None), "None root not handled")
