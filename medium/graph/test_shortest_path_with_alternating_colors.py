from unittest import TestCase

from medium.graph.shortest_path_with_alternating_colors import Solution


class TestSolution(TestCase):
    def test_shortest_alternating_paths_set1(self):
        solution = Solution()
        result = solution.shortestAlternatingPaths(n=6, red_edges=[[0, 1], [0, 2], [1, 3], [2, 4]],
                                                   blue_edges=[[0, 1], [0, 3], [3, 4], [3, 5]])
        self.assertEqual([0, 1, 1, 1, 3, 3], result)

    def test_shortest_alternating_paths_set2(self):
        solution = Solution()
        result = solution.shortestAlternatingPaths(n=8,
                                                   red_edges=[[0, 1], [0, 2], [1, 3], [3, 4], [3, 5]],
                                                   blue_edges=[[0, 1], [0, 2], [1, 0], [2, 0], [1, 2], [1, 3], [3, 4],
                                                               [4, 5], [5, 6], [6, 7]])
        self.assertEqual([0, 1, 1, 2, 3, 3, 4, -1], result)
