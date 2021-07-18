from unittest import TestCase

from medium.tree.btree_add_one_row import TreeNode, Solution


class TestSolution(TestCase):
    def test_should_add_one_row_before_last_row(self):
        level4_child1 = TreeNode(val=7)
        level4_child2 = TreeNode(val=8)

        level3_child1 = TreeNode(val=4)
        level3_child2 = TreeNode(val=5, left=level4_child1, right=level4_child2)

        level2_child1 = TreeNode(val=2)
        level2_child2 = TreeNode(val=3, left=level3_child1, right=level3_child2)

        root = TreeNode(val=1, left=level2_child1, right=level2_child2)

        solution = Solution()

        solution.addOneRow(root=root, val=6, depth=3)

        self.assertEqual(6, root.right.left.val, "new row did not add a left child")
        self.assertEqual(6, root.left.left.val, "new row did not add a left child")
        self.assertEqual(6, root.right.right.val, "new row did not add a right child")
        self.assertEqual(6, root.left.right.val, "new row did not add a right child")

        self.assertEqual(5, root.right.right.right.val, "old child not added to new node")
        self.assertEqual(4, root.right.left.left.val, "old child not added to new node")

        self.assertIsNone(root.right.left.right, "unwanted node added")
        self.assertIsNone(root.right.right.left, "unwanted node added")

    def test_should_add_one_row_after_root(self):
        level4_child1 = TreeNode(val=7)
        level4_child2 = TreeNode(val=8)

        level3_child1 = TreeNode(val=4)
        level3_child2 = TreeNode(val=5, left=level4_child1, right=level4_child2)

        level2_child1 = TreeNode(val=2)
        level2_child2 = TreeNode(val=3, left=level3_child1, right=level3_child2)

        root = TreeNode(val=1, left=level2_child1, right=level2_child2)

        solution = Solution()

        solution.addOneRow(root=root, val=6, depth=2)

        self.assertEqual(6, root.left.val, "new left node not added")
        self.assertEqual(6, root.right.val, "new left node not added")

        self.assertEqual(2, root.left.left.val, "original left child of root not added ")
        self.assertEqual(3, root.right.right.val, "original right child of root not added ")

        self.assertIsNone(root.left.right, "unwanted node added")
        self.assertIsNone(root.right.left, "unwanted node added")

    def test_should_add_one_row_at_bottom(self):
        level4_child1 = TreeNode(val=7)
        level4_child2 = TreeNode(val=8)

        level3_child1 = TreeNode(val=4)
        level3_child2 = TreeNode(val=5, left=level4_child1, right=level4_child2)

        level2_child1 = TreeNode(val=2)
        level2_child2 = TreeNode(val=3, left=level3_child1, right=level3_child2)

        root = TreeNode(val=1, left=level2_child1, right=level2_child2)

        solution = Solution()

        solution.addOneRow(root=root, val=6, depth=5)

        self.assertEqual(6, root.right.right.left.right.val, "new row did not add a right child")
        self.assertEqual(6, root.right.right.left.left.val, "new row did not add a left child")
        self.assertEqual(6, root.right.right.right.right.val, "new row did not add a right child")
        self.assertEqual(6, root.right.right.right.left.val, "new row did not add a left child")

        self.assertIsNone(root.right.right.left.right.left, "new bottom row added child.")
        self.assertIsNone(root.right.right.left.left.right, "new bottom row added child.")
        self.assertIsNone(root.right.right.right.right.left, "new bottom row added child.")
        self.assertIsNone(root.right.right.right.left.right, "new bottom row added child.")

    def test_should_add_one_row_on_top(self):
        level4_child1 = TreeNode(val=7)
        level4_child2 = TreeNode(val=8)

        level3_child1 = TreeNode(val=4)
        level3_child2 = TreeNode(val=5, left=level4_child1, right=level4_child2)

        level2_child1 = TreeNode(val=2)
        level2_child2 = TreeNode(val=3, left=level3_child1, right=level3_child2)

        root = TreeNode(val=1, left=level2_child1, right=level2_child2)

        solution = Solution()

        updated_root = solution.addOneRow(root=root, val=6, depth=1)

        self.assertEqual(6, updated_root.val, "new root not created")
        self.assertEqual(1, updated_root.left.val, "old root not added as left child")
        self.assertIsNone(updated_root.right, "new root has a faulty right child")
