from unittest import TestCase

from medium.dp.jump_game import Solution


class TestSolution(TestCase):
    def test_can_jump(self):

        solution = Solution()
        self.assertTrue(solution.canJump([2, 3, 1, 1, 4]))
        self.assertTrue(solution.canJump([2, 0]))
        self.assertTrue(solution.canJump([2, 0, 1, 1, 0]))
        self.assertFalse(solution.canJump([2, 0, 1, 1, 0, 0]))
        self.assertFalse(solution.canJump([2, 1, 1, 0, 1, 0]))
        self.assertFalse(solution.canJump([0, 0]))
        self.assertFalse(solution.canJump([0, 2, 0, 0]))
        self.assertFalse(solution.canJump([0, 2, 0, 0, 0]))
        self.assertFalse(solution.canJump([0, 2, 0, 0, 0]))
        self.assertFalse(solution.canJump([0, 2, 3]))
