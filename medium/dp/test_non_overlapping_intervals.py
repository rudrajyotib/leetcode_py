from unittest import TestCase

from medium.dp.non_overlapping_intervals import Solution


class TestSolution(TestCase):
    def test_erase_overlap_intervals(self):
        solution = Solution()
        self.assertEqual(1, solution.eraseOverlapIntervals(intervals=[[1, 2], [3, 4], [4, 8], [9, 12], [7, 8], [5, 7]]))
        self.assertEqual(2, solution.eraseOverlapIntervals(intervals=[[1, 2], [3, 8], [4, 6], [7, 8], [5, 7]]))
        self.assertEqual(0, solution.eraseOverlapIntervals(intervals=[[1, 2]]))
        self.assertEqual(0, solution.eraseOverlapIntervals(intervals=[[1, 2], [3, 4]]))
