from unittest import TestCase

from medium.tree.btree_max_level_sum import TreeNode, Solution


class TestSolution(TestCase):
    def test_max_level_sum_set1(self):
        root = TreeNode(val=1,
                        left=TreeNode(val=-1,
                                      left=TreeNode(val=-3),
                                      right=TreeNode(val=-4,
                                                     left=TreeNode(val=20),
                                                     right=TreeNode(val=30))),
                        right=TreeNode(val=-2,
                                       left=TreeNode(val=-5,
                                                     left=TreeNode(val=20),
                                                     right=TreeNode(val=30)),
                                       right=TreeNode(val=-10)))
        solution = Solution()
        self.assertEqual(4, solution.maxLevelSum(root=root), "max level not identified")

    def test_max_level_sum_set2(self):
        root = TreeNode(val=1,
                        left=TreeNode(val=20,
                                      left=TreeNode(val=-3),
                                      right=TreeNode(val=-4,
                                                     left=TreeNode(val=20),
                                                     right=TreeNode(val=30))),
                        right=TreeNode(val=2000,
                                       left=TreeNode(val=-5,
                                                     left=TreeNode(val=20),
                                                     right=TreeNode(val=30)),
                                       right=TreeNode(val=-10)))
        solution = Solution()
        self.assertEqual(2, solution.maxLevelSum(root=root), "max level not identified")

    def test_max_level_sum_set3(self):
        root = TreeNode(val=1,
                        left=TreeNode(val=20,
                                      left=TreeNode(val=500),
                                      right=TreeNode(val=-500,
                                                     left=TreeNode(val=20),
                                                     right=TreeNode(val=30))),
                        right=TreeNode(val=2000,
                                       left=TreeNode(val=500,
                                                     left=TreeNode(val=20),
                                                     right=TreeNode(val=30)),
                                       right=TreeNode(val=520)))
        solution = Solution()
        self.assertEqual(2, solution.maxLevelSum(root=root), "max level not identified")

    def test_max_level_sum_set4(self):
        root = TreeNode(val=1,
                        left=TreeNode(val=20),
                        right=TreeNode(val=2000))
        solution = Solution()
        self.assertEqual(2, solution.maxLevelSum(root=root), "max level not identified")

    def test_max_level_sum_set5(self):
        root = TreeNode(val=1, )
        solution = Solution()
        self.assertEqual(1, solution.maxLevelSum(root=root), "max level not identified")
