from unittest import TestCase

from medium.tree.btree_delete_leaf_nodes_with_given_value import TreeNode, Solution


class TestSolution(TestCase):
    def test_remove_leaf_nodes_set1(self):
        root = TreeNode(val=1,
                        left=TreeNode(val=5,
                                      left=TreeNode(val=5),
                                      right=TreeNode(val=5)),
                        right=TreeNode(val=3,
                                       left=TreeNode(val=4),
                                       right=TreeNode(val=5)))
        solution = Solution()
        result = solution.removeLeafNodes(root=root, target=5)
        self.assertIsNotNone(result, "Root deleted")
        self.assertIsNone(result.left, "Left sub-tree not deleted")
        self.assertIsNone(result.right.right, "Target leaf node not deleted")
        self.assertEqual(4, result.right.left.val, "non-target leaf altered")

    def test_remove_leaf_nodes_set2(self):
        root = TreeNode(val=1,
                        left=TreeNode(val=5,
                                      left=TreeNode(val=5),
                                      right=TreeNode(val=5)),
                        right=TreeNode(val=5,
                                       left=TreeNode(val=5),
                                       right=TreeNode(val=5)))
        solution = Solution()
        result = solution.removeLeafNodes(root=root, target=5)
        self.assertIsNotNone(result, "Root deleted")
        self.assertIsNone(result.left, "Left sub-tree not deleted")
        self.assertIsNone(result.right, "Right sub-tree not deleted")

    def test_remove_leaf_nodes_set3(self):
        root = TreeNode(val=2,
                        left=TreeNode(val=5,
                                      left=TreeNode(val=2),
                                      right=TreeNode(val=7)),
                        right=TreeNode(val=2))
        solution = Solution()
        result = solution.removeLeafNodes(root=root, target=2)
        self.assertIsNotNone(result, "Root deleted")
        self.assertIsNone(result.right, "Right sub-tree not deleted")
        self.assertIsNone(result.left.left, "Left sub-tree not deleted")
        self.assertEqual(7, result.left.right.val, "non-target leaf node deleted")

    def test_remove_leaf_nodes_set4(self):
        root = TreeNode(val=2,
                        left=TreeNode(val=5,
                                      right=TreeNode(val=7,
                                                     left=TreeNode(val=2))))
        solution = Solution()
        result = solution.removeLeafNodes(root=root, target=2)
        self.assertIsNotNone(result, "Root deleted")
        self.assertIsNone(result.left.right.left, "Left sub-tree not deleted")
        self.assertEqual(7, result.left.right.val, "non-target leaf node deleted")

    def test_remove_leaf_nodes_set5(self):
        root = TreeNode(val=5,
                        left=TreeNode(val=5,
                                      left=TreeNode(val=5),
                                      right=TreeNode(val=5)),
                        right=TreeNode(val=5,
                                       left=TreeNode(val=5),
                                       right=TreeNode(val=5)))
        solution = Solution()
        result = solution.removeLeafNodes(root=root, target=5)
        self.assertIsNone(result, "target root not deleted")
