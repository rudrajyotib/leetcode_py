from unittest import TestCase

from medium.graph.reorder_routes_to_make_all_paths_towards_orig_city import Solution


class TestSolution(TestCase):
    def test_min_reorder(self):
        solution = Solution()
        self.assertEqual(2, solution.minReorder(n=5, connections=[[1, 0], [1, 2], [3, 2], [3, 4]]))
        self.assertEqual(3, solution.minReorder(n=6, connections=[[0, 1], [1, 3], [2, 3], [4, 0], [4, 5]]))
        self.assertEqual(0, solution.minReorder(n = 3, connections=[[1, 0], [2, 0], ]))
        self.assertEqual(1, solution.minReorder(n = 3, connections=[[1, 0], [0, 2], ]))
