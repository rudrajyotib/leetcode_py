from typing import List


class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        result: List[List[int]] = [[0 for _ in range(len(word1) + 1)] for _ in range(len(word2) + 1)]
        for i in range(1, len(word1) + 1):
            result[0][i] = i
        for i in range(1, len(word2) + 1):
            result[i][0] = i
        for row_index in range(1, len(word2) + 1, 1):
            for col_index in range(1, len(word1) + 1, 1):
                if word2[row_index-1] == word1[col_index-1]:
                    result[row_index][col_index] = result[row_index - 1][col_index - 1]
                else:
                    result[row_index][col_index] = 1 + min(result[row_index][col_index - 1],
                                                           result[row_index - 1][col_index])
        return result[len(word2)][len(word1)]
