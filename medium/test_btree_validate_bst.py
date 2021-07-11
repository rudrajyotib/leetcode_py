from unittest import TestCase

from medium.btree_validate_bst import TreeNode, Solution


class TestSolution(TestCase):
    def test_should_validate_bst(self):
        level2_child1 = TreeNode(val=1)
        level2_child2 = TreeNode(val=3)
        level2_child3 = TreeNode(val=5)
        level2_child4 = TreeNode(val=7)

        level1_child1 = TreeNode(val=2, left=level2_child1, right=level2_child2)
        level1_child2 = TreeNode(val=6, left=level2_child3, right=level2_child4)

        root = TreeNode(val=4, left=level1_child1, right=level1_child2)

        solution = Solution()

        self.assertTrue(solution.isValidBST(root), "Valid BST could not be validated")

    def test_should_report_invalidate_bst(self):
        level2_child1 = TreeNode(val=1)
        level2_child2 = TreeNode(val=3)
        level2_child3 = TreeNode(val=8)
        level2_child4 = TreeNode(val=7)

        level1_child1 = TreeNode(val=2, left=level2_child1, right=level2_child2)
        level1_child2 = TreeNode(val=6, left=level2_child3, right=level2_child4)

        root = TreeNode(val=4, left=level1_child1, right=level1_child2)

        solution = Solution()

        self.assertFalse(solution.isValidBST(root), "Invalid BST validated")

    def test_should_report_invalidate_bst_swapped_from_left_right_subtree(self):
        level2_child1 = TreeNode(val=1)
        level2_child2 = TreeNode(val=9)
        level2_child3 = TreeNode(val=8)
        level2_child4 = TreeNode(val=7)

        level1_child1 = TreeNode(val=2, left=level2_child1, right=level2_child2)
        level1_child2 = TreeNode(val=6, left=level2_child3, right=level2_child4)

        root = TreeNode(val=4, left=level1_child1, right=level1_child2)

        solution = Solution()

        self.assertFalse(solution.isValidBST(root), "Invalid BST validated")

    def test_should_report_invalidate_when_same_value_is_added(self):
        level1_child1 = TreeNode(val=1)
        level1_child2 = TreeNode(val=1)
        root = TreeNode(val=1, left=level1_child1, right=level1_child2)
        solution = Solution()
        self.assertFalse(solution.isValidBST(root), "same value children is validated")

    def test_should_invalidate_same_value_in_chain_bst(self):
        level2_child1 = TreeNode(val=1)
        level1_child1 = TreeNode(val=1, left=level2_child1)
        root = TreeNode(val=1, left=level1_child1)

        solution = Solution()
        self.assertFalse(solution.isValidBST(root), "same value chain validated")

    def test_should_report_none_root(self):
        solution = Solution()
        # noinspection PyTypeChecker
        self.assertFalse(solution.isValidBST(root=None), "Invalid BST validated")
