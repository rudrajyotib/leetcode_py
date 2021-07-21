from unittest import TestCase

from medium.tree.btree_construct_from_preorder_postorder import Solution, TreeNode


class TestSolution(TestCase):
    def test_construct_from_pre_post_set1(self):
        pre_order = [1, 2, 4, 5, 3, 6, 7]
        post_order = [4, 5, 2, 6, 7, 3, 1]
        solution = Solution()
        root_node: TreeNode = solution.constructFromPrePost(pre=pre_order, post=post_order)
        self.assertIsNotNone(root_node, "root node not created")

        self.assertEqual(1, root_node.val, "correct root node not created")

        self.assertEqual(2, root_node.left.val, "correct root node not created")
        self.assertEqual(4, root_node.left.left.val, "node position not correct")
        self.assertEqual(5, root_node.left.right.val, "node position not correct")

        self.assertEqual(3, root_node.right.val, "correct root node not created")
        self.assertEqual(6, root_node.right.left.val, "node position not correct")
        self.assertEqual(7, root_node.right.right.val, "node position not correct")

        self.assertIsNone(root_node.left.left.left, "unwarranted node created as child")
        self.assertIsNone(root_node.left.left.right, "unwarranted node created as child")

        self.assertIsNone(root_node.left.right.left, "unwarranted node created as child")
        self.assertIsNone(root_node.left.right.right, "unwarranted node created as child")
