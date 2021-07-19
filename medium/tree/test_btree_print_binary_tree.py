from typing import List
from unittest import TestCase

from medium.tree.btree_print_binary_tree import TreeNode, Solution


class TestSolution(TestCase):
    def test_should_print_right_aligned_tree(self):
        level2_child1 = TreeNode(val=3)
        level1_child1 = TreeNode(val=2, right=level2_child1)
        root = TreeNode(val=1, right=level1_child1)

        solution = Solution()

        result: List[List[str]] = solution.printTree(root)

        self.assertEqual(3, len(result), "Full depth of tree not covered in printing")
        self.assertEqual("1", result[0][3], "Root node not printed at correct cell")

    def test_should_print_single_node(self):
        root = TreeNode(val=1)
        solution = Solution()
        result: List[List[str]] = solution.printTree(root)
        self.assertEqual(1, len(result), "one row not created")
        self.assertEqual(1, len(result[0]), "one column not created")
        self.assertEqual("1", result[0][0], "single node not placed")
