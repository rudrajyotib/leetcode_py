from unittest import TestCase

from medium.tree.btree_sum_of_nodes_with_even_valued_grandparent import TreeNode, Solution


class TestSolution(TestCase):
    def test_sum_even_grandparent_set1(self):
        root = TreeNode(val=2,
                        left=TreeNode(val=4,
                                      left=TreeNode(val=1,
                                                    left=TreeNode(val=6),
                                                    right=TreeNode(val=7)),
                                      right=TreeNode(val=2,
                                                     left=TreeNode(val=10),
                                                     right=TreeNode(val=15))),
                        right=TreeNode(val=4))

        solution = Solution()
        self.assertEqual(41, solution.sumEvenGrandparent(root=root), "not all grandchildren counted")

    def test_sum_even_grandparent_set2(self):
        root = TreeNode(val=21,
                        left=TreeNode(val=41,
                                      left=TreeNode(val=1,
                                                    left=TreeNode(val=61),
                                                    right=TreeNode(val=71)),
                                      right=TreeNode(val=21,
                                                     left=TreeNode(val=101),
                                                     right=TreeNode(val=151))),
                        right=TreeNode(val=41))

        solution = Solution()
        self.assertEqual(0, solution.sumEvenGrandparent(root=root), "not all grandchildren counted")

    def test_sum_even_grandparent_set3(self):
        root = TreeNode(val=21,
                        left=TreeNode(val=41),
                        right=TreeNode(val=41))

        solution = Solution()
        self.assertEqual(0, solution.sumEvenGrandparent(root=root), "not all grandchildren counted")
