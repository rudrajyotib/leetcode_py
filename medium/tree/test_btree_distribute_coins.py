from unittest import TestCase

from medium.tree.btree_distribute_coins import TreeNode, Solution


class TestSolution(TestCase):
    def test_distribute_coins_set1(self):
        level3_child1 = TreeNode(val=0)
        level3_child2 = TreeNode(val=2)

        level2_child1 = TreeNode(val=0)
        level2_child2 = TreeNode(val=5, left= level3_child1, right=level3_child2)

        level1_child1 = TreeNode(val=0)
        level1_child2 = TreeNode(val=0, left=level2_child1, right=level2_child2)

        root = TreeNode(val=0, left=level1_child1, right=level1_child2)

        solution = Solution()

        self.assertEqual(10, solution.distributeCoins(root=root), "not all coins distribution counted")

    def test_distribute_coins_set2(self):
        level2_child1 = TreeNode(val=1)
        level2_child2 = TreeNode(val=1)
        level2_child3 = TreeNode(val=1)
        level2_child4 = TreeNode(val=1)

        level1_child1 = TreeNode(val=1, left=level2_child1, right=level2_child2)
        level1_child2 = TreeNode(val=1, left=level2_child3, right=level2_child4)

        root = TreeNode(val=1, left=level1_child1, right=level1_child2)

        solution = Solution()

        self.assertEqual(0, solution.distributeCoins(root=root), "no coins flip required")

    def test_distribute_coins_set3(self):
        root = TreeNode(val=1)
        solution = Solution()
        self.assertEqual(0, solution.distributeCoins(root=root), "no coins flip required")

    def test_distribute_coins_set4(self):
        level1_child1 = TreeNode(val=0)
        level1_child2 = TreeNode(val=0)
        root = TreeNode(val=3, left=level1_child1, right=level1_child2)
        solution = Solution()
        self.assertEqual(2, solution.distributeCoins(root=root), "min coins flip not reported")
