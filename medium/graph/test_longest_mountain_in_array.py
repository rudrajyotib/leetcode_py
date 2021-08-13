from unittest import TestCase

from medium.graph.longest_mountain_in_array import Solution


class TestSolution(TestCase):
    def test_longest_mountain(self):
        solution = Solution()
        self.assertEqual(0, solution.longestMountain(arr=[1, 1, 1]))
        self.assertEqual(0, solution.longestMountain(arr=[1, 1]))
        self.assertEqual(0, solution.longestMountain(arr=[100, 10, 9, 8, 7]))
        self.assertEqual(5, solution.longestMountain(arr=[10, 10, 15, 13, 12, 11, 11, 11, 9]))
