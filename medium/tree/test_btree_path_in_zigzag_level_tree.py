from unittest import TestCase

from medium.tree.btree_path_in_zigzag_level_tree import Solution


class TestSolution(TestCase):
    def test_path_in_zig_zag_tree_set1(self):
        solution = Solution()
        self.assertEqual([1, 3, 5, 13], solution.pathInZigZagTree(13), "path not evaluated")
        self.assertEqual([1, 2], solution.pathInZigZagTree(2), "path not evaluated")
        self.assertEqual([1], solution.pathInZigZagTree(1), "path not evaluated")
        self.assertEqual([1, 2, 6, 11], solution.pathInZigZagTree(11), "path not evaluated")
        self.assertEqual([1, 2, 7, 8, 31], solution.pathInZigZagTree(31), "path not evaluated")
        self.assertEqual([1,3,4,15], solution.pathInZigZagTree(15), "path not evaluated")
        self.assertEqual([1,2, 6, 11, 24], solution.pathInZigZagTree(24), "path not evaluated")
        self.assertEqual([1,2, 6, 10, 27], solution.pathInZigZagTree(27), "path not evaluated")