from unittest import TestCase

from medium.tree.btree_validate_binary_tree_nodes import Solution


class TestSolution(TestCase):
    def test_validate_binary_tree_nodes_set1(self):
        solution = Solution()
        self.assertTrue(solution.validateBinaryTreeNodes(n=4,
                                                         leftChild=[1, 3, -1, -1],
                                                         rightChild=[2, -1, -1, -1]), "Valid tree not identified")
        self.assertTrue(solution.validateBinaryTreeNodes(n=4,
                                                         leftChild=[-1, -1, 1, 0],
                                                         rightChild=[-1, -1, 3, -1]), "Valid tree not identified")
        self.assertFalse(solution.validateBinaryTreeNodes(n=4,
                                                          leftChild=[1, 0, 3, -1],
                                                          rightChild=[-1, -1, -1, -1]), "Invalid tree not identified")
        self.assertFalse(solution.validateBinaryTreeNodes(n=4,
                                                          leftChild=[1, 2, 0, -1],
                                                          rightChild=[-1, -1, -1, -1]), "Invalid tree not identified")
        self.assertTrue(solution.validateBinaryTreeNodes(n=1,
                                                         leftChild=[-1],
                                                         rightChild=[-1]), "Single node tree could not validate")
