from unittest import TestCase

from medium.tree.btree_construct_from_inorder_preorder import Solution


class TestSolution(TestCase):
    def test_should_build_tree(self):
        solution = Solution()
        node = solution.buildTree(preorder=[1, 2, 4, 5, 3, 6],
                                  inorder=[4, 2, 5, 1, 6, 3])

        self.assertEqual(2, node.left.val)
        self.assertEqual(3, node.right.val)

    def test_should_build_partial_tree(self):
        solution = Solution()
        node = solution.buildTree(preorder=[1, 2, 3, 4, 10, 11, 5, 6, 7, 8, 9],
                                  inorder=[3, 2, 11, 10, 4, 1, 6, 5, 8, 9, 7])

        self.assertEqual(2, node.left.val)
        self.assertEqual(5, node.right.val)
        self.assertEqual(1, node.val)
        self.assertEqual(3, node.left.left.val)
        self.assertEqual(11, node.left.right.left.left.val)
        self.assertEqual(9, node.right.right.left.right.val)

    def test_should_build_single_node_tree(self):
        solution = Solution()
        node = solution.buildTree(preorder=[1],
                                  inorder=[3])

        self.assertEqual(1, node.val)
        self.assertIsNone(node.left)
        self.assertIsNone(node.right)
