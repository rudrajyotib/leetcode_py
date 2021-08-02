from unittest import TestCase

from medium.algorithm.container_with_most_water import Solution


class TestSolution(TestCase):
    def test_max_area(self):
        solution = Solution()

        self.assertEqual(2, solution.maxArea(height=[1, 0, 2]))
        self.assertEqual(0, solution.maxArea(height=[1, 0, 0]))
        self.assertEqual(35, solution.maxArea(height=[1, 5, 2, 2, 3, 1, 4, 2, 5]))
        self.assertEqual(200, solution.maxArea(height=[1, 5, 2, 2, 100, 1, 100, 2, 5]))
