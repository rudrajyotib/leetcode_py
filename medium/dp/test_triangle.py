from unittest import TestCase

from medium.dp.triangle import Solution


class TestSolution(TestCase):
    def test_minimum_total(self):
        solution = Solution()
        self.assertEqual(1, solution.minimumTotal(triangle=[[1]]))
        self.assertEqual(2, solution.minimumTotal([[1], [1, 2]]))
        self.assertEqual(11, solution.minimumTotal([[2], [3, 4], [6, 5, 7], [4, 1, 8, 3]]))
        self.assertEqual(-10, solution.minimumTotal([[-10]]))
