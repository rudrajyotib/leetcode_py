from unittest import TestCase

from medium.algorithm.decode_ways import Solution


class TestSolution(TestCase):
    def test_num_decodings(self):
        solution = Solution()
        self.assertEqual(2, solution.numDecodings(s="11"))
        self.assertEqual(1, solution.numDecodings(s="10"))
        self.assertEqual(0, solution.numDecodings(s="011"))
        self.assertEqual(1, solution.numDecodings(s="110"))
        self.assertEqual(0, solution.numDecodings(s="1100"))
        self.assertEqual(0, solution.numDecodings(s="1230"))
        self.assertEqual(3, solution.numDecodings(s="1234"))
        self.assertEqual(5, solution.numDecodings(s="1212"))
