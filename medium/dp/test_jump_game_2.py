from unittest import TestCase

from medium.dp.jump_game_2 import Solution


class TestSolution(TestCase):
    def test_jump(self):
        solution = Solution()
        self.assertEqual(2, solution.jump(nums=[2, 3, 1, 1, 4]))
        self.assertEqual(2, solution.jump(nums=[2, 3, 1, 0, 4]))
        self.assertEqual(3, solution.jump(nums=[2, 2, 1, 1, 4]))
