from unittest import TestCase

from medium.tree.btree_house_robber_3 import TreeNode, Solution


class TestSolution(TestCase):
    def test_should_calculate_max_rob_layout1(self):
        level4_child1 = TreeNode(val=1000)
        level4_child2 = TreeNode(val=1000)

        level3_child1 = TreeNode(val=120, right=level4_child1)
        level3_child2 = TreeNode(val=140, right=level4_child2)

        level2_child1 = TreeNode(val=14, left=level3_child1)
        level2_child2 = TreeNode(val=16, right=level3_child2)

        level1_child1 = TreeNode(val=12, left=level2_child1)
        level1_child2 = TreeNode(val=13, right=level2_child2)

        root = TreeNode(val=100, left=level1_child1, right=level1_child2)

        solution = Solution()

        self.assertEqual(2130, solution.rob(root=root), "Max rob not collected")

    def test_should_calculate_max_rob_layout2(self):
        level3_child1 = TreeNode(val=101)
        level3_child2 = TreeNode(val=101)
        level3_child3 = TreeNode(val=101)
        level3_child4 = TreeNode(val=101)
        level3_child5 = TreeNode(val=101)
        level3_child6 = TreeNode(val=101)
        level3_child7 = TreeNode(val=101)
        level3_child8 = TreeNode(val=101)

        level2_child1 = TreeNode(val=99, left=level3_child1, right=level3_child2)
        level2_child2 = TreeNode(val=99, left=level3_child3, right=level3_child4)
        level2_child3 = TreeNode(val=99, left=level3_child5, right=level3_child6)
        level2_child4 = TreeNode(val=99, left=level3_child7, right=level3_child8)

        level1_child1 = TreeNode(val=100, left=level2_child1, right=level2_child2)
        level1_child2 = TreeNode(val=100, left=level2_child3, right=level2_child4)

        root = TreeNode(val=0, left=level1_child1, right=level1_child2)

        solution = Solution()

        self.assertEqual(1008, solution.rob(root=root), "Max rob not calculated")
