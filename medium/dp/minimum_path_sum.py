from typing import List


class Solution:
    # noinspection PyMethodMayBeStatic
    def minPathSum(self, grid: List[List[int]]) -> int:

        grid_size = len(grid)
        grid_span = len(grid[0])

        if grid_size == 1:
            result = 0
            for cell in grid[0]:
                result += cell
            return result

        if grid_span == 1:
            result = 0
            for i in range(grid_size):
                result += grid[i][0]
            return result

        for i in range(1, grid_span, 1):
            grid[0][i] += grid[0][i - 1]
        for i in range(1, grid_size, 1):
            grid[i][0] += grid[i - 1][0]

        for outer_index in range(1, grid_size, 1):
            for inner_index in range(1, grid_span, 1):
                grid[outer_index][inner_index] += min(
                    grid[outer_index - 1][inner_index],
                    grid[outer_index][inner_index - 1])

        return grid[grid_size - 1][grid_span - 1]
