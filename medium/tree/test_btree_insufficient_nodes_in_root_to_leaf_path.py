from unittest import TestCase

from medium.tree.btree_insufficient_nodes_in_root_to_leaf_path import TreeNode, Solution


class TestSolution(TestCase):
    def test_sufficient_subset_set1(self):
        root = TreeNode(val=10,
                        left=TreeNode(val=-5,
                                      left=TreeNode(val=1),
                                      right=TreeNode(val=0)),
                        right=TreeNode(val=-2,
                                       left=TreeNode(val=0),
                                       right=TreeNode(val=0)))

        solution = Solution()
        result = solution.sufficientSubset(root=root, limit=10)
        self.assertIsNone(result, "Root should be deleted")

    def test_sufficient_subset_set2(self):
        root = TreeNode(val=10,
                        left=TreeNode(val=-5,
                                      left=TreeNode(val=1),
                                      right=TreeNode(val=0)),
                        right=TreeNode(val=-2,
                                       left=TreeNode(val=0),
                                       right=TreeNode(val=0)))

        solution = Solution()
        result = solution.sufficientSubset(root=root, limit=-10)
        self.assertIsNotNone(result, "Root deleted")
        self.assertIsNotNone(result.left, " left subtree deleted")
        self.assertIsNotNone(result.left.right, " left subtree deleted")
        self.assertIsNotNone(result.left.left, " left subtree deleted")
        self.assertIsNotNone(result.right, "right subtree deleted")
        self.assertIsNotNone(result.right.left, "right subtree deleted")
        self.assertIsNotNone(result.right.right, "right subtree deleted")

    def test_sufficient_subset_set3(self):
        root = TreeNode(val=10,
                        left=TreeNode(val=-5,
                                      left=TreeNode(val=1),
                                      right=TreeNode(val=0,
                                                     left=TreeNode(val=-1),
                                                     right=TreeNode(val=-1))),
                        right=TreeNode(val=-2,
                                       left=TreeNode(val=0),
                                       right=TreeNode(val=0)))

        solution = Solution()
        result = solution.sufficientSubset(root=root, limit=6)
        self.assertIsNotNone(result, "Root deleted")
        self.assertIsNotNone(result.left, " left subtree deleted")
        self.assertIsNotNone(result.left.left, " left subtree deleted")
        self.assertIsNone(result.left.right, "insufficient left subtree not deleted")
        self.assertIsNotNone(result.right.left, "right subtree deleted")
        self.assertIsNotNone(result.right.right, "right subtree deleted")

    def test_sufficient_subset_set4(self):
        root = TreeNode(val=10,
                        left=TreeNode(val=-5,
                                      left=TreeNode(val=1),
                                      right=TreeNode(val=0,
                                                     left=TreeNode(val=-1),
                                                     right=TreeNode(val=-1))),
                        right=TreeNode(val=-2,
                                       left=TreeNode(val=0),
                                       right=TreeNode(val=-12)))

        solution = Solution()
        result = solution.sufficientSubset(root=root, limit=6)
        self.assertIsNotNone(result, "Root deleted")
        self.assertIsNotNone(result.left, " left subtree deleted")
        self.assertIsNotNone(result.left.left, " left subtree deleted")
        self.assertIsNone(result.left.right, "insufficient left subtree not deleted")
        self.assertIsNotNone(result.right.left, "right subtree deleted")
        self.assertIsNone(result.right.right, "insufficient right subtree not deleted")
