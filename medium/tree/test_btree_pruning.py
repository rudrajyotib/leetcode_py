from unittest import TestCase

from medium.tree.btree_pruning import TreeNode, Solution


class TestSolution(TestCase):

    def test_should_prune_all_barring_root(self):
        level2_child1 = TreeNode(val=0)
        level2_child2 = TreeNode(val=0)
        level2_child3 = TreeNode(val=0)
        level2_child4 = TreeNode(val=0)

        level1_child1 = TreeNode(val=0, left=level2_child1, right=level2_child2)
        level1_child2 = TreeNode(val=0, left=level2_child3, right=level2_child4)

        root = TreeNode(val=1, left=level1_child1, right=level1_child2)

        solution = Solution()

        result: TreeNode = solution.pruneTree(root=root)

        self.assertIsNone(result.left, "Left sub-tree not pruned")
        self.assertIsNone(result.right, "Right sub-tree not pruned")

    def test_should_prune_all_including_root(self):
        level2_child1 = TreeNode(val=0)
        level2_child2 = TreeNode(val=0)
        level2_child3 = TreeNode(val=0)
        level2_child4 = TreeNode(val=0)

        level1_child1 = TreeNode(val=0, left=level2_child1, right=level2_child2)
        level1_child2 = TreeNode(val=0, left=level2_child3, right=level2_child4)

        root = TreeNode(val=0, left=level1_child1, right=level1_child2)

        solution = Solution()

        result: TreeNode = solution.pruneTree(root=root)

        self.assertIsNone(result, "Entire tree not pruned")

    def test_should_prune_right_sub_tree_and_all_leaf_nodes(self):
        level2_child1 = TreeNode(val=0)
        level2_child2 = TreeNode(val=0)
        level2_child3 = TreeNode(val=0)
        level2_child4 = TreeNode(val=0)

        level1_child1 = TreeNode(val=1, left=level2_child1, right=level2_child2)
        level1_child2 = TreeNode(val=0, left=level2_child3, right=level2_child4)

        root = TreeNode(val=1, left=level1_child1, right=level1_child2)

        solution = Solution()

        solution.pruneTree(root=root)

        self.assertEqual(1, root.val, "root altered")
        self.assertIsNone(root.right, "Right sub-tree not pruned")
        self.assertIsNotNone(root.left, "Left-sub-tree pruned")
        self.assertIsNone(root.left.left, "Left sub-tree leaf node not deleted")
        self.assertIsNone(root.left.right, "Left sub-tree leaf node not deleted")
