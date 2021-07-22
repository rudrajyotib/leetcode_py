from unittest import TestCase

from medium.tree.btree_maximum_binary_tree_2 import TreeNode, Solution


class TestSolution(TestCase):
    def test_insert_into_max_tree_set1(self):
        level2_child1 = TreeNode(val=4)
        level1_child1 = TreeNode(val=5, left=level2_child1)
        root = TreeNode(val=6, left=level1_child1)
        solution = Solution()
        result = solution.insertIntoMaxTree(root=root, val=7)
        self.assertEqual(7, result.val, "new root not created")
        self.assertEqual(6, result.left.val)

    def test_insert_into_max_tree_set2(self):
        level3_child1 = TreeNode(val=10)

        level2_child1 = TreeNode(val=20, left=level3_child1)
        level2_child2 = TreeNode(val=35)
        level2_child3 = TreeNode(val=27)

        level1_child1 = TreeNode(val=30, left=level2_child1)
        level1_child2 = TreeNode(val=40, left=level2_child2, right=level2_child3)

        root = TreeNode(val=50, left=level1_child1, right=level1_child2)

        solution = Solution()
        result = solution.insertIntoMaxTree(root=root, val=22)
        self.assertEqual(22, result.right.right.right.val, "new root not created")
        self.assertEqual(27, result.right.right.val, "new root not created")

    def test_insert_into_max_tree_set3(self):
        level3_child1 = TreeNode(val=10)

        level2_child1 = TreeNode(val=20, left=level3_child1)
        level2_child2 = TreeNode(val=35)
        level2_child3 = TreeNode(val=27)

        level1_child1 = TreeNode(val=30, left=level2_child1)
        level1_child2 = TreeNode(val=40, left=level2_child2, right=level2_child3)

        root = TreeNode(val=50, left=level1_child1, right=level1_child2)

        solution = Solution()
        result = solution.insertIntoMaxTree(root=root, val=29)
        self.assertEqual(29, result.right.right.val, "new node not created")
        self.assertEqual(27, result.right.right.left.val, "node not shifted")

    def test_insert_into_max_tree_set4(self):
        level3_child1 = TreeNode(val=10)

        level2_child1 = TreeNode(val=20, left=level3_child1)
        level2_child2 = TreeNode(val=35)
        level2_child3 = TreeNode(val=27)

        level1_child1 = TreeNode(val=30, left=level2_child1)
        level1_child2 = TreeNode(val=40, left=level2_child2, right=level2_child3)

        root = TreeNode(val=50, left=level1_child1, right=level1_child2)

        solution = Solution()
        result = solution.insertIntoMaxTree(root=root, val=42)
        self.assertEqual(42, result.right.val, "new node not created")
        self.assertIsNone(result.right.right, "Right most node got right child")
        self.assertEqual(40, result.right.left.val, "node not shifted")
