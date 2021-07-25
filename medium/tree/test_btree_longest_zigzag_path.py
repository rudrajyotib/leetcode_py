from unittest import TestCase

from medium.tree.btree_longest_zigzag_path import TreeNode, Solution


class TestSolution(TestCase):
    def test_longest_zig_zag_set1(self):
        tree = TreeNode(val=1,
                        left=TreeNode(val=1,
                                      left=TreeNode(val=1),
                                      right=TreeNode(val=1)),
                        right=TreeNode(val=1,
                                       left=TreeNode(val=1,
                                                     left=TreeNode(val=1),
                                                     right=TreeNode(val=1)),
                                       right=TreeNode(val=1)))

        solution = Solution()
        self.assertEqual(3, solution.longestZigZag(root=tree), "longest path not checked")

    def test_longest_zig_zag_set2(self):
        tree = TreeNode(val=1)
        solution = Solution()
        self.assertEqual(0, solution.longestZigZag(root=tree))

    def test_longest_zig_zag_set3(self):
        tree = TreeNode(val=1,
                        left=TreeNode(val=1,
                                      left=TreeNode(val=1,
                                                    left=TreeNode(val=1),
                                                    right=TreeNode(val=1,
                                                                   left=TreeNode(val=1,
                                                                                 left=TreeNode(val=1,
                                                                                               left=TreeNode(val=1),
                                                                                               right=TreeNode(val=1)),
                                                                                 right=TreeNode(val=1)),
                                                                   right=TreeNode(val=1))),
                                      right=TreeNode(val=1)),
                        right=TreeNode(val=1,
                                       left=TreeNode(val=1,
                                                     left=TreeNode(val=1),
                                                     right=TreeNode(val=1)),
                                       right=TreeNode(val=1)))

        solution = Solution()
        self.assertEqual(4, solution.longestZigZag(root=tree), "longest path not checked")
