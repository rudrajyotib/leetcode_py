from unittest import TestCase

from medium.tree.btree_smallest_subtree_with_all_the_deepest_nodes import TreeNode, Solution


class TestSolution(TestCase):
    def test_traverse_depth_first_set1(self):
        level5_child1 = TreeNode(val=52)
        level5_child2 = TreeNode(val=53)

        level4_child1 = TreeNode(val=42)
        level4_child2 = TreeNode(val=44)
        level4_child3 = TreeNode(val=35, left=level5_child1)
        level4_child4 = TreeNode(val=40)
        level4_child5 = TreeNode(val=37)
        level4_child6 = TreeNode(val=36, right=level5_child2)

        level3_child1 = TreeNode(val=7)
        level3_child2 = TreeNode(val=28, left=level4_child1, right=level4_child2)
        level3_child3 = TreeNode(val=21, left=level4_child3, right=level4_child4)
        level3_child4 = TreeNode(val=30, left=level4_child5, right=level4_child6)

        level2_child1 = TreeNode(val=5)
        level2_child2 = TreeNode(val=29, left=level3_child1)
        level2_child3 = TreeNode(val=25, left=level3_child2)
        level2_child4 = TreeNode(val=24, left=level3_child3, right=level3_child4)

        level1_child1 = TreeNode(val=6, left=level2_child1, right=level2_child2)
        level1_child2 = TreeNode(val=4, left=level2_child3, right=level2_child4)

        root = TreeNode(val=12, left=level1_child1, right=level1_child2)

        solution = Solution()

        result = solution.subtreeWithAllDeepest(root)

        self.assertIsNotNone(result, "common root not found")
        self.assertEqual(24, result.val, "correct common root not found")

    def test_traverse_depth_first_set2(self):
        level5_child1 = TreeNode(val=57)
        level5_child2 = TreeNode(val=52)
        level5_child3 = TreeNode(val=53)

        level4_child1 = TreeNode(val=42, left=level5_child1)
        level4_child2 = TreeNode(val=44)
        level4_child3 = TreeNode(val=35, left=level5_child2)
        level4_child4 = TreeNode(val=40)
        level4_child5 = TreeNode(val=37)
        level4_child6 = TreeNode(val=36, right=level5_child3)

        level3_child1 = TreeNode(val=7)
        level3_child2 = TreeNode(val=28, left=level4_child1, right=level4_child2)
        level3_child3 = TreeNode(val=21, left=level4_child3, right=level4_child4)
        level3_child4 = TreeNode(val=30, left=level4_child5, right=level4_child6)

        level2_child1 = TreeNode(val=5)
        level2_child2 = TreeNode(val=29, left=level3_child1)
        level2_child3 = TreeNode(val=25, left=level3_child2)
        level2_child4 = TreeNode(val=24, left=level3_child3, right=level3_child4)

        level1_child1 = TreeNode(val=6, left=level2_child1, right=level2_child2)
        level1_child2 = TreeNode(val=4, left=level2_child3, right=level2_child4)

        root = TreeNode(val=12, left=level1_child1, right=level1_child2)

        solution = Solution()

        result = solution.subtreeWithAllDeepest(root)

        self.assertIsNotNone(result, "common root not found")
        self.assertEqual(4, result.val, "correct common root not found")

    def test_traverse_depth_first_set4(self):
        level5_child1 = TreeNode(val=59)
        level5_child2 = TreeNode(val=57)
        level5_child3 = TreeNode(val=52)
        level5_child4 = TreeNode(val=53)

        level4_child1 = TreeNode(val=58, left=level5_child1)
        level4_child2 = TreeNode(val=42, left=level5_child2)
        level4_child3 = TreeNode(val=44)
        level4_child4 = TreeNode(val=35, left=level5_child3)
        level4_child5 = TreeNode(val=40)
        level4_child6 = TreeNode(val=37)
        level4_child7 = TreeNode(val=36, right=level5_child4)

        level3_child1 = TreeNode(val=7, left=level4_child1)
        level3_child2 = TreeNode(val=28, left=level4_child2, right=level4_child3)
        level3_child3 = TreeNode(val=21, left=level4_child4, right=level4_child5)
        level3_child4 = TreeNode(val=30, left=level4_child6, right=level4_child7)

        level2_child1 = TreeNode(val=5)
        level2_child2 = TreeNode(val=29, left=level3_child1)
        level2_child3 = TreeNode(val=25, left=level3_child2)
        level2_child4 = TreeNode(val=24, left=level3_child3, right=level3_child4)

        level1_child1 = TreeNode(val=6, left=level2_child1, right=level2_child2)
        level1_child2 = TreeNode(val=4, left=level2_child3, right=level2_child4)

        root = TreeNode(val=12, left=level1_child1, right=level1_child2)

        solution = Solution()

        result = solution.subtreeWithAllDeepest(root)

        self.assertIsNotNone(result, "common root not found")
        self.assertEqual(12, result.val, "correct common root not found")

    def test_traverse_depth_first_set5(self):
        level5_child4 = TreeNode(val=53)

        level4_child1 = TreeNode(val=58)
        level4_child2 = TreeNode(val=42)
        level4_child3 = TreeNode(val=44)
        level4_child4 = TreeNode(val=35)
        level4_child5 = TreeNode(val=40)
        level4_child6 = TreeNode(val=37)
        level4_child7 = TreeNode(val=36, right=level5_child4)

        level3_child1 = TreeNode(val=7, left=level4_child1)
        level3_child2 = TreeNode(val=28, left=level4_child2, right=level4_child3)
        level3_child3 = TreeNode(val=21, left=level4_child4, right=level4_child5)
        level3_child4 = TreeNode(val=30, left=level4_child6, right=level4_child7)

        level2_child1 = TreeNode(val=5)
        level2_child2 = TreeNode(val=29, left=level3_child1)
        level2_child3 = TreeNode(val=25, left=level3_child2)
        level2_child4 = TreeNode(val=24, left=level3_child3, right=level3_child4)

        level1_child1 = TreeNode(val=6, left=level2_child1, right=level2_child2)
        level1_child2 = TreeNode(val=4, left=level2_child3, right=level2_child4)

        root = TreeNode(val=12, left=level1_child1, right=level1_child2)

        solution = Solution()

        result = solution.subtreeWithAllDeepest(root)

        self.assertIsNotNone(result, "common root not found")
        self.assertEqual(53, result.val, "correct common root not found")

    def test_traverse_depth_first_set6(self):
        level1_child1 = TreeNode(val=20)
        level1_child2 = TreeNode(val=30)
        root = TreeNode(val=10, left=level1_child1, right=level1_child2)
        solution = Solution()
        result = solution.subtreeWithAllDeepest(root=root)
        self.assertIsNotNone(result, "common root not found")
        self.assertEqual(10, result.val, "common root not correct")

    def test_traverse_depth_first_root(self):
        root = TreeNode(val=10)
        solution = Solution()
        result = solution.subtreeWithAllDeepest(root=root)
        self.assertIsNotNone(result, "root not identified")
        self.assertEqual(10, result.val, "root not identified")
