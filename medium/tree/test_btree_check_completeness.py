from unittest import TestCase

from medium.tree.btree_check_completeness import TreeNode, Solution


class TestSolution(TestCase):
    def test_should_identify_root_only_tree_valid(self):
        root = TreeNode(val=1)
        solution = Solution()
        self.assertTrue(solution.isCompleteTree(root=root), "single node tree not marked valid")

    def test_should_identify_single_left_child_tree_valid(self):
        level1_child1 = TreeNode(val=2)
        root = TreeNode(val=1, left=level1_child1)
        solution = Solution()
        self.assertTrue(solution.isCompleteTree(root=root), "single left child tree not marked valid")

    def test_should_identify_single_right_child_tree_invalid(self):
        level1_child1 = TreeNode(val=2)
        root = TreeNode(val=1, right=level1_child1)
        solution = Solution()
        self.assertFalse(solution.isCompleteTree(root=root), "single left child tree not marked valid")

    def test_should_identify_invalid_incomplete_node_set1(self):
        level2_child1 = TreeNode(val=4)
        level2_child2 = TreeNode(val=5)
        level2_child3 = TreeNode(val=7)

        level1_child1 = TreeNode(val=2, left=level2_child1, right=level2_child2)
        level1_child2 = TreeNode(val=3, right=level2_child3)

        root = TreeNode(val=1, left=level1_child1, right=level1_child2)

        solution = Solution()
        self.assertFalse(solution.isCompleteTree(root=root), "invalid incomplete child not identified")

    def test_should_identify_invalid_incomplete_node_set2(self):
        level3_child1 = TreeNode(val=7)
        level3_child2 = TreeNode(val=8)

        level2_child1 = TreeNode(val=4, left=level3_child1, right=level3_child2)
        level2_child2 = TreeNode(val=5)
        level2_child3 = TreeNode(val=6)

        level1_child1 = TreeNode(val=2, left=level2_child1, right=level2_child2)
        level1_child2 = TreeNode(val=3, left=level2_child3)

        root = TreeNode(val=1, left=level1_child1, right=level1_child2)

        solution = Solution()

        self.assertFalse(solution.isCompleteTree(root=root), "invalid incomplete child not identified")
