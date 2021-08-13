from unittest import TestCase

from medium.algorithm.bulls_and_cows import Solution


class TestSolution(TestCase):
    def test_get_hint(self):
        solution = Solution()
        self.assertEqual("2A0B", solution.getHint(secret="90", guess="90"))
        self.assertEqual("1A3B", solution.getHint(secret="1807", guess="7810"))
        self.assertEqual("1A0B", solution.getHint(secret="1", guess="1"))
        self.assertEqual("0A0B", solution.getHint(secret="1", guess="8"))
