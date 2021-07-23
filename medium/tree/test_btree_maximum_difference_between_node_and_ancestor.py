from unittest import TestCase

from medium.tree.btree_maximum_difference_between_node_and_ancestor import TreeNode, Solution


class TestSolution(TestCase):
    def test_max_ancestor_diff_set1(self):
        level3_child1 = TreeNode(val=75)
        level3_child2 = TreeNode(val=80)

        level2_child1 = TreeNode(val=77, left=level3_child1)
        level2_child2 = TreeNode(val=30, right=level3_child2)
        level2_child3 = TreeNode(val=20)

        level1_child1 = TreeNode(val=90, left=level2_child1, right=level2_child2)
        level1_child2 = TreeNode(val=80, right=level2_child3)

        root = TreeNode(val=100, left=level1_child1, right=level1_child2)

        solution = Solution()

        self.assertEqual(80, solution.maxAncestorDiff(root=root), "Max diff not calculated")

    def test_max_ancestor_diff_set2(self):
        solution = Solution()
        self.assertEqual(0, solution.maxAncestorDiff(root=TreeNode(val=80)), "Max diff not calculated")

    def test_max_ancestor_diff_set3(self):
        solution = Solution()
        self.assertEqual(0, solution.maxAncestorDiff(root=TreeNode(val=80, left=TreeNode(val=80))),
                         "Max diff not calculated")
