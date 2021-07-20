from unittest import TestCase

from medium.tree.btree_trim_bst import TreeNode, Solution


class TestSolution(TestCase):
    def test_trim_bst(self):

        level5_child1 = TreeNode(val=33)
        level5_child2 = TreeNode(val=42)

        level4_child1 = TreeNode(val=26)
        level4_child2 = TreeNode(val=35, left=level5_child1, right=level5_child2)
        level4_child3 = TreeNode(val=60)
        level4_child4 = TreeNode(val=80)

        level3_child1 = TreeNode(val=30, left=level4_child1, right=level4_child2)
        level3_child2 = TreeNode(val=70, left=level4_child3, right=level4_child4)

        level2_child1 = TreeNode(val=50, left=level3_child1, right=level3_child2)

        level1_child1 = TreeNode(val=10, right=level2_child1)

        root = TreeNode(val=100, left=level1_child1)

        solution = Solution()

        result: TreeNode = solution.trimBST(root=root, low=9, high=51)

        self.assertIsNotNone(result, "None root returned")
        self.assertEqual(10, result.val, "Old root not discarded")
        self.assertIsNone(result.right.right, "Greater value right child not discarded")
        self.assertEqual(33, result.right.left.right.left.val, "structure not retained")
        self.assertIsNone(result.left, "structure not retained")
