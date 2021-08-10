import collections
from typing import List


class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        row_limit = len(mat)
        col_limit = len(mat[0])
        result = [[-1 for _ in range(col_limit)] for _ in range(row_limit)]
        enqueued = [[False for _ in range(col_limit)] for _ in range(row_limit)]
        queue = collections.deque()

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

        def update_association(start_row: int, start_col: int):
            if 0 <= start_row < row_limit and 0 <= start_col < col_limit:
                if mat[start_row][start_col] == 0:
                    return
                if enqueued[start_row][start_col]:
                    return
                queue.append((start_row, start_col))
                result[start_row][start_col] = 1
                enqueued[start_row][start_col] = True

        for row_index in range(row_limit):
            for col_index in range(col_limit):
                if mat[row_index][col_index] == 0:
                    result[row_index][col_index] = 0
                    update_association(row_index, col_index - 1)
                    update_association(row_index, col_index + 1)
                    update_association(row_index - 1, col_index)
                    update_association(row_index + 1, col_index)
        while queue:
            cell = queue.popleft()
            update_recursive(cell[0] + 1, cell[1], 2)
            update_recursive(cell[0] - 1, cell[1], 2)
            update_recursive(cell[0], cell[1] + 1, 2)
            update_recursive(cell[0], cell[1] - 1, 2)

        return result
