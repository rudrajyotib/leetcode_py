import math
from typing import List


class Solution:
    memory: List[List[int]]

    # noinspection PyMethodMayBeStatic
    def minimumTotal(self, triangle: List[List[int]]) -> int:

        if len(triangle) == 1:
            return triangle[0][0]

        Solution.memory = [[math.inf for _ in range(__ + 1)] for __ in range(len(triangle))]

        def traverse_till_end_recursive(row_index: int, col_index: int, max_depth: int) -> int:
            if row_index == max_depth - 1:
                return triangle[row_index][col_index]
            if Solution.memory[row_index][col_index] != math.inf:
                return Solution.memory[row_index][col_index]
            result = triangle[row_index][col_index] + min(
                traverse_till_end_recursive(row_index + 1, col_index, max_depth),
                traverse_till_end_recursive(row_index + 1, col_index + 1, max_depth))
            Solution.memory[row_index][col_index] = result
            return result

        return traverse_till_end_recursive(row_index=0, col_index=0, max_depth=len(triangle))
