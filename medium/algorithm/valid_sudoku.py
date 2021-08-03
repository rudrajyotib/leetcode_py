from typing import List


class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        column_verification: List[List[bool]] = [[False for _ in range(9)] for _ in range(9)]
        row_verification: List[List[bool]] = [[False for _ in range(9)] for _ in range(9)]
        internal_cells_verification = [[False for _ in range(9)] for _ in range(9)]

        for outer_index in range(9):
            cell_column_coeffiecient = (outer_index // 3) * 3
            for inner_index in range(9):
                character = board[outer_index][inner_index]
                if character == '.':
                    continue
                else:
                    number = ord(character) - 49
                    if row_verification[outer_index][number]:
                        return False
                    row_verification[outer_index][number] = True
                    if column_verification[8 - inner_index][number]:
                        return False
                    column_verification[8 - inner_index][number] = True
                    cell_number = (inner_index // 3) + cell_column_coeffiecient
                    if internal_cells_verification[cell_number][number]:
                        return False
                    internal_cells_verification[cell_number][number] = True

        return True
