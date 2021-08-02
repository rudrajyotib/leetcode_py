from unittest import TestCase

from medium.algorithm.sum_3_closest import Solution


class TestSolution(TestCase):
    def test_three_sum_closest(self):
        solution = Solution()
        self.assertEqual(0, solution.threeSumClosest(nums=[0, 1, 2, 3, 4, 5, 6, 7, 8, -1, -2, -3, -4, -5],
                                                     target=0))

        self.assertEqual(21, solution.threeSumClosest(nums=[0, 1, 2, 3, 4, 5, 6, 7, 8, -1, -2, -3, -4, -5],
                                                      target=25))

        self.assertEqual(-12, solution.threeSumClosest(nums=[0, 1, 2, 3, 4, 5, 6, 7, 8, -1, -2, -3, -4, -5],
                                                       target=-100))
