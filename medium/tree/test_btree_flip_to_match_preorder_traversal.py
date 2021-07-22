from unittest import TestCase

from medium.tree.btree_flip_to_match_preorder_traversal import TreeNode, Solution


class TestSolution(TestCase):
    def test_should_find_flips_set1(self):
        root = TreeNode(val=1)
        solution = Solution()
        self.assertEqual([-1], solution.flipMatchVoyage(root=root, voyage=[2]), "Impossible flip asserted")

    def test_should_find_flips_set2(self):
        level1_child1 = TreeNode(val=2)
        root = TreeNode(val=1, left=level1_child1)
        solution = Solution()
        self.assertEqual([-1], solution.flipMatchVoyage(root=root, voyage=[1, 3]), "Impossible flip asserted")

    def test_should_find_flips_set3(self):
        level3_child1 = TreeNode(val=9)
        level3_child2 = TreeNode(val=8)

        level2_child1 = TreeNode(val=6)
        level2_child2 = TreeNode(val=7, left=level3_child1, right=level3_child2)
        level2_child3 = TreeNode(val=4)
        level2_child4 = TreeNode(val=5)

        level1_child1 = TreeNode(val=3, left=level2_child1, right=level2_child2)
        level1_child2 = TreeNode(val=2, left=level2_child3, right=level2_child4)

        root = TreeNode(val=1, left=level1_child1, right=level1_child2)

        solution = Solution()
        self.assertEqual([1, 7], solution.flipMatchVoyage(root=root, voyage=[1, 2, 4, 5, 3, 6, 7, 8, 9]),
                         "Flips not identified")

    def test_should_find_flips_set4(self):
        root = TreeNode(val=1)
        solution = Solution()
        self.assertEqual([], solution.flipMatchVoyage(root=root, voyage=[1]), "no flip needed")
