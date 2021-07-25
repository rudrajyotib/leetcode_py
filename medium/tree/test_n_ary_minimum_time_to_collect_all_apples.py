from unittest import TestCase

from medium.tree.n_ary_minimum_time_to_collect_all_apples import Solution


class TestSolution(TestCase):
    def test_min_time(self):
        solution = Solution()
        self.assertEqual(6, solution.minTime(n=6, edges=[[0, 1], [2, 0], [0, 3], [4, 2], [5, 3]],
                                             hasApple=[False, False, True, True, True, False]))
        self.assertEqual(0, solution.minTime(n=1, edges=[], hasApple=[False]))
