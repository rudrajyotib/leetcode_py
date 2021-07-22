from unittest import TestCase

from medium.tree.btree_construct_bst_from_pre_order_traversal import TreeNode, Solution


class TestSolution(TestCase):
    def test_bst_from_preorder_set1(self):
        solution = Solution()
        result: TreeNode = solution.bstFromPreorder([10, 5, 4, 7, 6, 17])
        self.assertIsNotNone(result, "tree not created")
        self.assertEqual(10, result.val)
        self.assertEqual(4, result.left.left.val, "Left sub-tree is incorrect")
        self.assertEqual(6, result.left.right.left.val, "Left sub-tree is incorrect")
        self.assertEqual(17, result.right.val, "Right sub-tree is incorrect")

    def test_bst_from_preorder_set2(self):
        solution = Solution()
        result: TreeNode = solution.bstFromPreorder([10, 5, 4, 3])
        self.assertIsNotNone(result, "tree not created")
        self.assertEqual(10, result.val)
        self.assertEqual(4, result.left.left.val, "Left sub-tree is incorrect")
        self.assertEqual(3, result.left.left.left.val, "Left sub-tree is incorrect")
        self.assertIsNone(result.right, "right sub-tree should not have been created")

    def test_bst_from_preorder_set3(self):
        solution = Solution()
        result: TreeNode = solution.bstFromPreorder([10])
        self.assertIsNotNone(result, "tree not created")
        self.assertEqual(10, result.val)
        self.assertIsNone(result.right, "right sub-tree should not have been created")
        self.assertIsNone(result.left, "left sub-tree should not have been created")
