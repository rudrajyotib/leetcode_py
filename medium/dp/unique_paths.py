from typing import List


class Solution:
    def uniquePaths(self, m: int, n: int) -> int:

        if m == 1 and n == 1:
            return 1
        if m == 1:
            return 1
        if n == 1:
            return 1
        result: List[List[int]] = [[1 for _ in range(n)]]
        for i in range(1, m, 1):
            result.append([1 if _ == 0 else 0 for _ in range(n)])
        for outer_index in range(1, m, 1):
            for inner_index in range(1, n, 1):
                result[outer_index][inner_index] = result[outer_index - 1][inner_index] + result[outer_index][
                    inner_index - 1]

        return result[m - 1][n - 1]
