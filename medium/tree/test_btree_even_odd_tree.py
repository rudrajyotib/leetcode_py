from unittest import TestCase

from medium.tree.btree_even_odd_tree import TreeNode, Solution


class TestSolution(TestCase):
    def test_is_even_odd_tree_set1(self):
        tree = TreeNode(val=1,
                        left=TreeNode(val=4,
                                      left=TreeNode(val=3),
                                      right=TreeNode(val=5)),
                        right=TreeNode(val=2,
                                       left=TreeNode(val=7),
                                       right=TreeNode(val=9)))

        solution = Solution()
        self.assertTrue(solution.isEvenOddTree(root=tree))

    def test_is_even_odd_tree_set2(self):
        tree = TreeNode(val=1,
                        left=TreeNode(val=4,
                                      left=TreeNode(val=3,
                                                    left=TreeNode(val=4,
                                                                  left=TreeNode(val=1),
                                                                  right=TreeNode(val=3))),
                                      right=TreeNode(val=5)),
                        right=TreeNode(val=2,
                                       left=TreeNode(val=7),
                                       right=TreeNode(val=9)))

        solution = Solution()
        self.assertTrue(solution.isEvenOddTree(root=tree))

    def test_is_even_odd_tree_set3(self):
        tree = TreeNode(val=1,
                        left=TreeNode(val=4,
                                      left=TreeNode(val=3,
                                                    left=TreeNode(val=4,
                                                                  left=TreeNode(val=1),
                                                                  right=TreeNode(val=3))),
                                      right=TreeNode(val=5)),
                        right=TreeNode(val=2,
                                       left=TreeNode(val=7),
                                       right=TreeNode(val=90)))

        solution = Solution()
        self.assertFalse(solution.isEvenOddTree(root=tree))

    def test_is_even_odd_tree_set4(self):
        tree = TreeNode(val=5,
                        left=TreeNode(val=4,
                                      left=TreeNode(val=3),
                                      right=TreeNode(val=3)),
                        right=TreeNode(val=2,
                                       left=TreeNode(val=7)))

        solution = Solution()
        self.assertFalse(solution.isEvenOddTree(root=tree))

    def test_is_even_odd_tree_set5(self):
        tree = TreeNode(val=10,
                        left=TreeNode(val=4,
                                      left=TreeNode(val=3,
                                                    left=TreeNode(val=4,
                                                                  left=TreeNode(val=1),
                                                                  right=TreeNode(val=3))),
                                      right=TreeNode(val=5)),
                        right=TreeNode(val=2,
                                       left=TreeNode(val=7),
                                       right=TreeNode(val=9)))

        solution = Solution()
        self.assertFalse(solution.isEvenOddTree(root=tree))
