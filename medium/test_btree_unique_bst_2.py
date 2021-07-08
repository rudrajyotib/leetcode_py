from typing import List
from unittest import TestCase

from lazy_streams import stream

from medium.btree_unique_bst_2 import Solution, TreeNode


class TestSolution(TestCase):

    def test_should_generate_all_bst(self):
        solution = Solution()
        trees: List[TreeNode] = solution.generateTrees(3)
        self.assertIsNotNone(trees, "tress not generated")
        self.assertEqual(5, len(trees), "not all trees generated")
        trees_with_root_1 = stream(trees) \
            .filter(lambda tree: tree.val == 1) \
            .size()
        self.assertEqual(2, trees_with_root_1, "Not all Trees with Root 1 listed")
