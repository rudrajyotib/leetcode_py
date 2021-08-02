from unittest import TestCase

from medium.algorithm.letter_combination_for_phone_number import Solution


class TestSolution(TestCase):
    def test_letter_combinations(self):

        solution = Solution()
        self.assertEqual(9, len(solution.letterCombinations("24")))
        self.assertEqual(3, len(solution.letterCombinations("2")))
        self.assertEqual(0, len(solution.letterCombinations("")))
