from unittest import TestCase

from medium.tree.btree_maximum_width import TreeNode, Solution


class TestSolution(TestCase):
    def test_should_find_max_width_set1(self):

        level1_child1 = TreeNode(val=1)
        level1_child2 = TreeNode(val=2)
        root = TreeNode(val=3, left=level1_child1, right=level1_child2)

        solution = Solution()

        result = solution.widthOfBinaryTree(root=root)

        self.assertEqual(2, result, "max width not recorded")

    def test_should_find_max_width_set2(self):

        level2_child1 = TreeNode(val=1)
        level2_child2 = TreeNode(val=1)

        level1_child1 = TreeNode(val=1, left=level2_child1)
        level1_child2 = TreeNode(val=2, right=level2_child2)

        root = TreeNode(val=4, left=level1_child1, right=level1_child2)

        solution = Solution()

        result = solution.widthOfBinaryTree(root=root)

        self.assertEqual(4, result, "max width not recorded")

    def test_should_handle_single_node_tree(self):

        root = TreeNode(val=3)

        solution = Solution()

        result = solution.widthOfBinaryTree(root=root)

        self.assertEqual(1, result, "max width not recorded")
