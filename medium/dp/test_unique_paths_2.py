from unittest import TestCase

from medium.dp.unique_paths_2 import Solution


class TestSolution(TestCase):
    def test_unique_paths_with_obstacles(self):
        solution = Solution()
        self.assertEqual(2, solution.uniquePathsWithObstacles(obstacleGrid=[[0, 0, 0], [0, 1, 0], [0, 0, 0]]))
        self.assertEqual(1, solution.uniquePathsWithObstacles(obstacleGrid=[[0, 0, 0, 0]]))
        self.assertEqual(0, solution.uniquePathsWithObstacles(obstacleGrid=[[0, 0, 1, 0, 0]]))
        self.assertEqual(0, solution.uniquePathsWithObstacles(obstacleGrid=[[0], [0], [1], [0], [0]]))
        self.assertEqual(1, solution.uniquePathsWithObstacles(obstacleGrid=[[0], [0], [0], [0], [0]]))
        self.assertEqual(1, solution.uniquePathsWithObstacles(obstacleGrid=[[0]]))
        self.assertEqual(0, solution.uniquePathsWithObstacles(obstacleGrid=[[1]]))
        self.assertEqual(1, solution.uniquePathsWithObstacles(obstacleGrid=[[0, 1], [0, 0]]))
