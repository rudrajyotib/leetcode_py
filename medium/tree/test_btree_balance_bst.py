from unittest import TestCase

from medium.tree.btree_balance_bst import TreeNode, Solution


class TestSolution(TestCase):
    def test_should_balance_bst_set1(self):
        root = TreeNode(val=8,
                        left=TreeNode(val=6),
                        right=TreeNode(val=10,
                                       right=TreeNode(val=12,
                                                      right=TreeNode(val=14,
                                                                     right=TreeNode(val=16)))))
        solution = Solution()
        balanced_root = solution.balanceBST(root=root)
        self.assertEqual(10, balanced_root.val)

    def test_should_balance_bst_set2(self):
        root = TreeNode(val=8,
                        left=TreeNode(val=6,
                                      left=TreeNode(val=3,
                                                    left=TreeNode(val=2, left=TreeNode(val=1)),
                                                    right=TreeNode(val=4, right=TreeNode(val=5))),
                                      right=TreeNode(val=7)),
                        right=TreeNode(val=10,
                                       right=TreeNode(val=12,
                                                      right=TreeNode(val=14,
                                                                     right=TreeNode(val=16)))))
        solution = Solution()
        balanced_root = solution.balanceBST(root=root)
        self.assertEqual(6, balanced_root.val)
