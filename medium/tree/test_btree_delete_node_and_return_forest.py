from unittest import TestCase

from medium.tree.btree_delete_node_and_return_forest import TreeNode, Solution


class TestTreeNode(TestCase):

    def test_should_delete_leaf_most_node(self):
        level2_child1 = TreeNode(val=4)
        level2_child2 = TreeNode(val=5)
        level2_child3 = TreeNode(val=6)

        level1_child1 = TreeNode(val=2, left=level2_child1, right=level2_child2)
        level1_child2 = TreeNode(val=3, right=level2_child3)

        root = TreeNode(val=1, left=level1_child1, right=level1_child2)

        solution = Solution()

        result = solution.delNodes(root, [5])

        self.assertEqual(1, len(result), "Parent tree not included in Forest")
        self.assertEqual(1, result[0].val, "Parent root not preserved")
        self.assertIsNone(result[0].left.right, "Leaf node not chopped off")

    def test_should_delete_nodes_at_height_1_above_base(self):
        level3_child1 = TreeNode(val=8)
        level3_child2 = TreeNode(val=9)
        level3_child3 = TreeNode(val=10)
        level3_child4 = TreeNode(val=11)
        level3_child5 = TreeNode(val=12)
        level3_child6 = TreeNode(val=13)
        level3_child7 = TreeNode(val=14)
        level3_child8 = TreeNode(val=15)

        level2_child1 = TreeNode(val=4, left=level3_child1, right=level3_child2)
        level2_child2 = TreeNode(val=5, left=level3_child3, right=level3_child4)
        level2_child3 = TreeNode(val=6, left=level3_child5, right=level3_child6)
        level2_child4 = TreeNode(val=6, left=level3_child7, right=level3_child8)

        level1_child1 = TreeNode(val=2, left=level2_child1, right=level2_child2)
        level1_child2 = TreeNode(val=3, left=level2_child3, right=level2_child4)

        root = TreeNode(val=1, left=level1_child1, right=level1_child2)

        solution = Solution()

        result = solution.delNodes(root, [4, 10, 3])

        self.assertEqual(5, len(result), "Parent tree not included in Forest")
        self.assertEqual(1, result[0].val, "Parent root not preserved")
        self.assertIsNone(result[0].left.left, "Leaf node not chopped off")

    def test_should_delete_nodes_as_consecutive_children(self):
        level3_child1 = TreeNode(val=8)
        level3_child2 = TreeNode(val=9)
        level3_child3 = TreeNode(val=10)
        level3_child4 = TreeNode(val=11)
        level3_child5 = TreeNode(val=12)
        level3_child6 = TreeNode(val=13)
        level3_child7 = TreeNode(val=14)
        level3_child8 = TreeNode(val=15)

        level2_child1 = TreeNode(val=4, left=level3_child1, right=level3_child2)
        level2_child2 = TreeNode(val=5, left=level3_child3, right=level3_child4)
        level2_child3 = TreeNode(val=6, left=level3_child5, right=level3_child6)
        level2_child4 = TreeNode(val=6, left=level3_child7, right=level3_child8)

        level1_child1 = TreeNode(val=2, left=level2_child1, right=level2_child2)
        level1_child2 = TreeNode(val=3, left=level2_child3, right=level2_child4)

        root = TreeNode(val=1, left=level1_child1, right=level1_child2)

        solution = Solution()

        result = solution.delNodes(root, [2, 4, 10, 3])

        self.assertEqual(6, len(result), "Parent tree not included in Forest")
        self.assertEqual(1, result[0].val, "Parent root not preserved")
        self.assertIsNone(result[0].left, "Leaf node not chopped off")

    def test_should_delete_all_trees_and_report_forest_barren(self):
        level3_child1 = TreeNode(val=8)
        level3_child2 = TreeNode(val=9)
        level3_child3 = TreeNode(val=10)
        level3_child4 = TreeNode(val=11)
        level3_child5 = TreeNode(val=12)
        level3_child6 = TreeNode(val=13)
        level3_child7 = TreeNode(val=14)
        level3_child8 = TreeNode(val=15)

        level2_child1 = TreeNode(val=4, left=level3_child1, right=level3_child2)
        level2_child2 = TreeNode(val=5, left=level3_child3, right=level3_child4)
        level2_child3 = TreeNode(val=6, left=level3_child5, right=level3_child6)
        level2_child4 = TreeNode(val=6, left=level3_child7, right=level3_child8)

        level1_child1 = TreeNode(val=2, left=level2_child1, right=level2_child2)
        level1_child2 = TreeNode(val=3, left=level2_child3, right=level2_child4)

        root = TreeNode(val=1, left=level1_child1, right=level1_child2)

        solution = Solution()

        result = solution.delNodes(root, [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15])

        self.assertEqual(0, len(result), "Forest not reported barren")

    def test_should_report_single_tree_forest_when_none_cut(self):
        level3_child1 = TreeNode(val=8)
        level3_child2 = TreeNode(val=9)
        level3_child3 = TreeNode(val=10)
        level3_child4 = TreeNode(val=11)
        level3_child5 = TreeNode(val=12)
        level3_child6 = TreeNode(val=13)
        level3_child7 = TreeNode(val=14)
        level3_child8 = TreeNode(val=15)

        level2_child1 = TreeNode(val=4, left=level3_child1, right=level3_child2)
        level2_child2 = TreeNode(val=5, left=level3_child3, right=level3_child4)
        level2_child3 = TreeNode(val=6, left=level3_child5, right=level3_child6)
        level2_child4 = TreeNode(val=6, left=level3_child7, right=level3_child8)

        level1_child1 = TreeNode(val=2, left=level2_child1, right=level2_child2)
        level1_child2 = TreeNode(val=3, left=level2_child3, right=level2_child4)

        root = TreeNode(val=1, left=level1_child1, right=level1_child2)

        solution = Solution()

        result = solution.delNodes(root, [20, 21])

        self.assertEqual(1, len(result), "Single tree forest not reported")
