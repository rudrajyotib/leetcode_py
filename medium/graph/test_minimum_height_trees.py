from unittest import TestCase

from medium.graph.minimum_height_trees import Solution


class TestSolution(TestCase):
    def test_find_min_height_trees_set1(self):
        solution = Solution()
        result = solution.findMinHeightTrees(n=6, edges=[[0, 1],
                                                         [0, 2],
                                                         [0, 3],
                                                         [3, 4],
                                                         [3, 5]])
        self.assertEqual(2, len(result))
        self.assertTrue(0 in result)
        self.assertTrue(3 in result)

    def test_find_min_height_trees_set2(self):
        solution = Solution()
        result = solution.findMinHeightTrees(n=5, edges=[[0, 1],
                                                         [0, 2],
                                                         [0, 3],
                                                         [0, 4]])
        self.assertEqual(1, len(result))
        self.assertTrue(0 in result)
