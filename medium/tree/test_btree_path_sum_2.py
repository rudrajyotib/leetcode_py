from unittest import TestCase

from medium.tree.btree_path_sum_2 import TreeNode, Solution


class TestSolution(TestCase):
    def test_should_find_sums(self):
        level3_child1 = TreeNode(val=1)
        level3_child2 = TreeNode(val=1)
        level3_child3 = TreeNode(val=1)
        level3_child4 = TreeNode(val=1)
        level3_child5 = TreeNode(val=2)
        level3_child6 = TreeNode(val=2)

        level2_child1 = TreeNode(val=2)
        level2_child2 = TreeNode(val=1, left=level3_child1, right=level3_child2)
        level2_child3 = TreeNode(val=2, left=level3_child3, right=level3_child4)
        level2_child4 = TreeNode(val=1, left=level3_child5, right=level3_child6)

        level1_child1 = TreeNode(val=2, left=level2_child1, right=level2_child2)
        level1_child2 = TreeNode(val=1, left=level2_child3, right=level2_child4)

        root = TreeNode(val=1, left=level1_child1, right=level1_child2)

        solution = Solution()

        result = solution.pathSum(root, 5)

        self.assertEqual(7, len(result), "not all possible paths counted")

        invalid_sum = solution.pathSum(root, 100)
        self.assertEqual(0, len(invalid_sum), "impossible paths counted")

        midway_result = solution.pathSum(root, 3)
        self.assertEqual(0, len(midway_result), "non-leaf node counted")

        # noinspection PyTypeChecker
        self.assertEqual(0, len(solution.pathSum(root=None, targetSum=1)), "not null safe")
        self.assertEqual(1, len(solution.pathSum(root=TreeNode(val=1), targetSum=1)), "should handle single node")
