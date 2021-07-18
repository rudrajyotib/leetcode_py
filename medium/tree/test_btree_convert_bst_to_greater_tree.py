from unittest import TestCase

from medium.tree.btree_convert_bst_to_greater_tree import TreeNode, Solution


class TestSolution(TestCase):
    def test_should_sum_up_greater_value_elements(self):
        level1_child1 = TreeNode(val=1)
        level1_child2 = TreeNode(val=3)

        root = TreeNode(val=2, left=level1_child1, right=level1_child2)

        solution = Solution()

        updated_root = solution.convertBST(root=root)

        self.assertEqual(5, updated_root.val, "Root value not updated")
        self.assertEqual(6, updated_root.left.val, "Left most child not updated")
        self.assertEqual(3, updated_root.right.val, "Right most child should not have been updated")

    def test_should_handle_single_node_tree(self):
        solution = Solution()
        updated_root = solution.convertBST(TreeNode(val=1))
        self.assertIsNotNone(updated_root, "Tree omitted")
        self.assertEqual(1, updated_root.val, "Root value tampered")

    def test_should_handle_empty_node(self):
        solution = Solution()
        # noinspection PyTypeChecker
        self.assertIsNone(solution.convertBST(root=None), "Empty tree not handled")
