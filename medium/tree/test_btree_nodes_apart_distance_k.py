from unittest import TestCase

from medium.tree.btree_nodes_apart_distance_k import TreeNode, Solution


class TestSolution(TestCase):
    def test_should_find_nodes_at_distance_set1(self):
        level3_child1 = TreeNode(7)
        level3_child2 = TreeNode(21)
        level3_child3 = TreeNode(30)

        level2_child1 = TreeNode(5)
        level2_child2 = TreeNode(9)
        level2_child3 = TreeNode(15)
        level2_child4 = TreeNode(24)

        level2_child2.left = level3_child1
        level2_child4.left = level3_child2
        level2_child4.right = level3_child3

        level1_child1 = TreeNode(6)
        level1_child2 = TreeNode(18)

        level1_child1.left = level2_child1
        level1_child1.right = level2_child2
        level1_child2.left = level2_child3
        level1_child2.right = level2_child4

        root = TreeNode(12)
        root.left = level1_child1
        root.right = level1_child2

        solution = Solution()

        result = solution.distanceK(root=root, target=level1_child1, k=2)

        self.assertEqual(2, len(result))
        self.assertTrue(18 in result, "right child node not added")
        self.assertTrue(7 in result, "child node at distance not added")

    def test_should_find_nodes_at_distance_set2(self):

        level5_child1 = TreeNode(52)

        level4_child1 = TreeNode(42)
        level4_child2 = TreeNode(44)
        level4_child3 = TreeNode(35)
        level4_child4 = TreeNode(40)
        level4_child5 = TreeNode(37)
        level4_child6 = TreeNode(36)

        level4_child3.left = level5_child1

        level3_child1 = TreeNode(7)
        level3_child2 = TreeNode(28)
        level3_child3 = TreeNode(21)
        level3_child4 = TreeNode(30)

        level3_child2.left = level4_child1
        level3_child2.right = level4_child2
        level3_child3.left = level4_child3
        level3_child3.right = level4_child4
        level3_child4.left = level4_child5
        level3_child4.right = level4_child6

        level2_child1 = TreeNode(5)
        level2_child2 = TreeNode(29)
        level2_child3 = TreeNode(35)
        level2_child4 = TreeNode(24)

        level2_child2.left = level3_child1
        level2_child3.left = level3_child2
        level2_child4.left = level3_child3
        level2_child4.right = level3_child4

        level1_child1 = TreeNode(6)
        level1_child2 = TreeNode(18)

        level1_child1.left = level2_child1
        level1_child1.right = level2_child2
        level1_child2.left = level2_child3
        level1_child2.right = level2_child4

        root = TreeNode(12)
        root.left = level1_child1
        root.right = level1_child2

        solution = Solution()
        result = solution.distanceK(root=root, target=level2_child4, k=3)

        self.assertEqual(3, len(result), "not all target possible nodes found")

    def test_should_find_nodes_at_distance_set3(self):

        level5_child1 = TreeNode(52)

        level4_child1 = TreeNode(42)
        level4_child2 = TreeNode(44)
        level4_child3 = TreeNode(35)
        level4_child4 = TreeNode(40)
        level4_child5 = TreeNode(37)
        level4_child6 = TreeNode(36)

        level4_child3.left = level5_child1

        level3_child1 = TreeNode(7)
        level3_child2 = TreeNode(28)
        level3_child3 = TreeNode(21)
        level3_child4 = TreeNode(30)

        level3_child2.left = level4_child1
        level3_child2.right = level4_child2
        level3_child3.left = level4_child3
        level3_child3.right = level4_child4
        level3_child4.left = level4_child5
        level3_child4.right = level4_child6

        level2_child1 = TreeNode(5)
        level2_child2 = TreeNode(29)
        level2_child3 = TreeNode(35)
        level2_child4 = TreeNode(24)

        level2_child2.left = level3_child1
        level2_child3.left = level3_child2
        level2_child4.left = level3_child3
        level2_child4.right = level3_child4

        level1_child1 = TreeNode(6)
        level1_child2 = TreeNode(18)

        level1_child1.left = level2_child1
        level1_child1.right = level2_child2
        level1_child2.left = level2_child3
        level1_child2.right = level2_child4

        root = TreeNode(12)
        root.left = level1_child1
        root.right = level1_child2

        solution = Solution()
        result = solution.distanceK(root=root, target=root, k=2)

        self.assertEqual(4, len(result), "not all target possible nodes found")