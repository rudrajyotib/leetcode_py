from typing import List
from unittest import TestCase

from medium.tree.btree_all_possible_full_binary_trees import TreeNode, Solution


class TestSolution(TestCase):
    def test_all_possible_fbt_set1(self):
        result: List[TreeNode]
        solution = Solution()
        result = solution.allPossibleFBT(7)
        self.assertIsNotNone(result)
        self.assertEqual(5, len(result), "not all trees printed")
