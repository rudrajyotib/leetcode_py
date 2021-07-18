from unittest import TestCase

from medium.tree.btree_kth_smallest_index_bst import TreeNode, Solution


class TestSolution(TestCase):
    def test_should_find_kth_smallest_element_in_complete_tree(self):
        level2_child1 = TreeNode(val=1)
        level2_child2 = TreeNode(val=3)
        level2_child3 = TreeNode(val=5)
        level2_child4 = TreeNode(val=7)

        level1_child1 = TreeNode(val=2, left=level2_child1, right=level2_child2)
        level1_child2 = TreeNode(val=6, left=level2_child3, right=level2_child4)

        root = TreeNode(val=4, left=level1_child1, right=level1_child2)

        solution = Solution()
        self.assertEqual(2, solution.kthSmallest(root=root, k=2), "kth element not found")

    def test_should_handle_single_node(self):
        solution = Solution()
        self.assertEqual(1, solution.kthSmallest(root=TreeNode(val=1), k=1), "k-th element not found in single node "
                                                                             "tree")
