from typing import List
from unittest import TestCase

from medium.tree.btree_find_duplicate_subtrees import TreeNode, Solution


class TestSolution(TestCase):

    def test_should_find_duplicate_sub_trees_set1(self):
        level4_child1 = TreeNode(val=6)
        level4_child2 = TreeNode(val=6)

        level3_child1 = TreeNode(val=3)
        level3_child2 = TreeNode(val=4)
        level3_child3 = TreeNode(val=4, left=level4_child1, right=level4_child2)

        level2_child1 = TreeNode(val=3)
        level2_child2 = TreeNode(val=4)
        level2_child3 = TreeNode(val=2, left=level3_child1, right=level3_child2)
        level2_child4 = TreeNode(val=8, right=level3_child3)

        level1_child1 = TreeNode(val=2, left=level2_child1, right=level2_child2)
        level1_child2 = TreeNode(val=5, left=level2_child3, right=level2_child4)

        root = TreeNode(val=1, left=level1_child1, right=level1_child2)

        solution = Solution()

        result_nodes: List[TreeNode] = solution.findDuplicateSubtrees(root=root)

        self.assertEqual(4, len(result_nodes), "Not all common sub-trees identified")

        result_nodes_sorted = sorted(list(map(lambda x: x.val, result_nodes)))

        self.assertEqual([2, 3, 4, 6], result_nodes_sorted, "Not all nodes identified as root of duplicate")

    def test_should_identify_as_no_common_root(self):
        level2_child1 = TreeNode(val=4)
        level2_child2 = TreeNode(val=5)
        level2_child3 = TreeNode(val=6)
        level2_child4 = TreeNode(val=7)

        level1_child1 = TreeNode(val=2, left=level2_child1, right=level2_child2)
        level1_child2 = TreeNode(val=3, left=level2_child3, right=level2_child4)

        root = TreeNode(val=1, left=level1_child1, right=level1_child2)

        solution = Solution()

        self.assertEqual(0, len(solution.findDuplicateSubtrees(root)), "unwanted sub-trees added")

    def test_should_identify_only_child_nodes_as_common(self):
        level1_child1 = TreeNode(val=1)
        level1_child2 = TreeNode(val=1)

        root = TreeNode(val=1, left=level1_child1, right=level1_child2)

        solution = Solution()

        result = solution.findDuplicateSubtrees(root)

        self.assertEqual(1, len(result), "count of child nodes not identified as duplicate")
        self.assertEqual(1, result[0].val, "child node value altered")
        self.assertIsNone(result[0].left, "leaf node not identified as subtree")
        self.assertIsNone(result[0].right, "leaf node not identified as subtree")