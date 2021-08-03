from typing import List


class Solution:
    def uniquePaths(self, m: int, n: int) -> int:

        if m == 1 and n == 1:
            return 1
        if m == 1:
            return 1
        if n == 1:
            return 1
        result: List[List[int]] = [[0 for _ in range(n)] for _ in range(m)]
        result[0][0] = 1
        for i in range(1, n, 1):
            result[0][i] += result[0][i - 1]
        for i in range(1, m, 1):
            result[i][0] += result[i - 1][0]
        for outer_index in range(1, m, 1):
            for inner_index in range(1, n, 1):
                result[outer_index][inner_index] = result[outer_index - 1][inner_index] + result[outer_index][
                    inner_index - 1]

        return result[m - 1][n - 1]
