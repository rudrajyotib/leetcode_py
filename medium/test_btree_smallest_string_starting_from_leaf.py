from unittest import TestCase

from medium.btree_smallest_string_starting_from_leaf import TreeNode, Solution


class TestSolution(TestCase):
    def test_smallest_from_leaf(self):
        level2_child1 = TreeNode(val=1)
        level2_child2 = TreeNode(val=0)
        level1_child2 = TreeNode(val=0, left=level2_child1, right=level2_child2)
        level1_child1 = TreeNode(val=0)
        root = TreeNode(val=0, left=level1_child1, right=level1_child2)
        solution = Solution()
        smallest_string = solution.smallestFromLeaf(root)
        self.assertEqual('aa', smallest_string, "Smallest string till leaf not derived")

    def test_should_handle_empty_node(self):
        solution = Solution()
        # noinspection PyTypeChecker
        self.assertEqual('', solution.smallestFromLeaf(root=None), 'None not handled')
