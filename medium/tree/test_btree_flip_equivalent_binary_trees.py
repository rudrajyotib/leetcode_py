from unittest import TestCase

from medium.tree.btree_flip_equivalent_binary_trees import TreeNode, Solution


class TestSolution(TestCase):
    def test_should_identify_flip_equivalent_set1(self):
        t1_level1_child1 = TreeNode(val=2)
        t1_level1_child2 = TreeNode(val=3)
        t1_root = TreeNode(val=1, left=t1_level1_child1, right=t1_level1_child2)

        t2_level1_child1 = TreeNode(val=3)
        t2_level1_child2 = TreeNode(val=2)
        t2_root = TreeNode(val=1, left=t2_level1_child1, right=t2_level1_child2)

        solution = Solution()

        self.assertTrue(solution.flipEquiv(root1=t1_root, root2=t2_root))

    def test_should_identify_flip_equivalent_set2(self):
        t1_level2_child1 = TreeNode(val=4)
        t1_level1_child1 = TreeNode(val=2, left=t1_level2_child1)
        t1_level1_child2 = TreeNode(val=3)
        t1_root = TreeNode(val=1, left=t1_level1_child1, right=t1_level1_child2)

        t2_level1_child1 = TreeNode(val=3)
        t2_level1_child2 = TreeNode(val=2)
        t2_root = TreeNode(val=1, left=t2_level1_child1, right=t2_level1_child2)

        solution = Solution()

        self.assertFalse(solution.flipEquiv(root1=t1_root, root2=t2_root))

    def test_should_identify_flip_equivalent_set3(self):
        t1_root = TreeNode(val=1)

        t2_root = TreeNode(val=1)

        solution = Solution()

        self.assertTrue(solution.flipEquiv(root1=t1_root, root2=t2_root))

    def test_should_identify_flip_equivalent_set4(self):
        t1_level3_child1 = TreeNode(val=7)
        t1_level3_child2 = TreeNode(val=8)

        t1_level2_child1 = TreeNode(val=4)
        t1_level2_child2 = TreeNode(val=5, left=t1_level3_child1, right=t1_level3_child2)
        t1_level2_child3 = TreeNode(val=6)

        t1_level1_child1 = TreeNode(val=2, left=t1_level2_child1, right=t1_level2_child2)
        t1_level1_child2 = TreeNode(val=3, right=t1_level2_child3)

        t1_root = TreeNode(val=1, left=t1_level1_child1, right=t1_level1_child2)

        t2_level3_child1 = TreeNode(val=8)
        t2_level3_child2 = TreeNode(val=7)

        t2_level2_child1 = TreeNode(val=6)
        t2_level2_child2 = TreeNode(val=4)
        t2_level2_child3 = TreeNode(val=5, left=t2_level3_child1, right=t2_level3_child2)

        t2_level1_child1 = TreeNode(val=3, right=t2_level2_child1)
        t2_level1_child2 = TreeNode(val=2, left=t2_level2_child2, right=t2_level2_child3)

        t2_root = TreeNode(val=1, left=t2_level1_child1, right=t2_level1_child2)

        solution = Solution()

        self.assertTrue(solution.flipEquiv(root1=t1_root, root2=t2_root))
