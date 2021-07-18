from unittest import TestCase

from medium.tree.btree_convert_sorted_list_to_balanced_bst import ListNode, Solution


class TestSolution(TestCase):
    def test_should_height_balance_odd_number_elements(self):
        node5 = ListNode(val=5)
        node4 = ListNode(val=4, next=node5)
        node3 = ListNode(val=3, next=node4)
        node2 = ListNode(val=2, next=node3)
        node1 = ListNode(val=1, next=node2)

        solution = Solution()
        tree_node = solution.sortedListToBST(node1)

        self.assertEqual(3, tree_node.val, "root node does not match")
        self.assertEqual(1, tree_node.left.val, "first left does not match")
        self.assertEqual(2, tree_node.left.right.val, "left->right does not match")
        self.assertEqual(4, tree_node.right.val, "first right does not match")
        self.assertEqual(5, tree_node.right.right.val, "right->right does not match")

    def test_should_create_single_node_tree(self):
        node1 = ListNode(val=1)
        solution = Solution()
        tree_node = solution.sortedListToBST(node1)
        self.assertIsNotNone(tree_node, "could not generate tree")
        self.assertEqual(1, tree_node.val, "could not transfer value from list to tree")
        self.assertIsNone(tree_node.left, "falsely generated left node of single node tree")
        self.assertIsNone(tree_node.right, "falsely generated right node of single node tree")
