from unittest import TestCase

from medium.dp.predict_the_winner import Solution


class TestSolution(TestCase):
    def test_predict_the_winner(self):
        solution = Solution()
        self.assertFalse(solution.PredictTheWinner(nums=[3, 7, 3]))
        self.assertTrue(solution.PredictTheWinner(nums=[3, 9, 1, 2]))
        self.assertTrue(solution.PredictTheWinner(nums=[1, 2]))
        self.assertTrue(solution.PredictTheWinner(nums=[2, 2]))
        self.assertTrue(solution.PredictTheWinner(nums=[2]))
