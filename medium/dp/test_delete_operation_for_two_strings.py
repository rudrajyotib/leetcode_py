from unittest import TestCase

from medium.dp.delete_operation_for_two_strings import Solution


class TestSolution(TestCase):
    def test_min_distance(self):
        solution = Solution()
        self.assertEqual(0, solution.minDistance(word1="a", word2="a"))
        self.assertEqual(2, solution.minDistance(word1="example", word2="ample"))
        self.assertEqual(6, solution.minDistance(word1="example", word2="amplify"))
        self.assertEqual(6, solution.minDistance(word1="example", word2="amplified"))
