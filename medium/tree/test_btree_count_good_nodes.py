from unittest import TestCase

from medium.tree.btree_count_good_nodes import TreeNode, Solution


class TestSolution(TestCase):
    def test_should_count_good_nodes_set1(self):
        tree = TreeNode(val=1,
                        left=TreeNode(val=2,
                                      left=TreeNode(val=3),
                                      right=TreeNode(val=3)),
                        right=TreeNode(val=2,
                                       left=TreeNode(val=3),
                                       right=TreeNode(val=3)))
        solution = Solution()
        self.assertEqual(7, solution.goodNodes(root=tree))

    def test_should_count_good_nodes_set2(self):
        tree = TreeNode(val=3,
                        left=TreeNode(val=2,
                                      left=TreeNode(val=1),
                                      right=TreeNode(val=1)),
                        right=TreeNode(val=2,
                                       left=TreeNode(val=1),
                                       right=TreeNode(val=1)))
        solution = Solution()
        self.assertEqual(1, solution.goodNodes(root=tree))

    def test_should_count_good_nodes_set3(self):
        tree = TreeNode(val=3,
                        left=TreeNode(val=2,
                                      left=TreeNode(val=1),
                                      right=TreeNode(val=1)),
                        right=TreeNode(val=4,
                                       left=TreeNode(val=4),
                                       right=TreeNode(val=1)))
        solution = Solution()
        self.assertEqual(3, solution.goodNodes(root=tree))

    def test_should_count_good_nodes_set4(self):
        solution = Solution()
        self.assertEqual(1, solution.goodNodes(root=TreeNode(val=0)))

    def test_should_count_good_nodes_set5(self):
        solution = Solution()
        # noinspection PyTypeChecker
        self.assertEqual(0, solution.goodNodes(root=None))
