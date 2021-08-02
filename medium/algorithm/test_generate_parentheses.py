from unittest import TestCase

from generate_parentheses import Solution


class TestSolution(TestCase):
    def test_generate_parenthesis(self):
        solution = Solution()
        self.assertEqual(5, len(solution.generateParenthesis(n=3)))
        self.assertEqual(2, len(solution.generateParenthesis(n=2)))
        self.assertEqual(1, len(solution.generateParenthesis(n=1)))
