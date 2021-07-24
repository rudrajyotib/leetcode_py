from unittest import TestCase

from medium.tree.btree_deepest_leaves_sum import TreeNode, Solution


class TestSolution(TestCase):
    def test_deepest_leaves_sum_set1(self):
        root = TreeNode(val=1,
                        left=TreeNode(val=2,
                                      left=TreeNode(val=10,
                                                    left=TreeNode(val=20),
                                                    right=TreeNode(val=30))),
                        right=TreeNode(val=3,
                                       left=TreeNode(val=5),
                                       right=TreeNode(val=10)))

        solution = Solution()
        self.assertEqual(50, solution.deepestLeavesSum(root=root))

    def test_deepest_leaves_sum_set2(self):
        root = TreeNode(val=1,
                        left=TreeNode(val=2,
                                      left=TreeNode(val=10,
                                                    left=TreeNode(val=20),
                                                    right=TreeNode(val=30))),
                        right=TreeNode(val=3,
                                       left=TreeNode(val=5),
                                       right=TreeNode(val=10,
                                                      left=TreeNode(val=20),
                                                      right=TreeNode(val=30))))

        solution = Solution()
        self.assertEqual(100, solution.deepestLeavesSum(root=root))

    def test_deepest_leaves_sum_set3(self):
        root = TreeNode(val=1,
                        left=TreeNode(val=2,
                                      left=TreeNode(val=10,
                                                    left=TreeNode(val=20))))

        solution = Solution()
        self.assertEqual(20, solution.deepestLeavesSum(root=root))

    def test_deepest_leaves_sum_set4(self):
        root = TreeNode(val=1)

        solution = Solution()
        self.assertEqual(1, solution.deepestLeavesSum(root=root))
