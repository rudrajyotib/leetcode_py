from unittest import TestCase

from medium.btree_longest_univalue_path import TreeNode, Solution


class TestSolution(TestCase):
    def test_longest_uni_value_path_basic(self):
        level2_child1 = TreeNode(val=3)
        level1_child1 = TreeNode(val=2)
        level1_child2 = TreeNode(val=3, right=level2_child1)
        root = TreeNode(val=1, left=level1_child1, right=level1_child2)
        solution = Solution()
        self.assertEqual(1, solution.longestUnivaluePath(root), "longest univalue path not counted")

    def test_longest_uni_value_path_empty_node(self):
        solution = Solution()
        # noinspection PyTypeChecker
        self.assertEqual(0, solution.longestUnivaluePath(root=None), "Empty node not supported")

    def test_long_uni_value_path_when_all_nodes_are_unique(self):
        level2_child1 = TreeNode(val=4)
        level2_child2 = TreeNode(val=5)
        level2_child3 = TreeNode(val=6)
        level2_child4 = TreeNode(val=7)

        level1_child1 = TreeNode(val=2, left=level2_child1, right=level2_child2)
        level1_child2 = TreeNode(val=3, left=level2_child3, right=level2_child4)

        root = TreeNode(val=0, left=level1_child1, right=level1_child2)

        solution = Solution()

        self.assertEqual(0, solution.longestUnivaluePath(root), "unique nodes not supported")

    def test_long_uni_value_path_for_more_than_one_same_length_path(self):
        level2_child1 = TreeNode(val=2)
        level2_child2 = TreeNode(val=3)
        level2_child3 = TreeNode(val=3)
        level2_child4 = TreeNode(val=4)

        level1_child1 = TreeNode(val=2, left=level2_child1, right=level2_child2)
        level1_child2 = TreeNode(val=3, left=level2_child3, right=level2_child4)

        root = TreeNode(val=1, left=level1_child1, right=level1_child2)

        solution = Solution()
        self.assertEqual(1, solution.longestUnivaluePath(root), "multiple same length path not calculated")

    def test_long_uni_value_path_for_when_both_child_makes_chain(self):
        level2_child1 = TreeNode(val=2)
        level2_child2 = TreeNode(val=2)
        level2_child3 = TreeNode(val=3)
        level2_child4 = TreeNode(val=4)

        level1_child1 = TreeNode(val=2, left=level2_child1, right=level2_child2)
        level1_child2 = TreeNode(val=3, left=level2_child3, right=level2_child4)

        root = TreeNode(val=1, left=level1_child1, right=level1_child2)

        solution = Solution()
        self.assertEqual(2, solution.longestUnivaluePath(root), "multiple same length path not calculated")

    def test_long_uni_value_path_for_when_both_child_makes_chain_and_hierarchy_makes_longer_chain(self):
        level6_child1 = TreeNode(val=3)
        level6_child2 = TreeNode(val=2)

        level5_child1 = TreeNode(val=2)
        level5_child2 = TreeNode(val=2, left=level6_child1)
        level5_child3 = TreeNode(val=2, left=level6_child2)
        level5_child4 = TreeNode(val=3)
        level5_child5 = TreeNode(val=3)

        level4_child1 = TreeNode(val=2, left=level5_child1)
        level4_child2 = TreeNode(val=2, left=level5_child2, right=level5_child3)
        level4_child3 = TreeNode(val=2, left=level5_child4, right=level5_child5)

        level3_child1 = TreeNode(val=2, left=level4_child1)
        level3_child2 = TreeNode(val=2, left=level4_child2, right=level4_child3)

        level2_child1 = TreeNode(val=2, left=level3_child1, right=level3_child2)

        level1_child1 = TreeNode(val=2, left=level2_child1)

        root = TreeNode(val=1, left=level1_child1)

        solution = Solution()
        self.assertEqual(7, solution.longestUnivaluePath(root), "sub-tree solution not calculated")
