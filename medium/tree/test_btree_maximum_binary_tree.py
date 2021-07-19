from unittest import TestCase

from medium.tree.btree_maximum_binary_tree import TreeNode, Solution


class TestSolution(TestCase):
    def test_should_create_binary_tree_set1(self):
        result: TreeNode
        solution = Solution()
        result = solution.constructMaximumBinaryTree([3, 2, 1, 6, 0, 5])
        self.assertIsNotNone(result, "Root node was not formed")
        self.assertEqual(6, result.val, "Root node not formed with right value")
        self.assertEqual(1, result.left.right.right.val, "Node not correctly formed")
        self.assertEqual(2, result.left.right.val, "Node not correctly formed")
        self.assertEqual(3, result.left.val, "Node not correctly formed")
        self.assertEqual(5, result.right.val, "Node not correctly formed")
        self.assertEqual(0, result.right.left.val, "Node not correctly formed")
        self.assertIsNone(result.right.right, "un-wanted node added")

    def test_should_create_single_node_tree(self):
        solution = Solution()
        result: TreeNode = solution.constructMaximumBinaryTree(nums=[10])
        self.assertEqual(10, result.val, "Root node not formed")
        self.assertIsNone(result.left, "should be a leaf node")
        self.assertIsNone(result.right, "should be a leaf node")

    def test_should_handle_empty_and_null_array(self):
        solution = Solution()
        self.assertIsNone(solution.constructMaximumBinaryTree([]), "Empty array not handled")
        # noinspection PyTypeChecker
        self.assertIsNone(solution.constructMaximumBinaryTree(nums=None), "None array not handled")
