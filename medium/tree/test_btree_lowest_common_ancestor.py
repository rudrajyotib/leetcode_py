from unittest import TestCase

from medium.tree.btree_lowest_common_ancestor import TreeNode, Solution


class TestSolution(TestCase):
    def test_should_find_root_as_lowest_common_ancestor(self):
        level3_child1 = TreeNode(6)
        level3_child2 = TreeNode(7)

        level2_child1 = TreeNode(3)
        level2_child2 = TreeNode(4)
        level2_child2.left = level3_child1
        level2_child2.right = level3_child2
        level2_child3 = TreeNode(10)

        level1_child1 = TreeNode(2)
        level1_child2 = TreeNode(8)

        level1_child1.left = level2_child1
        level1_child1.right = level2_child2
        level1_child2.right = level2_child3

        root = TreeNode(5)
        root.left = level1_child1
        root.right = level1_child2

        solution = Solution()

        self.assertEqual(5, solution.lowestCommonAncestor(root, p=level2_child3, q=level1_child1).val,
                         "lowest element not found")

    def test_should_find_root_of_sub_tree_as_lowest_common_ancestor(self):
        level3_child1 = TreeNode(7)
        level3_child2 = TreeNode(4)

        level2_child1 = TreeNode(6)
        level2_child2 = TreeNode(2)
        level2_child3 = TreeNode(0)
        level2_child4 = TreeNode(8)

        level2_child2.left = level3_child1
        level2_child2.right = level3_child2

        level1_child1 = TreeNode(5)
        level1_child2 = TreeNode(20)

        level1_child1.left = level2_child1
        level1_child1.right = level2_child2

        level1_child2.left = level2_child3
        level1_child2.right = level2_child4

        root = TreeNode(3)
        root.left = level1_child1
        root.right = level1_child2

        solution = Solution()

        self.assertEqual(5, solution.lowestCommonAncestor(root, p=level2_child1, q=level3_child1).val,
                         "node at lowest level not found")
