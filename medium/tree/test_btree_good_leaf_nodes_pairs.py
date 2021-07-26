from unittest import TestCase

from medium.tree.btree_good_leaf_nodes_pairs import TreeNode, Solution


class TestSolution(TestCase):
    def test_count_pairs_set1(self):
        tree = TreeNode(val=1,
                        left=TreeNode(val=1,
                                      left=TreeNode(val=1),
                                      right=TreeNode(val=1)),
                        right=TreeNode(val=1,
                                       left=TreeNode(val=1),
                                       right=TreeNode(val=1)))

        solution = Solution()
        self.assertEqual(6, solution.countPairs(root=tree, distance=4))

    def test_count_pairs_set2(self):
        tree = TreeNode(val=1,
                        left=TreeNode(val=1,
                                      left=TreeNode(val=1),
                                      right=TreeNode(val=1)),
                        right=TreeNode(val=1,
                                       left=TreeNode(val=1),
                                       right=TreeNode(val=1)))

        solution = Solution()
        self.assertEqual(2, solution.countPairs(root=tree, distance=3))

    def test_count_pairs_set3(self):
        tree = TreeNode(val=1,
                        left=TreeNode(val=1,
                                      left=TreeNode(val=1),
                                      right=TreeNode(val=1)),
                        right=TreeNode(val=1,
                                       left=TreeNode(val=1),
                                       right=TreeNode(val=1)))

        solution = Solution()
        self.assertEqual(0, solution.countPairs(root=tree, distance=1))

    def test_count_pairs_set4(self):
        tree = TreeNode(val=1,
                        left=TreeNode(val=1,
                                      left=TreeNode(val=1),
                                      right=TreeNode(val=1)),
                        right=TreeNode(val=1,
                                       left=TreeNode(val=1),
                                       right=TreeNode(val=1,
                                                      left=TreeNode(val=1),
                                                      right=TreeNode(val=1,
                                                                     left=TreeNode(val=1),
                                                                     right=TreeNode(val=1)))))

        solution = Solution()
        self.assertEqual(9, solution.countPairs(root=tree, distance=4))

    def test_count_pairs_set5(self):
        tree = TreeNode(val=1,
                        left=TreeNode(val=1,
                                      left=TreeNode(val=1)),
                        right=TreeNode(val=1,
                                       right=TreeNode(val=1)))
        solution = Solution()
        self.assertEqual(1, solution.countPairs(root=tree, distance=4))
