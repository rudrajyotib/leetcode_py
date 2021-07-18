from typing import List
from unittest import TestCase

from medium.algorithm.rec_add_parantheses import Solution


class TestSolution(TestCase):
    def test_diff_ways_to_compute_var1(self):
        solution = Solution()
        result: List[int] = solution.diffWaysToCompute("1+2+3")
        self.assertEqual(2, len(result), "List not generated")
        self.assertEqual(6, result[0], "Not calculated")
        self.assertEqual(6, result[1], "Not calculated")

    def test_diff_ways_to_compute_var2(self):
        solution = Solution()
        result: List[int] = solution.diffWaysToCompute("1+2+3*4")
        self.assertEqual(5, len(result), "List not generated")
        self.assertTrue(21 in result, "not calculated")

    def test_should_handle_single_expression(self):
        solution = Solution()
        result: List[int] = solution.diffWaysToCompute("1")
        self.assertEqual(1, len(result))
        self.assertEqual(1, result[0])
