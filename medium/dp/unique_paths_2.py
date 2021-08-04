from typing import List


class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:

        grid_size = len(obstacleGrid)
        grid_span = len(obstacleGrid[0])
        solution_grid = [[0 for _ in range(grid_span)] for _ in range(grid_size)]
        first_obstacle_detected = False
        for i in range(grid_span):
            if obstacleGrid[0][i] == 0:
                solution_grid[0][i] = 1
            else:
                first_obstacle_detected = True
                break
        if grid_size == 1:
            if first_obstacle_detected:
                return 0
            else:
                return 1
        first_obstacle_detected = False
        for i in range(grid_size):
            if obstacleGrid[i][0] == 0:
                solution_grid[i][0] = 1
            else:
                first_obstacle_detected = True
                break
        if grid_span == 1:
            if first_obstacle_detected:
                return 0
            else:
                return 1

        for outer_index in range(1, grid_size, 1):
            for inner_index in range(1, grid_span, 1):
                if obstacleGrid[outer_index][inner_index] == 1:
                    solution_grid[outer_index][inner_index] = 0
                else:
                    solution_grid[outer_index][inner_index] = (
                            solution_grid[outer_index][inner_index - 1] +
                            solution_grid[outer_index - 1][inner_index])

        return solution_grid[grid_size-1][grid_span-1]
