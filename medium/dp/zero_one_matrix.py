from typing import List


class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        row_limit = len(mat)
        col_limit = len(mat[0])
        result = [[-1 for _ in range(col_limit)] for _ in range(row_limit)]

        def update_recursive(start_row: int, start_col: int, path_length: int):
            if 0 <= start_row < row_limit and 0 <= start_col < col_limit:
                if mat[start_row][start_col] == 0:
                    return
                if result[start_row][start_col] > path_length or result[start_row][start_col] == -1:
                    result[start_row][start_col] = path_length
                    update_recursive(start_row, start_col - 1, result[start_row][start_col] + 1)
                    update_recursive(start_row, start_col + 1, result[start_row][start_col] + 1)
                    update_recursive(start_row - 1, start_col, result[start_row][start_col] + 1)
                    update_recursive(start_row + 1, start_col, result[start_row][start_col] + 1)

        for row_index in range(row_limit):
            for col_index in range(col_limit):
                if mat[row_index][col_index] == 0:
                    result[row_index][col_index] = 0
                    update_recursive(row_index, col_index - 1, 1)
                    update_recursive(row_index, col_index + 1, 1)
                    update_recursive(row_index - 1, col_index, 1)
                    update_recursive(row_index + 1, col_index, 1)

        return result
